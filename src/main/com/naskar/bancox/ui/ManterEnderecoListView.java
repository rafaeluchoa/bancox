package com.naskar.bancox.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.naskar.bancox.domain.Endereco;
import com.naskar.infrastructure.ui.EntityListView;
import com.naskar.infrastructure.ui.ViewManager;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Component.Event;
import com.vaadin.ui.Component.Listener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;


/**
 * @author rafaeluchoa
 */
@Service
@Scope("prototype")
public class ManterEnderecoListView implements EntityListView {
	
	//TODO: pegar de um properties
	private static final String NOME = "Cadastro de Endereço";
	private static final String[] C_Endereco = new String[] { "id", "logradouro", "numero" };
	private static final String[] L_Endereco = new String[] { "Id", "Logradouro", "Número" };

	// TODO: incluir form para ter campos de filtro, pesquisa
	private VerticalLayout form;

	private final BeanItemContainer<Endereco> container = 
			new BeanItemContainer<Endereco>(Endereco.class);
	private final Table table = new Table();

	@Autowired
	private ManterEnderecoController controller;
	
	private ViewManager viewManager;
	
	public ViewManager getViewManager() {
		return viewManager;
	}

	public void setViewManager(ViewManager viewManager) {
		this.viewManager = viewManager;
	}

	public ManterEnderecoListView view() {
		return this;
	}
	
	public String getNome() {
		return NOME;
	}

	public void init() {
		form = new VerticalLayout();
		
		form.setSpacing(true);
		form.setMargin(true);
		form.addComponent(new Label(NOME));
		form.addComponent(crieBotoes());
		form.addComponent(crieTabela());
		
		refresh();
	}
	
	private HorizontalLayout crieBotoes() {
		HorizontalLayout botoes = new HorizontalLayout();
		botoes.setSpacing(true);
		
		Button novo = new Button("Novo");
		novo.addListener(new Listener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void componentEvent(Event event) {
				controller.showInsert(view());
			}
		});
		botoes.addComponent(novo);
		
		Button editar = new Button("Editar");
		editar.addListener(new Listener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void componentEvent(Event event) {
				editeSelecionado();
			}
		});
		botoes.addComponent(editar);
		
		Button excluir = new Button("Excluir");
		excluir.addListener(new Listener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void componentEvent(Event event) {
				excluaSelecionados();
			}
		});
		botoes.addComponent(excluir);
		
		Button atualizar = new Button("Atualizar");
		atualizar.addListener(new Listener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void componentEvent(Event event) {
				refresh();
			}
		});
		botoes.addComponent(atualizar);
		
		return(botoes);
	}
	
	private Table crieTabela() {
		table.setContainerDataSource(container);
		table.setVisibleColumns(C_Endereco);
		table.setColumnHeaders(L_Endereco);
		table.setWidth("650px");
		
		table.setPageLength(10);
		table.setSelectable(true);
		table.setMultiSelect(true);
		
		return(table);
	}
	
	public Component getComponent() {
		return form;
	}
	
	@SuppressWarnings("unchecked")
	public void excluaSelecionados() {
		Set<Endereco> selecao = (Set<Endereco>)table.getValue();
		if(selecao.isEmpty()) {
			getViewManager().showWarn("É necessário selecionar alguma linha para exclusão.");
			return;
		}
		List<Endereco> entidades = new ArrayList<Endereco>();
		entidades.addAll(selecao);
		controller.removeAll(this, entidades);
		refresh();
	}
	
	
	@SuppressWarnings("unchecked")
	private void editeSelecionado() {
		Set<Endereco> selecao = (Set<Endereco>)table.getValue();
		if(selecao.size() == 0 || selecao.size() > 1) {
			getViewManager().showWarn("Selecione uma linha para edição.");
		} else {
			Endereco entidade = (Endereco)selecao.iterator().next();
			controller.showEdit(this, entidade);
		}
	}
	
	public void refresh() {
		List<Endereco> lista = controller.findAll();
		if(lista == null) {
			lista = new ArrayList<Endereco>(0);
		}
		
		table.removeAllItems();
		container.removeAllItems();
		
		for(Endereco e : lista) {
			container.addBean(e);
		}
	}

}
