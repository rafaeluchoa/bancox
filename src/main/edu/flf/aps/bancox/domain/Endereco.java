package edu.flf.aps.bancox.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import edu.flf.aps.bancox.infrastruture.Entidade;


/**
 * @author rafaeluchoa
 */
@Entity
public class Endereco implements Entidade {

	@Id
	@SequenceGenerator(name="ENDERECO_ID_GENERATOR", sequenceName="ENDERECO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENDERECO_ID_GENERATOR")
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	private String rua;
	private String bairro;
	private String numero;
	private String cidade;
	private String estado;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
