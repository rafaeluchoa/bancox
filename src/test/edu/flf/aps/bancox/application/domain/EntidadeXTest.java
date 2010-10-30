package edu.flf.aps.bancox.application.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import edu.flf.aps.bancox.infrastruture.Entidade;

/**
 * @author rafaeluchoa
 */
@Entity
public class EntidadeXTest implements Entidade {
	
	@Id
	protected Long id;
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
