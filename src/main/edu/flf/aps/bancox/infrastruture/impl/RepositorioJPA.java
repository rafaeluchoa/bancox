package edu.flf.aps.bancox.infrastruture.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import edu.flf.aps.bancox.infrastruture.Entidade;
import edu.flf.aps.bancox.infrastruture.Repositorio;

/**
 * @author rafaeluchoa
 */
public class RepositorioJPA<E extends Entidade> implements Repositorio<E> {

	@PersistenceContext
	private EntityManager entityManager;
	private Class<E> clazz;

	@SuppressWarnings("unchecked")
	public RepositorioJPA() {
		clazz = (Class<E>) ReflectionUtils.getTypeArguments(RepositorioJPA.class,
				getClass()).get(0);
	}

	@Override
	public List<E> busqueTodos() {
		try {
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<E> query = builder.createQuery(clazz);
			
			Root<E> root = query.from(clazz);
			query.select(root);
	
			TypedQuery<E> typedQuery = entityManager.createQuery(query);
			return typedQuery.getResultList();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void exclua(E o) {
		E oe = getEntityManager().merge(o);
		entityManager.remove(oe);
	}

	@Override
	public E inclua(E o) {
		entityManager.persist(o); 
		return o;
	}
	
	@Override
	public E altere(E o) {
		entityManager.merge(o);
		return o;
	}

	@Override
	public E busquePorId(Long id) {
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
