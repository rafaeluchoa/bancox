package com.naskar.bancox.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naskar.bancox.domain.Agencia;
import com.naskar.bancox.domain.Cliente;
import com.naskar.bancox.domain.ContaBancaria;
import com.naskar.bancox.domain.ContaCorrente;
import com.naskar.bancox.domain.ContaPoupanca;
import com.naskar.bancox.domain.ContaSalario;
import com.naskar.bancox.domain.TipoContaBancaria;
import com.naskar.bancox.repository.AgenciaRepository;
import com.naskar.bancox.repository.ClienteRepository;
import com.naskar.bancox.repository.ContaBancariaRepository;
import com.naskar.bancox.repository.PessoaRepository;
import com.naskar.bancox.service.AbrirConta;
import com.naskar.bancox.service.vo.AbrirContaVO;


/**
 * @author rafaeluchoa
 */
@Service
public class AbrirContaImpl implements AbrirConta {

	@Autowired
	private AgenciaRepository agenciaRepository;

	@Autowired
	private ContaBancariaRepository contaBancariaRepository;

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private Random random;
	
	public AbrirContaImpl() {
		random = new Random(new Date().getTime());
	}

	@Override
	public ContaBancaria abraConta(AbrirContaVO vo) {
		
		pessoaRepository.insert(vo.getPessoa());
		
		ContaBancaria conta = null;
		if (vo.getTipoContaBancaria() == TipoContaBancaria.CORRENTE) {
			conta = new ContaCorrente();
		
			
		} else if (vo.getTipoContaBancaria() == TipoContaBancaria.POUPANCA) {
			conta = new ContaPoupanca();
			
		} else if (vo.getTipoContaBancaria() == TipoContaBancaria.SALARIO) {
			conta = new ContaSalario();
			
		}
		
		Cliente cliente = new Cliente();
		cliente.setPessoa(vo.getPessoa());
		cliente.getContas().add(conta);
		
		clienteRepository.insert(cliente);

		conta.setTitular(cliente);
		conta.setAgencia(vo.getAgencia());
		conta.setSaldo(0.0f);
		conta.setNumero(String.valueOf(random.nextInt(99999)));
		
		contaBancariaRepository.insert(conta);

		return conta;
	}

	public List<Agencia> getAgencias() {
		return agenciaRepository.findAll();
	}

	@Override
	public void setRepositorioContaBancaria(ContaBancariaRepository repositorio) {
		this.contaBancariaRepository = repositorio;
	}

	@Override
	public void setRepositorioPessoa(PessoaRepository repositorio) {
		this.pessoaRepository = repositorio;
	}

	@Override
	public void setRepositorioAgencia(AgenciaRepository repositorio) {
		this.agenciaRepository = repositorio;
	}

}
