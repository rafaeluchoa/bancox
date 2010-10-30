package edu.flf.aps.bancox.domain;

import java.util.ArrayList;
import java.util.List;

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
public class Cliente implements Entidade {

	@Id
	@SequenceGenerator(name="CLIENTE_ID_GENERATOR", sequenceName="CLIENTE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLIENTE_ID_GENERATOR")
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	private Pessoa pessoa;
	private List<ContaBancaria> contas = new ArrayList<ContaBancaria>();
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
	public List<ContaBancaria> getContas() {
		return contas;
	}
	public void setContas(List<ContaBancaria> contas) {
		this.contas = contas;
	}
	
	

}
