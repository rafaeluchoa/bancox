package com.naskar.bancox.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.naskar.bancox.service.ConsultarSaldo;
import com.naskar.infrastructure.ui.Controller;
import com.naskar.infrastructure.ui.ViewFactory;

@Service
@Scope("prototype")
public class ConsultarSaldoController implements Controller {
	
	@Autowired
	private ViewFactory viewFactory;
	
	@Autowired
	private ConsultarSaldo consultarSaldo;
	
	public ConsultarSaldoView init(){
		return viewFactory.createView(ConsultarSaldoView.class);
	}

	public void consultarSaldo(ConsultarSaldoView view) {
		float f = consultarSaldo.consultarSaldo(view.getNumeroConta());
		view.setSaldo(String.valueOf(f));
	}
	
}