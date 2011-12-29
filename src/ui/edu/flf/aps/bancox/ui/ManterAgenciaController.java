package edu.flf.aps.bancox.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.application.ManterAgencia;
import edu.flf.aps.bancox.domain.Agencia;

/**
 * @author rafaeluchoa
 */
@Service
public class ManterAgenciaController extends Controller {

	@Autowired
	private ManterAgencia manterAgencia;
	
	public ManterAgenciaListView init() {
		//TODO: 
		ManterAgenciaListView view = new ManterAgenciaListView(this);
		view.init();
		return view;
	}
	
	public List<Agencia> busqueTodos() {
		return manterAgencia.busqueTodos();
	}
	
	public void mostreIncluir(ManterAgenciaListView listView) {
		ManterAgenciaFormView view = new ManterAgenciaFormView(this, listView, new Agencia());
		view.init();
		getViewManager().addView(view, view.getNome());
	}

	public void mostreEditar(ManterAgenciaListView listView, Agencia agencia) {
		ManterAgenciaFormView view = new ManterAgenciaFormView(this, listView, agencia);
		view.init();
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
