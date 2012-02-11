package com.naskar.bancox.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

import com.naskar.infrastructure.domain.EntityDomain;


/**
 * @author rafaeluchoa
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class ContaBancaria implements EntityDomain {

	@Id
	@SequenceGenerator(name="CONTA_BANCARIA_ID_GENERATOR", sequenceName="CONTA_BANCARIA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTA_BANCARIA_ID_GENERATOR")
	@Column(name="id", unique=true, nullable=false)
	protected Long id;
	
	private Cliente titular;
	private Agencia agencia;
	
	private String numero;
	private double saldo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
