package com.naskar.infrastructure.service.impl;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.naskar.infrastructure.domain.EntityDomain;
import com.naskar.infrastructure.repository.Repository;
import com.naskar.infrastructure.repository.RepositoryFactory;
import com.naskar.infrastructure.utils.ReflectionUtils;


/**
 * @author rafaeluchoa
 */
public abstract class EntityDomainServiceImpl<E extends EntityDomain, R extends Repository<E>> 
	implements InitializingBean {
	
	@Autowired
	private RepositoryFactory repositoryFactory;
	private Repository<E> repository;
	
	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<Class<?>> clazzes = 
				ReflectionUtils.getTypeArguments(EntityDomainServiceImpl.class, getClass());
		repository = repositoryFactory.createRepository((Class<Repository<E>>)clazzes.get(1));
	}
	
	public E insert(E obj) {
		return(repository.insert(obj));
	}
	
	public E update(E obj) {
		return(repository.update(obj));
	}
	
	public void remove(E obj) {
		repository.remove(obj);
	}
	
	public E findById(Long id) {
		return repository.findById(id);
	}
	
	public List<E> findAll() {
		return repository.findAll();
	}
	
}
