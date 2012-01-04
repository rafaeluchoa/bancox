package edu.flf.aps.bancox.infrastruture.ui;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;


@Service
public class ViewFactoryImpl implements ViewFactory, ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;		
	}

	@Override
	public <T extends View> T createView(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}
	
}
