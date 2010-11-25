package edu.flf.aps.bancox.application.dto;


/**
 * @author rafaeluchoa
 */
public class AutenticarClienteDTO {
	
	private String numeroConta;
	private String senha;
	
	public String getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
