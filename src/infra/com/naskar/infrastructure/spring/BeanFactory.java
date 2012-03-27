package com.naskar.infrastructure.spring;

public interface BeanFactory {
	
	<T> T createBean(Class<T> clazz);

}
