package edu.flf.aps.bancox.infrastruture.repositorio;

import edu.flf.aps.bancox.domain.ContaBancaria;
import edu.flf.aps.bancox.infrastruture.Repositorio;

public interface RepositorioContaBancaria extends Repositorio<ContaBancaria> {
	
	ContaBancaria findByNumeroConta(String numero);
	
}
