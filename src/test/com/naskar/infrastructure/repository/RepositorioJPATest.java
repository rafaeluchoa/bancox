package com.naskar.infrastructure.repository;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.naskar.infrastructure.domain.EntidadeXTest;


/**
 * @author rafaeluchoa
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:META-INF/com.naskar.spring-base.xml",
		"classpath*:META-INF/com.naskar.spring-persistence.xml" })
public class RepositorioJPATest {

	@Autowired
	private RepositorioEntidadeXTest repositorioEntidadeXTest;

	@Test
	public void test() {
		EntidadeXTest o = new EntidadeXTest();
		o.setId(1L);
		o.setNome("teste");
		repositorioEntidadeXTest.insert(o);

		o = repositorioEntidadeXTest.findById(1L);
		Assert.assertNotNull(o);
		
		o.setNome("teste02");
		repositorioEntidadeXTest.update(o);

		o = repositorioEntidadeXTest.findById(1L);
		Assert.assertTrue(o.getNome().equals("teste02"));

		List<EntidadeXTest> lista = repositorioEntidadeXTest.findAll();
		Assert.assertTrue(!lista.isEmpty());

		for (@SuppressWarnings("unused")
		EntidadeXTest e : lista) {
			repositorioEntidadeXTest.remove(o);
		}

		lista = repositorioEntidadeXTest.findAll();
		Assert.assertTrue(lista.isEmpty());
	}

	public RepositorioEntidadeXTest getRepositorioEntidadeXTest() {
		return repositorioEntidadeXTest;
	}

	public void setRepositorioEntidadeXTest(
			RepositorioEntidadeXTest repositorioEntidadeXTest) {
		this.repositorioEntidadeXTest = repositorioEntidadeXTest;
	}
	
	

}
