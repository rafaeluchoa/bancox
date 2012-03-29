package com.naskar.infrastructure.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.naskar.infrastructure.domain.EntityDomain;
import com.naskar.infrastructure.repository.Repository;


//@Service
public class MemoryRepository<E extends EntityDomain> implements Repository<E> {
	
	private List<E> lista = new ArrayList<E>();
	private Map<Integer, E> mapa = new HashMap<Integer, E>();

	@Override
	public List<E> findAll() {
		return new ArrayList<E>(lista);
	}

	@Override
	public void remove(E o) {
		lista.remove(o);
	}

	@Override
	public E insert(E o) {
		mapa.put(o.hashCode(), o);
		return o;
	}

	@Override
	public E findById(Long id) {
		return mapa.get(id);
	}

	@Override
	public E update(E o) {
		return insert(o);
	}

}
