package com.naskar.bancox.repository.impl;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.naskar.bancox.domain.ContaBancaria;
import com.naskar.bancox.repository.ContaBancariaRepository;
import com.naskar.infrastructure.repository.impl.JPARepository;


@Service
public class ContaBancariaRepositoryImpl extends JPARepository<ContaBancaria> implements ContaBancariaRepository {
	
	public ContaBancaria findByNumeroConta(String numero) {
		ContaBancaria result = null;
		try {
			CriteriaBuilder qb = getEntityManager().getCriteriaBuilder();
			
			CriteriaQuery<ContaBancaria> query = qb.createQuery(ContaBancaria.class);
			
			// select * from ContaBancaria where numero = :numero
			Root<ContaBancaria> contaBancaria = query.from(ContaBancaria.class);
			
			query.select(contaBancaria);
			query.where(qb.equal(contaBancaria.get("numero"), numero));
	
			result = getEntityManager().createQuery(query).getSingleResult();
		} catch(NoResultException nre) {
			result = null;
		}
		return result;
	}
	
}
