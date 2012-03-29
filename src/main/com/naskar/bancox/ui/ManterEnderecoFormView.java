package com.naskar.bancox.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.naskar.bancox.domain.Endereco;
import com.naskar.infrastructure.ui.EntityFormView;
import com.naskar.infrastructure.ui.EntityListView;
import com.naskar.infrastructure.ui.ViewManager;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Component.Event;
import com.vaadin.ui.Component.Listener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;


/**
 * @author rafaeluchoa
 */
@Service
@Scope("prototype")
public class ManterEnderecoFormView implements EntityFormView<Endereco> {
	
	@Autowired
	private ManterEnderecoController controller;
	
	private ManterEnderecoListView listView;
	
	private Endereco entidade;
	
	private VerticalLayout form;

	// Endereco
	private Label lbLogradouro = new Label(); 
	private Label lbId = new Label();
	private TextField tfLogradouro = new TextField();
	private TextField tfNumero = new TextField();
	
	private ViewManager viewManager;
	
	public ViewManager getViewManager() {
		return viewManager;
	}

	public void setViewManager(ViewManager viewManager) {
		this.viewManager = viewManager;
	}

	public ManterEnderecoFormView view() {
		return this;
	}
	
	public void init() {
		form = new VerticalLayout();
		form.setSpacing(true);
		form.setMargin(true);
		
		form.addComponent(lbLogradouro);
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
		grid.addComponent(new Label("Logradouro:"), 0, i);
		grid.addComponent(tfLogradouro, 1, i);
		
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
				controller.save(view());
			}
		});
		botoes.addComponent(salvar);
		
		Button cancelar = new Button("Cancelar");
		cancelar.addListener(new Listener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void componentEvent(Event event) {
				controller.cancel(view());
			}
		});
		botoes.addComponent(cancelar);
		
		return(botoes);
	}
	
	public void setEntity(Endereco entidade) {
		
		if(entidade == null) {
			return;
		}
		
		this.entidade = entidade;
		lbLogradouro.setValue((entidade.getId() == null ? "Novo" : "Edição") + " Endereço");
		
		if(entidade.getId() != null) {
			lbId.setValue(String.valueOf(entidade.getId()));
		}
		if(entidade.getLogradouro() != null) {
			tfLogradouro.setValue(entidade.getLogradouro());
		}
		if(entidade.getNumero() != null) {
			tfNumero.setValue(entidade.getNumero());
		}
	}
	
	//TODO: verificar se essa logica precisa ficar aqui
	public Endereco getEntity() {
		Endereco retorno = entidade;
		
		if(retorno == null) {
			retorno = new Endereco();
		}
		
		retorno.setLogradouro((String)tfLogradouro.getValue());
		retorno.setNumero((String)tfNumero.getValue());
		
		return retorno;
	}
	
	public Component getComponent() {
		return form;
	}

	@Override
	public void setEntityListView(EntityListView entityListView) {
		listView = (ManterEnderecoListView) entityListView;
	}

	@Override
	public EntityListView getEntityListView() {
		return listView;
	}

	@Override
	public String getViewName() {
		return (String)lbLogradouro.getValue();
	}
	

}
