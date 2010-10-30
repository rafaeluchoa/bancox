package edu.flf.aps.bancox.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author rafaeluchoa
 */
@Entity
public class Acesso {
	
	@Id
	@SequenceGenerator(name="ACESSO_ID_GENERATOR", sequenceName="ACESSO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACESSO_ID_GENERATOR")
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	private Pessoa pessoa;
	private String senha;
	private Timestamp dtGeracao;
	private Timestamp dtExpiracao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Timestamp getDtGeracao() {
		return dtGeracao;
	}

	public void setDtGeracao(Timestamp dtGeracao) {
		this.dtGeracao = dtGeracao;
	}

	public Timestamp getDtExpiracao() {
		return dtExpiracao;
	}

	public void setDtExpiracao(Timestamp dtExpiracao) {
		this.dtExpiracao = dtExpiracao;
	}

	

}
