package com.naskar.infrastructure.exception;

@SuppressWarnings("serial")
public class ApplicationException extends RuntimeException {
	
	private Object[] dados;
	
	public ApplicationException(String msg, String... dados) {
		super(msg);
		this.dados = dados;
	}
	
	public ApplicationException(Exception e) {
		super(e);
	}
	
	public ApplicationException(String msg, Exception e, Object... dados) {
		super(msg, e);
		this.dados = dados;
	}

	public Object[] getDados() {
		return dados;
	}
	
}
