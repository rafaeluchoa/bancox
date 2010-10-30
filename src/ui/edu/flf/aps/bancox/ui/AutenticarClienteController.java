package edu.flf.aps.bancox.ui;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.application.AutenticarCliente;

/**
 * @author rafaeluchoa
 */
@Service
public class AutenticarClienteController implements Controller {

	@Autowired
	private AutenticarCliente autenticarCliente;
	
	public AutenticarClienteView init(ViewManager viewManager) {
		AutenticarClienteView view = new AutenticarClienteView(this);
		view.setViewManager(viewManager);
		view.init(autenticarCliente.gerarTeclasAleatorias());
		return view;
	}
	
	public void autenticar(AutenticarClienteView view) {
		
	}

}
