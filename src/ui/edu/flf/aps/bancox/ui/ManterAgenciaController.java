package edu.flf.aps.bancox.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.application.ManterAgencia;
import edu.flf.aps.bancox.domain.Agencia;
import edu.flf.aps.bancox.infrastruture.ui.Controller;
import edu.flf.aps.bancox.infrastruture.ui.ViewFactory;

/**
 * @author rafaeluchoa
 */
@Service
public class ManterAgenciaController extends Controller {
	
	@Autowired
	private ViewFactory viewFactory;

	@Autowired
	private ManterAgencia manterAgencia;
	
	public ManterAgenciaListView init() {
		ManterAgenciaListView view = 
			viewFactory.createView(ManterAgenciaListView.class);
		view.init();
		return view;
	}
	
	public List<Agencia> busqueTodos() {
		return manterAgencia.busqueTodos();
	}
	
	public void mostreIncluir(ManterAgenciaListView listView) {
		ManterAgenciaFormView view = viewFactory.createView(ManterAgenciaFormView.class);
		view.init(listView, new Agencia());
		getViewManager().addView(view, view.getNome());
	}

	public void mostreEditar(ManterAgenciaListView listView, Agencia agencia) {
		ManterAgenciaFormView view = viewFactory.createView(ManterAgenciaFormView.class);
		view.init(listView, agencia);
		getViewManager().addView(view, view.getNome());
	}

	public void salve(ManterAgenciaFormView view) {
		Agencia entidade = view.getEntidade();
		if(entidade.getId() == null) {
			manterAgencia.inclua(view.getEntidade());
			getViewManager().removeView(view);
			getViewManager().mostreMensagem("Inclusão efetuada com sucesso.");	
		} else {
			manterAgencia.altere(view.getEntidade());
			getViewManager().removeView(view);
			getViewManager().mostreMensagem("Alteração efetuada com sucesso.");
		}
	}

	public void cancele(ManterAgenciaFormView view) {
		getViewManager().removeView(view);
	}
	
	public void exclua(List<Agencia> entidades) {
		for(Agencia entidade : entidades) {
			manterAgencia.exclua(entidade);
		}
		getViewManager().mostreMensagem("Exclusão efetuada com sucesso.");
	}

}
