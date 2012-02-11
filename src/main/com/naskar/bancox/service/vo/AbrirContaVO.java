package com.naskar.bancox.service.vo;

import com.naskar.bancox.domain.Agencia;
import com.naskar.bancox.domain.Pessoa;
import com.naskar.bancox.domain.TipoContaBancaria;

/**
 * @author rafaeluchoa
 */
public class AbrirContaVO {
	
	private Agencia agencia;
	private Pessoa pessoa;
	private TipoContaBancaria tipoContaBancaria;

	public TipoContaBancaria getTipoContaBancaria() {
		return tipoContaBancaria;
	}

	public void setTipoContaBancaria(TipoContaBancaria tipoContaBancaria) {
		this.tipoContaBancaria = tipoContaBancaria;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
