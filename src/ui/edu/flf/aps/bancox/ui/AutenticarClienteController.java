package edu.flf.aps.bancox.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.application.AutenticarCliente;
import edu.flf.aps.bancox.infrastruture.ui.Controller;
import edu.flf.aps.bancox.infrastruture.ui.ViewFactory;

/**
 * @author rafaeluchoa
 */
@Service
public class AutenticarClienteController extends Controller {
	
	@Autowired
	private ViewFactory viewFactory;

	@Autowired
	private AutenticarCliente autenticarCliente;
	
	public AutenticarClienteView init() {
		AutenticarClienteView view = viewFactory.createView(AutenticarClienteView.class);
		view.init(autenticarCliente.gerarTeclasAleatorias());
		return view;
	}
	
	public void autenticar(AutenticarClienteView view) {
		
	}

}
