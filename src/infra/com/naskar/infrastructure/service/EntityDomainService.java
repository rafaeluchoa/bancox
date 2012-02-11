package com.naskar.infrastructure.service;

import java.util.List;

import com.naskar.infrastructure.domain.EntityDomain;

/**
 * @author rafaeluchoa
 */
public interface EntityDomainService<E extends EntityDomain> {
	
	E insert(E obj);
	
	E update(E obj);
	
	void remove(E obj);
	
	E findById(Long id);
	
	List<E> findAll();
	
}
