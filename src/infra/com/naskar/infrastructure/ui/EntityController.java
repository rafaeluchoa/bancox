package com.naskar.infrastructure.ui;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
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
	EntityService extends EntityDomainService<E>>  
	implements Controller, InitializingBean {
	
	private Class<E> clazzE;
	private Class<ListView> clazzListView;
	private Class<FormView> clazzFormView;
	private Class<EntityService> clazzServiceView;
	
	private EntityService entityService;
	
	@Autowired
	private BeanFactory beanFactory;
	
	@Autowired
	private ViewFactory viewFactory;
	
	@SuppressWarnings("unchecked")
	public EntityController() {
		List<Class<?>> clazzes = 
			ReflectionUtils.getTypeArguments(EntityController.class, getClass());
		clazzE = (Class<E>) clazzes.get(0);
		clazzListView = (Class<ListView>) clazzes.get(1);
		clazzFormView = (Class<FormView>) clazzes.get(2);
		clazzServiceView = (Class<EntityService>) clazzes.get(3);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
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
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	public void showEdit(ListView listView, E entidade) {
		FormView view = getViewFactory().createView(clazzFormView);
		view.setViewManager(listView.getViewManager());
		view.setEntityListView(listView);
		view.setEntity(entidade);
		listView.getViewManager().addView(view, view.getViewName());
	}

	public void save(FormView formView) {
		EntityDomain entidade = formView.getEntity();
		if(entidade.getId() == null) {
			entityService.insert(formView.getEntity());
			formView.getViewManager().removeView(formView);
			formView.getViewManager().showMsg("Inclus�o efetuada com sucesso.");	
		} else {
			entityService.update(formView.getEntity());
			formView.getViewManager().removeView(formView);
			formView.getViewManager().showMsg("Altera��o efetuada com sucesso.");
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
		listView.getViewManager().showMsg("Exclus�o efetuada com sucesso.");
	}

}
