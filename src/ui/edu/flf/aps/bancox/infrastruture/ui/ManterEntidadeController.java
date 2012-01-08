package edu.flf.aps.bancox.infrastruture.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.infrastruture.Entidade;
import edu.flf.aps.bancox.infrastruture.ManterEntidade;
import edu.flf.aps.bancox.infrastruture.impl.ReflectionUtils;

/**
 * @author rafaeluchoa
 */
@Service
public class ManterEntidadeController<
	E extends Entidade, 
	ListView extends EntityListView, 
	FormView extends EntityFormView<E>,
	Manter extends ManterEntidade<E>> extends Controller {
	
	private Class<E> clazzE;
	private Class<ListView> clazzListView;
	private Class<FormView> clazzFormView;

	@Autowired
	private Manter manterEntidade;
	
	@SuppressWarnings("unchecked")
	public ManterEntidadeController() {
		List<Class<?>> clazzes = 
			ReflectionUtils.getTypeArguments(ManterEntidadeController.class, getClass());
		clazzE = (Class<E>) clazzes.get(0);
		clazzListView = (Class<ListView>) clazzes.get(1);
		clazzFormView = (Class<FormView>) clazzes.get(2);
	}
	
	public ListView init() {
		return getViewFactory().createView(clazzListView);
	}
	
	public List<E> busqueTodos() {
		return manterEntidade.busqueTodos();
	}
	
	public void mostreIncluir(ListView listView) {
		try {
			mostreEditar(listView, clazzE.newInstance());
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	public void mostreEditar(ListView listView, E entidade) {
		FormView view = getViewFactory().createView(clazzFormView);
		view.setEntityListView(listView);
		view.setEntity(entidade);
		getViewManager().addView(view, view.getViewName());
	}

	public void salve(FormView formView) {
		Entidade entidade = formView.getEntity();
		if(entidade.getId() == null) {
			manterEntidade.inclua(formView.getEntity());
			getViewManager().removeView(formView);
			getViewManager().mostreMensagem("Inclusão efetuada com sucesso.");	
		} else {
			manterEntidade.altere(formView.getEntity());
			getViewManager().removeView(formView);
			getViewManager().mostreMensagem("Alteração efetuada com sucesso.");
		}
		EntityListView entityListView = formView.getEntityListView();
		if(entityListView != null) {
			entityListView.refresh();
		}
	}

	public void cancele(FormView formView) {
		getViewManager().removeView(formView);
		EntityListView entityListView = formView.getEntityListView();
		if(entityListView != null) {
			entityListView.refresh();
		}
	}
	
	public void exclua(List<E> entidades) {
		for(E entidade : entidades) {
			manterEntidade.exclua(entidade);
		}
		getViewManager().mostreMensagem("Exclusão efetuada com sucesso.");
	}

}
