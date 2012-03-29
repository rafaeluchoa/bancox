package com.naskar.infrastructure.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.naskar.infrastructure.domain.EntityDomain;
import com.naskar.infrastructure.repository.Repository;
import com.naskar.infrastructure.repository.RepositoryException;
import com.naskar.infrastructure.utils.ReflectionUtils;


/**
 * @author rafaeluchoa
 */
public class JPARepository<E extends EntityDomain> implements Repository<E> {

	@PersistenceContext
	private EntityManager entityManager;
	private Class<E> clazz;

	@SuppressWarnings("unchecked")
	public JPARepository() {
		clazz = (Class<E>) ReflectionUtils.getTypeArguments(JPARepository.class,
				getClass()).get(0);
	}

	@Override
	public List<E> findAll() {
		try {
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<E> query = builder.createQuery(clazz);
			
			Root<E> root = query.from(clazz);
			query.select(root);
	
			TypedQuery<E> typedQuery = entityManager.createQuery(query);
			return typedQuery.getResultList();
		} catch(Exception e) {
			throw new RepositoryException(e);
		}
	}

	@Override
	public void remove(E o) {
		E oe = getEntityManager().merge(o);
		entityManager.remove(oe);
	}

	@Override
	public E insert(E o) {
		entityManager.persist(o); 
		return o;
	}
	
	@Override
	public E update(E o) {
		entityManager.merge(o);
		return o;
	}

	@Override
	public E findById(Long id) {
		return entityManager.find(clazz, id);
	}

	protected Class<E> getClazz() {
		return clazz;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
