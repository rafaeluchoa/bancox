package edu.flf.aps.bancox.ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Component.Event;
import com.vaadin.ui.Component.Listener;

import edu.flf.aps.bancox.domain.Agencia;

/**
 * @author rafaeluchoa
 */
public class ManterAgenciaFormView implements View {
	
	private ManterAgenciaController controller;
	private ManterAgenciaListView listView;
	
	private Agencia entidade;
	
	private VerticalLayout form;

	// agencia
	private Label lbNome = new Label(); 
	private Label lbId = new Label();
	private TextField tfNome = new TextField();
	private TextField tfNumero = new TextField();

	public ManterAgenciaFormView(
		ManterAgenciaController controller,
		ManterAgenciaListView listView,
		Agencia entidade) {
		this.controller = controller;
		this.listView = listView; 
		this.entidade = entidade;
	}

	public ManterAgenciaFormView _this() {
		return this;
	}
	
	public String getNome() {
		return (String)lbNome.getValue();
	}

	public void init() {
		form = new VerticalLayout();
		form.setSpacing(true);
		form.setMargin(true);
		
		lbNome.setValue((entidade.getId() != null ? "Edição" : "Novo") + " Agência");
		
		form.addComponent(lbNome);
		form.addComponent(crieFormulario());
		
		setEntidade(entidade);
	}
	
	private VerticalLayout crieFormulario() {
		int i = -1;
		GridLayout grid = new GridLayout(2, 3);
		grid.setSpacing(true);
		grid.setMargin(true);
		
		if(entidade.getId() != null) {
			i++;
			grid.addComponent(new Label("Id:"), 0, i);
			grid.addComponent(lbId, 1, i);
		}
		
		i++;
		grid.addComponent(new Label("Nome:"), 0, i);
		grid.addComponent(tfNome, 1, i);
		
		i++;
		grid.addComponent(new Label("Número:"), 0, i);
		grid.addComponent(tfNumero, 1, i);
		
		// 
		HorizontalLayout botoes = new HorizontalLayout();
		botoes.setSpacing(true);
		
		Button salvar = new Button("Salvar");
		salvar.addListener(new Listener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void componentEvent(Event event) {
				controller.salve(_this());
				// TODO: analisar melhor forma de integrar duas views pelo controller
				listView.atualize();
			}
		});
		botoes.addComponent(salvar);
		
		Button cancelar = new Button("Cancelar");
		cancelar.addListener(new Listener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void componentEvent(Event event) {
				controller.cancele(_this());
				listView.atualize();
			}
		});
		botoes.addComponent(cancelar);
		
		//
		VerticalLayout layout = new VerticalLayout();
		layout.setSpacing(true);
		layout.addComponent(grid);
		layout.addComponent(botoes);
		
		return(layout);
	}
	
	public void setEntidade(Agencia entidade) {
		if(entidade == null) {
			return;
		}
		
		this.entidade = entidade;
		
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
	public Agencia getEntidade() {
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
	

}
