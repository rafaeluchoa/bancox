package edu.flf.aps.bancox.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Component.Event;
import com.vaadin.ui.Component.Listener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import edu.flf.aps.bancox.domain.Agencia;
import edu.flf.aps.bancox.infrastruture.ui.EntityFormView;
import edu.flf.aps.bancox.infrastruture.ui.EntityListView;

/**
 * @author rafaeluchoa
 */
@Service
@Scope("prototype")
public class ManterAgenciaFormView implements EntityFormView<Agencia> {
	
	@Autowired
	private ManterAgenciaController controller;
	
	private ManterAgenciaListView listView;
	
	private Agencia entidade;
	
	private VerticalLayout form;

	// agencia
	private Label lbNome = new Label(); 
	private Label lbId = new Label();
	private TextField tfNome = new TextField();
	private TextField tfNumero = new TextField();

	public ManterAgenciaFormView _this() {
		return this;
	}
	
	public void init() {
		form = new VerticalLayout();
		form.setSpacing(true);
		form.setMargin(true);
		
		form.addComponent(lbNome);
		form.addComponent(crieFormulario());
		form.addComponent(crieBotoes());
	}
	
	private GridLayout crieFormulario() {
		int i = -1;
		GridLayout grid = new GridLayout(2, 3);
		grid.setSpacing(true);
		grid.setMargin(true);
		
		i++;
		grid.addComponent(new Label("Id:"), 0, i);
		grid.addComponent(lbId, 1, i);
		
		i++;
		grid.addComponent(new Label("Nome:"), 0, i);
		grid.addComponent(tfNome, 1, i);
		
		i++;
		grid.addComponent(new Label("Número:"), 0, i);
		grid.addComponent(tfNumero, 1, i);
		
		return grid;
	}
	
	private Component crieBotoes() {
		 
		HorizontalLayout botoes = new HorizontalLayout();
		botoes.setSpacing(true);
		
		Button salvar = new Button("Salvar");
		salvar.addListener(new Listener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void componentEvent(Event event) {
				controller.salve(_this());
			}
		});
		botoes.addComponent(salvar);
		
		Button cancelar = new Button("Cancelar");
		cancelar.addListener(new Listener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void componentEvent(Event event) {
				controller.cancele(_this());
			}
		});
		botoes.addComponent(cancelar);
		
		return(botoes);
	}
	
	public void setEntity(Agencia entidade) {
		
		if(entidade == null) {
			return;
		}
		
		this.entidade = entidade;
		lbNome.setValue((entidade.getId() != null ? "Edição" : "Novo") + " Agência");
		
		if(entidade.getId() != null) {
			lbId.setValue(String.valueOf(entidade.getId()));
		}
		if(entidade.getNome() != null) {
			tfNome.setValue(entidade.getNome());
		}
		if(entidade.getNumero() != null) {
			tfNumero.setValue(entidade.getNumero());
		}
	}
	
	//TODO: verificar se essa logica precisa ficar aqui
	public Agencia getEntity() {
		Agencia retorno = entidade;
		
		if(retorno == null) {
			retorno = new Agencia();
		}
		
		retorno.setNome((String)tfNome.getValue());
		retorno.setNumero((String)tfNumero.getValue());
		
		return retorno;
	}
	
	public Component getComponent() {
		return form;
	}

	@Override
	public void setEntityListView(EntityListView entityListView) {
		listView = (ManterAgenciaListView) entityListView;
	}

	@Override
	public EntityListView getEntityListView() {
		return listView;
	}

	@Override
	public String getViewName() {
		return (String)lbNome.getValue();
	}
	

}
