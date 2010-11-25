package edu.flf.aps.bancox.application.dto;

import edu.flf.aps.bancox.domain.Agencia;
import edu.flf.aps.bancox.domain.Pessoa;
import edu.flf.aps.bancox.domain.TipoContaBancaria;

/**
 * @author rafaeluchoa
 */
public class AbrirContaDTO {
	
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
