package edu.flf.aps.bancox.domain;

import javax.persistence.Entity;

/**
 * @author rafaeluchoa
 */
@Entity
public class PessoaJuridica extends Pessoa {

	private String cnpj;
	private String razaoSocial;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

}
