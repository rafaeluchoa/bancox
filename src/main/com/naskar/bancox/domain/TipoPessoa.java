package com.naskar.bancox.domain;

/**
 * @author rafaeluchoa
 */
public enum TipoPessoa {
	FISICA,
	JURIDICA;
	
	public static TipoPessoa get(String nome)  {
		return TipoPessoa.valueOf(TipoPessoa.class, nome);
	}
	
}
