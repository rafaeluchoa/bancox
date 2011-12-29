package edu.flf.aps.bancox.infrastruture.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.flf.aps.bancox.infrastruture.Entidade;
import edu.flf.aps.bancox.infrastruture.Repositorio;

//@Service
public class RepositorioEmMemoria<E extends Entidade> implements Repositorio<E> {
	
	private List<E> lista = new ArrayList<E>();
	private Map<Integer, E> mapa = new HashMap<Integer, E>();

	@Override
	public List<E> busqueTodos() {
		List<E> retorno = new ArrayList<E>(lista);
		return retorno;
	}

	@Override
	public void exclua(E o) {
		lista.remove(o);
	}

	@Override
	public E inclua(E o) {
		mapa.put(o.hashCode(), o);
		return o;
	}

	@Override
	public E busquePorId(Long id) {
		return mapa.get(id);
	}

	@Override
	public E altere(E o) {
		return inclua(o);
	}

}
