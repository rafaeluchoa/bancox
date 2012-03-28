package com.naskar.bancox.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.naskar.infrastructure.domain.EntityDomain;



/**
 * @author rafaeluchoa
 */
@Entity
public class Endereco implements EntityDomain {

	@Id
	@SequenceGenerator(name="ENDERECO_ID_GENERATOR", sequenceName="ENDERECO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENDERECO_ID_GENERATOR")
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	
	@NotNull
	@NotBlank
	private String logradouro;
	
	@NotNull
	@NotBlank
	private String numero;
	
	private String bairro;
	private String cidade;
	private String uf;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
}
