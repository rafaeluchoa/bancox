package edu.flf.aps.bancox.ui;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import edu.flf.aps.bancox.domain.Agencia;
import edu.flf.aps.bancox.domain.TipoContaBancaria;
import edu.flf.aps.bancox.domain.TipoPessoa;

/**
 * @author rafaeluchoa
 */
public class AbrirContaView implements View {
	
	private static final String L_AGENCIA_NOME = "L_AGENCIA_NOME";

	private ViewManager viewManager;
	private VerticalLayout form;

	private ComboBox cbAgencias = new ComboBox();
	private ComboBox cbTipoPessoa = new ComboBox();
	private ComboBox cbTipoConta = new ComboBox();

	// pessoa fisica
	private TextField tfFisicaCpf = new TextField();
	private TextField tfFisicaNome = new TextField();
	private TextField tfFisicaDtNascimento = new TextField();
	private TextField tfFisicaEmail = new TextField();

	// pessoa juridica
	private TextField tfJuridicaCnpj = new TextField();
	private TextField tfJuridicaRazaoSocial = new TextField();
	private TextField tfJuridicaEmail = new TextField();

	// TODO: criar painel para cadastro de enderenco

	private AbrirContaController controller;

	public AbrirContaView(AbrirContaController controller) {
		this.controller = controller;
	}

	public AbrirContaView _this() {
		return this;
	}

	@SuppressWarnings("serial")
	public void init(List<Agencia> agencias) {
		form = new VerticalLayout();

		form.addComponent(new Label("Ag�ncia: "));
		form.addComponent(cbAgencias);
		
		cbAgencias.setItemCaptionMode(AbstractSelect.ITEM_CAPTION_MODE_PROPERTY);
		cbAgencias.setItemCaptionPropertyId(L_AGENCIA_NOME);
		
		IndexedContainer containerAgencias = new IndexedContainer(new ArrayList<Agencia>());
		containerAgencias.addContainerProperty(L_AGENCIA_NOME, String.class, null);
		
		cbAgencias.setContainerDataSource(containerAgencias);
		
		for(Agencia a : agencias) {
			Item item = cbAgencias.addItem(a);
			item.getItemProperty(L_AGENCIA_NOME).setValue(a.getNome());
		}

		form.addComponent(new Label("Tipo de Pessoa: "));
		form.addComponent(cbTipoPessoa);
		
		for(TipoPessoa tp : TipoPessoa.values()) {
			cbTipoPessoa.addItem(tp.name());
		}
		
		cbTipoPessoa.setValue(TipoPessoa.FISICA);
		
		form.addComponent(new Label("Tipo de Conta Banc�ria: "));
		form.addComponent(cbTipoConta);
		
		for(TipoContaBancaria tcb : TipoContaBancaria.values()) {
			cbTipoConta.addItem(tcb.name());
		}
		
		cbTipoConta.setValue(TipoContaBancaria.CORRENTE);

		final Component pessoaFisica = criePanelPessoaFisica();
		final Component pessoaJuridica = criePanelPessoaJuridica();
		
		pessoaFisica.setVisible(true);
		pessoaJuridica.setVisible(false);
		form.addComponent(pessoaFisica);
		form.addComponent(pessoaJuridica);
		
		cbTipoPessoa.addListener(new BlurListener() {
			
			@Override
			public void blur(BlurEvent event) {
				if(
						(String)cbTipoPessoa.getValue() == null ||
						TipoPessoa.FISICA.equals(
							TipoPessoa.get((String)cbTipoPessoa.getValue())
						)
				)
				{
					pessoaFisica.setVisible(true);
					pessoaJuridica.setVisible(false);
				} else {
					pessoaFisica.setVisible(false);
					pessoaJuridica.setVisible(true);
				}
				
			}
		});

		
		Button btCriarConta = new Button("Efetuar Abertura de Conta");
		btCriarConta.addListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				controller.abraConta(_this());
			}
		});
		form.addComponent(new Label(""));
		form.addComponent(btCriarConta);
	}

	private Component criePanelPessoaFisica() {
		VerticalLayout formPessoaFisica = new VerticalLayout();

		formPessoaFisica.addComponent(new Label("CPF: "));
		formPessoaFisica.addComponent(tfFisicaCpf);

		formPessoaFisica.addComponent(new Label("Nome: "));
		formPessoaFisica.addComponent(tfFisicaNome);

		formPessoaFisica.addComponent(new Label("Data de Nascimento: "));
		formPessoaFisica.addComponent(tfFisicaDtNascimento);

		formPessoaFisica.addComponent(new Label("E-mail: "));
		formPessoaFisica.addComponent(tfFisicaEmail);

		return formPessoaFisica;
	}
	
	private Component criePanelPessoaJuridica() {
		VerticalLayout formPessoaJuridica = new VerticalLayout();

		formPessoaJuridica.addComponent(new Label("CNPJ: "));
		formPessoaJuridica.addComponent(tfJuridicaCnpj);

		formPessoaJuridica.addComponent(new Label("Raz�o Social: "));
		formPessoaJuridica.addComponent(tfJuridicaRazaoSocial);

		formPessoaJuridica.addComponent(new Label("E-mail: "));
		formPessoaJuridica.addComponent(tfJuridicaEmail);

		return formPessoaJuridica;
	}

	public Component getComponent() {
		return form;
	}

	public Agencia getAgencia() {
		return (Agencia) cbAgencias.getValue();
	}

	public TipoPessoa getTipoPessoa() {
		return (TipoPessoa.get((String)cbTipoPessoa.getValue()));
	}

	public TipoContaBancaria getTipoConta() {
		return (TipoContaBancaria.get((String)cbTipoConta.getValue()));
	}

	public String getFisicaNome() {
		return (String) tfFisicaNome.getValue();
	}

	public String getDtNascimento() {
		return (String) tfFisicaNome.getValue();
	}

	public String getFisicaEmail() {
		return (String) tfFisicaEmail.getValue();
	}
	
	public String getFisicaDtNascimento() {
		return (String) tfFisicaDtNascimento.getValue();
	}
	
	public String getJuridicaEmail() {
		return (String) tfJuridicaEmail.getValue();
	}

	public ViewManager getViewManager() {
		return viewManager;
	}

	public void setViewManager(ViewManager viewManager) {
		this.viewManager = viewManager;
	}

}
