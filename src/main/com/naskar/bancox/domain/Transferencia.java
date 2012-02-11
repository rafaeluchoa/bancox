package com.naskar.bancox.domain;

public class Transferencia extends Transacao {
	
	private ContaBancaria destino;
	
	public ContaBancaria getDestino() {
		return destino;
	}
	public void setDestino(ContaBancaria destino) {
		this.destino = destino;
	}
	
}
