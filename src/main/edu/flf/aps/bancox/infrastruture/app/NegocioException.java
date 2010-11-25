package edu.flf.aps.bancox.infrastruture.app;

@SuppressWarnings("serial")
public class NegocioException extends RuntimeException {
	
	private Object[] dados;
	
	public NegocioException(String msg, String... dados) {
		super(msg);
		this.dados = dados;
	}
	
	public NegocioException(Exception e) {
		super(e);
	}
	
	public NegocioException(String msg, Exception e, Object... dados) {
		super(msg, e);
		this.dados = dados;
	}

	public Object[] getDados() {
		return dados;
	}
	
}
