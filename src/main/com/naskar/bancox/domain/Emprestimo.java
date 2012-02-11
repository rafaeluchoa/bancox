package com.naskar.bancox.domain;

public class Emprestimo extends Transacao {
	private float valor;
	private int qtdeParcelas;
	private boolean aprovado;
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public int getQtdeParcelas() {
		return qtdeParcelas;
	}
	public void setQtdeParcelas(int qtdeParcelas) {
		this.qtdeParcelas = qtdeParcelas;
	}
	public boolean isAprovado() {
		return aprovado;
	}
	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}
	
	
	
}
