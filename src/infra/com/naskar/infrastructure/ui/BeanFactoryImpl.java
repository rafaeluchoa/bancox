package com.naskar.infrastructure.ui;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.naskar.infrastructure.domain.EntityDomain;
import com.naskar.infrastructure.repository.Repository;
import com.naskar.infrastructure.repository.RepositoryFactory;
import com.naskar.infrastructure.spring.BeanFactory;

@Service
public class BeanFactoryImpl implements ViewFactory, RepositoryFactory, BeanFactory, ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public <T extends View> T createView(Class<T> clazz) {
		T t = applicationContext.getBean(clazz);
		t.init();
		return t;
	}
	
	@Override
	public <E extends EntityDomain, T extends Repository<E>> T createRepository(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}
	
	@Override
	public <T> T createBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}
	
}
