package edu.flf.aps.bancox.domain;

/**
 * @author rafaeluchoa
 */
public enum TipoContaBancaria {
	POUPANCA,
	CORRENTE,
	SALARIO;
	
	public static TipoContaBancaria get(String nome)  {
		return TipoContaBancaria.valueOf(TipoContaBancaria.class, nome);
	}
}
