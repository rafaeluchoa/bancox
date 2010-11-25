package edu.flf.aps.bancox.application;

import java.util.List;

import edu.flf.aps.bancox.application.dto.AbrirContaDTO;
import edu.flf.aps.bancox.domain.Agencia;
import edu.flf.aps.bancox.domain.ContaBancaria;
import edu.flf.aps.bancox.infrastruture.repositorio.RepositorioAgencia;
import edu.flf.aps.bancox.infrastruture.repositorio.RepositorioContaBancaria;
import edu.flf.aps.bancox.infrastruture.repositorio.RepositorioPessoa;

public interface AbrirConta {
	public ContaBancaria abraConta(AbrirContaDTO vo) throws IllegalAccessException;
	
	void setRepositorioContaBancaria(RepositorioContaBancaria repositorio);
	void setRepositorioPessoa(RepositorioPessoa repositorio);
	void setRepositorioAgencia(RepositorioAgencia repositorio);
	
	List<Agencia> getAgencias();
}
