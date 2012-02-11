package com.naskar.bancox.service;

import java.util.List;

import com.naskar.bancox.domain.Agencia;
import com.naskar.bancox.domain.ContaBancaria;
import com.naskar.bancox.repository.AgenciaRepository;
import com.naskar.bancox.repository.ContaBancariaRepository;
import com.naskar.bancox.repository.PessoaRepository;
import com.naskar.bancox.service.vo.AbrirContaVO;


public interface AbrirConta {
	public ContaBancaria abraConta(AbrirContaVO vo);
	
	void setRepositorioContaBancaria(ContaBancariaRepository repositorio);
	void setRepositorioPessoa(PessoaRepository repositorio);
	void setRepositorioAgencia(AgenciaRepository repositorio);
	
	List<Agencia> getAgencias();
}
