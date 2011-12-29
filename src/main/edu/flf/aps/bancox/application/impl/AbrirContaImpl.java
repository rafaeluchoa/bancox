package edu.flf.aps.bancox.application.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.application.AbrirConta;
import edu.flf.aps.bancox.application.vo.AbrirContaVO;
import edu.flf.aps.bancox.domain.Agencia;
import edu.flf.aps.bancox.domain.Cliente;
import edu.flf.aps.bancox.domain.ContaBancaria;
import edu.flf.aps.bancox.domain.ContaCorrente;
import edu.flf.aps.bancox.domain.TipoContaBancaria;
import edu.flf.aps.bancox.infrastruture.repositorio.RepositorioAgencia;
import edu.flf.aps.bancox.infrastruture.repositorio.RepositorioCliente;
import edu.flf.aps.bancox.infrastruture.repositorio.RepositorioContaBancaria;
import edu.flf.aps.bancox.infrastruture.repositorio.RepositorioPessoa;

/**
 * @author rafaeluchoa
 */
@Service
public class AbrirContaImpl implements AbrirConta {

	@Autowired
	private RepositorioAgencia repositorioAgencia;

	@Autowired
	private RepositorioContaBancaria repositorioContaBancaria;

	@Autowired
	private RepositorioPessoa repositorioPessoa;
	
	@Autowired
	private RepositorioCliente repositorioCliente;
	
	private Random random;
	
	public AbrirContaImpl() {
		random = new Random(new Date().getTime());
	}

	@Override
	public ContaBancaria abraConta(AbrirContaVO vo) {
		
		// RN1
		/*
		if(vo.getTipoContaBancaria() == TipoContaBancaria.SALARIO && !(vo.getPessoa() instanceof PessoaFisica)) {
			throw new ContaSalarioParaPessoaNaoFisicaException();
		}
		*/
		
		// RN2
		

		repositorioPessoa.inclua(vo.getPessoa());
		
		ContaBancaria conta = null;
		if (vo.getTipoContaBancaria() == TipoContaBancaria.CORRENTE) {
			conta = new ContaCorrente();
		
			
//		} else if (vo.getTipoContaBancaria() == TipoContaBancaria.POUPANCA) {
//			conta = new ContaPoupanca();
//			
//		} else if (vo.getTipoContaBancaria() == TipoContaBancaria.SALARIO) {
//			conta = new ContaSalario();
//			
		}
		
		Cliente cliente = new Cliente();
		cliente.setPessoa(vo.getPessoa());
		cliente.getContas().add(conta);
		
		repositorioCliente.inclua(cliente);

		conta.setTitular(cliente);
		conta.setAgencia(vo.getAgencia());
		conta.setSaldo(0.0f);
		conta.setNumero(String.valueOf(random.nextInt(99999)));
		
		repositorioContaBancaria.inclua(conta);

		return conta;
	}

	public List<Agencia> getAgencias() {
		return repositorioAgencia.busqueTodos();
	}

	@Override
	public void setRepositorioContaBancaria(RepositorioContaBancaria repositorio) {
		this.repositorioContaBancaria = repositorio;
	}

	@Override
	public void setRepositorioPessoa(RepositorioPessoa repositorio) {
		this.repositorioPessoa = repositorio;
	}

	@Override
	public void setRepositorioAgencia(RepositorioAgencia repositorio) {
		this.repositorioAgencia = repositorio;
	}

}
