package edu.flf.aps.bancox.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

import edu.flf.aps.bancox.infrastruture.Entidade;

/**
 * @author rafaeluchoa
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Pessoa implements Entidade {

	@Id
	@SequenceGenerator(name="PESSOA_ID_GENERATOR", sequenceName="PESSOA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PESSOA_ID_GENERATOR")
	@Column(name="id", unique=true, nullable=false)
	protected Long id;
	private String nome;
	private String email;
	private Endereco endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
