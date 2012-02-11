package com.naskar.infrastructure.repository;

import java.util.List;

import com.naskar.infrastructure.domain.EntityDomain;

public interface Repository<E extends EntityDomain> {
	E insert(E o);
	E update(E o);
	void remove(E o);
	E findById(Long id);
	List<E> findAll();
}
