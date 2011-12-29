package edu.flf.aps.bancox.infrastruture;

import java.util.List;

/**
 * @author rafaeluchoa
 */
public interface ManterEntidade<E extends Entidade> {
	
	E inclua(E obj);
	
	E altere(E obj);
	
	void exclua(E obj);
	
	E busquePorId(Long id);
	
	List<E> busqueTodos();
	
}
