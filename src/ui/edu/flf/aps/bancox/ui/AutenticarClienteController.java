package edu.flf.aps.bancox.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.application.AutenticarCliente;

/**
 * @author rafaeluchoa
 */
@Service
public class AutenticarClienteController extends Controller {

	@Autowired
	private AutenticarCliente autenticarCliente;
	
	public AutenticarClienteView init() {
		AutenticarClienteView view = new AutenticarClienteView(this);
		view.init(autenticarCliente.gerarTeclasAleatorias());
		return view;
	}
	
	public void autenticar(AutenticarClienteView view) {
		
	}

}
