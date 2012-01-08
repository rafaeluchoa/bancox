package edu.flf.aps.bancox.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Component.Event;
import com.vaadin.ui.Component.Listener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import edu.flf.aps.bancox.domain.Agencia;
import edu.flf.aps.bancox.infrastruture.ui.EntityListView;

/**
 * @author rafaeluchoa
 */
@Service
@Scope("prototype")
public class ManterAgenciaListView implements EntityListView {
	
	//TODO: pegar de um properties
	private static final String NOME = "Cadastro de Agências";
	private static enum C_AGENCIA { ID, NOME, NUMERO };
	private static final String[] L_AGENCIA = new String[] { "Id", "Nome", "Número" };

	// TODO: incluir form para ter campos de filtro, pesquisa
	private VerticalLayout form;

	private List<Agencia> lista = new ArrayList<Agencia>(0);
	private final IndexedContainer container = new IndexedContainer();
	private final Table table = new Table();

	@Autowired
	private ManterAgenciaController controller;

	public ManterAgenciaListView _this() {
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
				controller.mostreIncluir(_this());
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
		for(C_AGENCIA coluna : C_AGENCIA.values()) {
			container.addContainerProperty(coluna, String.class, null);			
		}
		table.setContainerDataSource(container);
		
		table.setVisibleColumns(C_AGENCIA.values());
		table.setColumnHeaders(L_AGENCIA);
		table.setWidth("500px");
		
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
		Set<Integer> selecao = (Set<Integer>)table.getValue();
		if(selecao.isEmpty()) {
			controller.getViewManager().mostreAviso("É necessário selecionar alguma linha para exclusão.");
			return;
		}
		exclua(selecao);
	}
	
	private void exclua(Set<Integer> ids) {
		List<Agencia> entidades = new ArrayList<Agencia>();
		for(Integer id : ids) {
			entidades.add((Agencia)lista.get(id));
		}
		controller.exclua(entidades);
		refresh();
	}
	
	@SuppressWarnings("unchecked")
	private void editeSelecionado() {
		Set<Integer> selecao = (Set<Integer>)table.getValue();
		if(selecao.size() == 0 || selecao.size() > 1) {
			controller.getViewManager().mostreAviso("Selecione uma linha para edição.");
		} else {
			Integer id = (Integer)selecao.iterator().next();
			Agencia entidade = lista.get(id);
			controller.mostreEditar(this, entidade);
		}
	}
	
	public void refresh() {
		lista = controller.busqueTodos();
		if(lista == null) {
			lista = new ArrayList<Agencia>(0);
		}
		
		table.removeAllItems();
		container.removeAllItems();
		
		for(int i = 0; i < lista.size(); i++) {
			
			Agencia entidade = lista.get(i);
			Item item = container.addItem(i);
			
			item.getItemProperty(C_AGENCIA.ID).setValue(entidade.getId());
            item.getItemProperty(C_AGENCIA.NOME).setValue(entidade.getNome());
            item.getItemProperty(C_AGENCIA.NUMERO).setValue(entidade.getNumero());
            
		}
	}

}
