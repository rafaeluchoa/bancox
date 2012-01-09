package edu.flf.aps.bancox.infrastruture.impl;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import edu.flf.aps.bancox.infrastruture.Entidade;
import edu.flf.aps.bancox.infrastruture.Repositorio;
import edu.flf.aps.bancox.infrastruture.app.RepositoryFactory;

/**
 * @author rafaeluchoa
 */
public abstract class ManterEntidadeImpl<E extends Entidade, R extends Repositorio<E>> 
	implements InitializingBean {
	
	@Autowired
	private RepositoryFactory repositoryFactory;
	private Repositorio<E> repositorio;
	
	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<Class<?>> clazzes = 
				ReflectionUtils.getTypeArguments(ManterEntidadeImpl.class, getClass());
		repositorio = repositoryFactory.createRepository((Class<Repositorio<E>>)clazzes.get(1));
	}
	
	public E inclua(E obj) {
		return(repositorio.inclua(obj));
	}
	
	public E altere(E obj) {
		return(repositorio.altere(obj));
	}
	
	public void exclua(E obj) {
		repositorio.exclua(obj);
	}
	
	public E busquePorId(Long id) {
		return repositorio.busquePorId(id);
	}
	
	public List<E> busqueTodos() {
		return repositorio.busqueTodos();
	}
	
}
