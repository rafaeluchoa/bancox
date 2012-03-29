package com.naskar.infrastructure.ui;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.naskar.infrastructure.domain.EntityDomain;
import com.naskar.infrastructure.exception.ApplicationException;
import com.naskar.infrastructure.service.EntityDomainService;
import com.naskar.infrastructure.spring.BeanFactory;
import com.naskar.infrastructure.utils.ReflectionUtils;

/**
 * @author rafaeluchoa
 */
public class EntityController<
	E extends EntityDomain, 
	ListView extends EntityListView, 
	FormView extends EntityFormView<E>,
	EntityService extends EntityDomainService<E>>  
	implements Controller, InitializingBean, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final Class<E> clazzE;
	private final Class<ListView> clazzListView;
	private final Class<FormView> clazzFormView;
	private final Class<EntityService> clazzServiceView;
	
	private EntityService entityService;
	
	@Autowired
	private BeanFactory beanFactory;
	
	@Autowired
	private ViewFactory viewFactory;
	
	@Autowired
    private Validator validator;
	
	@SuppressWarnings("unchecked")
	public EntityController() {
		final List<Class<?>> clazzes = 
			ReflectionUtils.getTypeArguments(EntityController.class, getClass());
		clazzE = (Class<E>) clazzes.get(0);
		clazzListView = (Class<ListView>) clazzes.get(1);
		clazzFormView = (Class<FormView>) clazzes.get(2);
		clazzServiceView = (Class<EntityService>) clazzes.get(3);
	}
	
	@Override
	public void afterPropertiesSet() {
		entityService = beanFactory.createBean(clazzServiceView);
	}
	
	public ViewFactory getViewFactory() {
		return viewFactory;
	}

	public void setViewFactory(ViewFactory viewFactory) {
		this.viewFactory = viewFactory;
	}

	public ListView init() {
		return getViewFactory().createView(clazzListView);
	}
	
	public List<E> findAll() {
		return entityService.findAll();
	}
	
	public void showInsert(ListView listView) {
		try {
			showEdit(listView, clazzE.newInstance());
		} catch (InstantiationException e) {
			throw new ApplicationException(e);
		} catch (IllegalAccessException e) {
			throw new ApplicationException(e);
		}
	}

	public void showEdit(ListView listView, E entidade) {
		FormView view = getViewFactory().createView(clazzFormView);
		view.setViewManager(listView.getViewManager());
		view.setEntityListView(listView);
		view.setEntity(entidade);
		listView.getViewManager().addView(view, view.getViewName());
	}
	
	// TODO: criar aspecto para efetuar validacao
	private boolean validate(FormView formView) {
		Set<ConstraintViolation<E>> violations = 
				(Set<ConstraintViolation<E>>) validator.validate(formView.getEntity());
		for (ConstraintViolation<E> violation : violations) {
		    String propertyPath = violation.getPropertyPath().toString();
		    String message = violation.getMessage();
		    formView.getViewManager().showError("Campo inválido: '" + propertyPath + "': " + message);
		}
		return violations.isEmpty();
	}

	public void save(FormView formView) {
		if(!validate(formView)) {
			return;
		}
		
		EntityDomain entidade = formView.getEntity();
		if(entidade.getId() == null) {
			entityService.insert(formView.getEntity());
			formView.getViewManager().removeView(formView);
			formView.getViewManager().showMsg("Inclusão efetuada com sucesso.");	
		} else {
			entityService.update(formView.getEntity());
			formView.getViewManager().removeView(formView);
			formView.getViewManager().showMsg("Alteração efetuada com sucesso.");
		}
		
		EntityListView entityListView = formView.getEntityListView();
		if(entityListView != null) {
			entityListView.refresh();
		}
	}

	public void cancel(FormView formView) {
		formView.getViewManager().removeView(formView);
		EntityListView entityListView = formView.getEntityListView();
		if(entityListView != null) {
			entityListView.refresh();
		}
	}
	
	public void removeAll(ListView listView, List<E> entidades) {
		for(E entidade : entidades) {
			entityService.remove(entidade);
		}
		listView.getViewManager().showMsg("Exclusão efetuada com sucesso.");
	}

}
