package edu.flf.aps.bancox.application;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.flf.aps.bancox.application.domain.EntidadeXTest;
import edu.flf.aps.bancox.application.infrastruture.repositorio.RepositorioEntidadeXTest;

/**
 * @author rafaeluchoa
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:META-INF/edu.flf.spring-base.xml",
		"classpath*:META-INF/edu.flf.spring-persistence.xml" })
public class RepositorioJPATest {

	@Autowired
	private RepositorioEntidadeXTest repositorioEntidadeXTest;

	@Test
	public void test() {
		EntidadeXTest o = new EntidadeXTest();
		o.setId(1L);
		o.setNome("teste");
		repositorioEntidadeXTest.inclua(o);

		o = repositorioEntidadeXTest.busquePorId(1L);
		Assert.assertNotNull(o);
		
		o.setNome("teste02");
		repositorioEntidadeXTest.altere(o);

		o = repositorioEntidadeXTest.busquePorId(1L);
		Assert.assertTrue(o.getNome().equals("teste02"));

		List<EntidadeXTest> lista = repositorioEntidadeXTest.busqueTodos();
		Assert.assertTrue(!lista.isEmpty());

		for (@SuppressWarnings("unused")
		EntidadeXTest e : lista) {
			repositorioEntidadeXTest.exclua(o);
		}

		lista = repositorioEntidadeXTest.busqueTodos();
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
