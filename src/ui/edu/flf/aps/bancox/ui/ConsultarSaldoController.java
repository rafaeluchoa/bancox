package edu.flf.aps.bancox.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.application.ConsultarSaldo;
import edu.flf.aps.bancox.infrastruture.ui.Controller;
import edu.flf.aps.bancox.infrastruture.ui.ViewFactory;


@Service
public class ConsultarSaldoController extends Controller {
	
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