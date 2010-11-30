package edu.flf.aps.bancox.infrastruture.repositorio.impl;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.domain.ContaBancaria;
import edu.flf.aps.bancox.infrastruture.impl.RepositorioJPA;
import edu.flf.aps.bancox.infrastruture.repositorio.RepositorioContaBancaria;

@Service
public class RepositorioContaBancariaImpl extends RepositorioJPA<ContaBancaria> implements RepositorioContaBancaria {
	
	public ContaBancaria findByNumeroConta(String numero) {
		try {
			CriteriaBuilder qb = getEntityManager().getCriteriaBuilder();
			
			CriteriaQuery<ContaBancaria> query = qb.createQuery(ContaBancaria.class);
			
			// select * from ContaBancaria where numero = :numero
			Root<ContaBancaria> contaBancaria = query.from(ContaBancaria.class);
			
			query.select(contaBancaria);
			query.where(qb.equal(contaBancaria.get("numero"), numero));
	
			ContaBancaria result = getEntityManager().createQuery(query).getSingleResult();
			return result;
		} catch(NoResultException nre) {
			return null;
		}
	}
	
}
