package com.naskar.infrastructure.repository;

import com.naskar.infrastructure.domain.EntityDomain;

public interface RepositoryFactory {

	<E extends EntityDomain, T extends Repository<E>> T createRepository(Class<T> clazz);
	
}
