package com.naskar.bancox.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.naskar.infrastructure.domain.EntityDomain;


/**
 * @author rafaeluchoa
 */
@Entity
public class Agencia implements EntityDomain {

	@Id
	@SequenceGenerator(name="AGENCIA_ID_GENERATOR", sequenceName="AGENCIA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AGENCIA_ID_GENERATOR")
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	private String nome;
	private String numero;
	private Endereco endereco;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
