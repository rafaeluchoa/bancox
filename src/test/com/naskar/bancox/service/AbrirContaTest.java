package com.naskar.bancox.service;

import junit.framework.Assert;

import org.junit.Test;

import com.naskar.bancox.domain.Agencia;
import com.naskar.bancox.domain.PessoaFisica;
import com.naskar.infrastructure.repository.impl.MemoryRepository;


public class AbrirContaTest {

	@Test
	public void testAbraContaCorrente() throws IllegalAccessException {
		
		PessoaFisica pf = new PessoaFisica();
		pf.setCpf("1111");
		pf.setNome("rafael");
		pf.setRg("1111");
		
		MemoryRepository<PessoaFisica> rPessoa = new MemoryRepository<PessoaFisica>();
		pf = rPessoa.insert(pf);
		Assert.assertTrue(pf.getId() != null);
		
		Agencia ag = new Agencia();
		ag.setNome("avenida x");
		ag.setNumero("1111");
		MemoryRepository<Agencia> rAgencia = new MemoryRepository<Agencia>();
		ag = rAgencia.insert(ag); 	 	
		Assert.assertTrue(pf.getId() != null);

		//AbrirConta abrirConta = new AbrirContaImpl();
		//abrirConta.setRepositorioContaBancaria(new MemoryRepository<ContaBancaria>());
		//abrirConta.setRepositorioPessoa(rPessoa);
		// abrirConta.setRepositorioAgencia(rAgencia);
		
		/*ContaCorrente contaNova = abrirConta.abraContaCorrente(pf.getId(), ag.getId());
		
		Assert.assertTrue(contaNova instanceof ContaCorrente);
		Assert.assertTrue(contaNova.getId() != null);
		Assert.assertTrue(contaNova.getSaldo() == 0.0f);
		Assert.assertTrue(contaNova.getNumero() != null);
		Assert.assertTrue(contaNova.getAgencia() != null);
		Assert.assertTrue(contaNova.getAgencia().getId() == ag.getId());
		Assert.assertTrue(contaNova.getTitular().getId() == pf.getId());*/
	}
}
