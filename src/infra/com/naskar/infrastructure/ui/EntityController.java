package com.naskar.infrastructure.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.naskar.infrastructure.domain.EntityDomain;
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
	EntityService extends EntityDomainService<E>> extends Controller {
	
	private Class<E> clazzE;
	private Class<ListView> clazzListView;
	private Class<FormView> clazzFormView;
	private Class<EntityService> clazzServiceView;
	
	private EntityService entityService;
	
	@Autowired
	private BeanFactory beanFactory;
	
	@SuppressWarnings("unchecked")
	public EntityController() {
		List<Class<?>> clazzes = 
			ReflectionUtils.getTypeArguments(EntityController.class, getClass());
		clazzE = (Class<E>) clazzes.get(0);
		clazzListView = (Class<ListView>) clazzes.get(1);
		clazzFormView = (Class<FormView>) clazzes.get(2);
		clazzServiceView = (Class<EntityService>) clazzes.get(3);
		
		entityService = beanFactory.createBean(clazzServiceView); 
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
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	public void showEdit(ListView listView, E entidade) {
		FormView view = getViewFactory().createView(clazzFormView);
		view.setEntityListView(listView);
		view.setEntity(entidade);
		getViewManager().addView(view, view.getViewName());
	}

	public void save(FormView formView) {
		EntityDomain entidade = formView.getEntity();
		if(entidade.getId() == null) {
			entityService.insert(formView.getEntity());
			getViewManager().removeView(formView);
			getViewManager().showMsg("Inclus�o efetuada com sucesso.");	
		} else {
			entityService.update(formView.getEntity());
			getViewManager().removeView(formView);
			getViewManager().showMsg("Altera��o efetuada com sucesso.");
		}
		EntityListView entityListView = formView.getEntityListView();
		if(entityListView != null) {
			entityListView.refresh();
		}
	}

	public void cancel(FormView formView) {
		getViewManager().removeView(formView);
		EntityListView entityListView = formView.getEntityListView();
		if(entityListView != null) {
			entityListView.refresh();
		}
	}
	
	public void removeAll(List<E> entidades) {
		for(E entidade : entidades) {
			entityService.remove(entidade);
		}
		getViewManager().showMsg("Exclus�o efetuada com sucesso.");
	}

}
