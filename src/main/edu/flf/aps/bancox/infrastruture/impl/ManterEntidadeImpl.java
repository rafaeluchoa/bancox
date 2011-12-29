package edu.flf.aps.bancox.infrastruture.impl;

import java.util.List;

import edu.flf.aps.bancox.infrastruture.Entidade;
import edu.flf.aps.bancox.infrastruture.Repositorio;

/**
 * @author rafaeluchoa
 */
public abstract class ManterEntidadeImpl<E extends Entidade> {
	
	public abstract Repositorio<E> getRepositorio();
	
	public E inclua(E obj) {
		return(getRepositorio().inclua(obj));
	}
	
	public E altere(E obj) {
		return(getRepositorio().altere(obj));
	}
	
	public void exclua(E obj) {
		getRepositorio().exclua(obj);
	}
	
	public E busquePorId(Long id) {
		return getRepositorio().busquePorId(id);
	}
	
	public List<E> busqueTodos() {
		return getRepositorio().busqueTodos();
	}
	
}
