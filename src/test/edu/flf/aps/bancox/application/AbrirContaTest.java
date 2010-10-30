package edu.flf.aps.bancox.application;

import junit.framework.Assert;

import org.junit.Test;

import edu.flf.aps.bancox.application.impl.AbrirContaImpl;
import edu.flf.aps.bancox.domain.Agencia;
import edu.flf.aps.bancox.domain.ContaBancaria;
import edu.flf.aps.bancox.domain.PessoaFisica;
import edu.flf.aps.bancox.infrastruture.impl.RepositorioEmMemoria;

public class AbrirContaTest {

	@Test
	public void testAbraContaCorrente() throws IllegalAccessException {
		
		PessoaFisica pf = new PessoaFisica();
		pf.setCpf("1111");
		pf.setNome("rafael");
		pf.setRg("1111");
		
		RepositorioEmMemoria<PessoaFisica> rPessoa = new RepositorioEmMemoria<PessoaFisica>();
		pf = rPessoa.inclua(pf);
		Assert.assertTrue(pf.getId() != null);
		
		Agencia ag = new Agencia();
		ag.setNome("avenida x");
		ag.setNumero("1111");
		RepositorioEmMemoria<Agencia> rAgencia = new RepositorioEmMemoria<Agencia>();
		ag = rAgencia.inclua(ag); 	 	
		Assert.assertTrue(pf.getId() != null);

		AbrirConta abrirConta = new AbrirContaImpl();
		//abrirConta.setRepositorioContaBancaria(new RepositorioEmMemoria<ContaBancaria>());
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
