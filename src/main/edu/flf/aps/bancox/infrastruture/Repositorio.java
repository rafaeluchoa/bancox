package edu.flf.aps.bancox.infrastruture;

import java.util.List;


public interface Repositorio<E extends Entidade> {
	E inclua(E o);
	E altere(E o);
	void exclua(E o);
	E findById(Long id);
	List<E> getAll();
}
