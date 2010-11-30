package edu.flf.aps.bancox.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.application.ConsultarSaldo;


@Service
public class ConsultarSaldoController extends Controller {
	
	
	@Autowired
	private ConsultarSaldo consultarSaldo;
	
	public ConsultarSaldoView init(ViewManager viewManager){
		ConsultarSaldoView view = new ConsultarSaldoView(this);
		view.setViewManager(viewManager);
		
		view.init();
		return view;
	}

	public void consultarSaldo(ConsultarSaldoView view) {
		float f = consultarSaldo.consultarSaldo(view.getNumeroConta());
		view.setSaldo(String.valueOf(f));
	}
	
}