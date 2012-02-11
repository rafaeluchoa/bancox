package com.naskar.bancox.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naskar.bancox.service.AutenticarCliente;
import com.naskar.infrastructure.ui.Controller;
import com.naskar.infrastructure.ui.ViewFactory;


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
		return viewFactory.createView(AutenticarClienteView.class);
	}
	
	public void autenticar(AutenticarClienteView view) {
		
	}
	
	public List<Integer[]> gerarTeclasAleatorias() {
		return autenticarCliente.gerarTeclasAleatorias();
	}

}
