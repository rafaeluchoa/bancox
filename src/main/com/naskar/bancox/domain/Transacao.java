package com.naskar.bancox.domain;

import java.sql.Timestamp;

/**
 * @author rafaeluchoa
 */
public class Transacao {

	private Long id;
	private Timestamp data;
	private ContaBancaria origem;
	private double saldoAnterior;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}
	
	public ContaBancaria getOrigem() {
		return origem;
	}
	public void setOrigem(ContaBancaria origem) {
		this.origem = origem;
	}

	public double getSaldoAnterior() {
		return saldoAnterior;
	}

	public void setSaldoAnterior(double saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}

}
