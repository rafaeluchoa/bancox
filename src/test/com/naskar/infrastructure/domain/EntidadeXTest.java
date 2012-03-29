package com.naskar.infrastructure.domain;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * @author rafaeluchoa
 */
@Entity
public class EntidadeXTest implements EntityDomain {
	
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
