package com.naskar.bancox.repository;

import com.naskar.bancox.domain.ContaBancaria;
import com.naskar.infrastructure.repository.Repository;

public interface ContaBancariaRepository extends Repository<ContaBancaria> {
	
	ContaBancaria findByNumeroConta(String numero);
	
}
