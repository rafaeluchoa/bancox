package edu.flf.aps.bancox.ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;


public class ConsultarSaldoView implements View {
	
	private VerticalLayout form;
	
	private TextField tfNumeroConta = new TextField();
	private Label lSaldo = new Label();
	
	private ConsultarSaldoController controller;
	
	public ConsultarSaldoView(ConsultarSaldoController controller) {
		this.controller = controller;
	}
	
	public ConsultarSaldoView _this(){
		return this;
		
	}
	
	@SuppressWarnings("serial")
	public void init(){
		form = new VerticalLayout();
		form.setSpacing(true);
		form.setMargin(true);
		
		form.addComponent(new Label("Número da Conta: ")); 
		// TODO: por enquanto deixa o usuario digitar o numero
		form.addComponent(tfNumeroConta);
		
		form.addComponent(new Label("Saldo: "));
		form.addComponent(lSaldo);
		
		Button bSaldo = new Button("Consultar Saldo");
		bSaldo.addListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				try {
					controller.consultarSaldo(_this());
				} catch(Exception e) {
					controller.getViewManager().mostreErro(e.getMessage());
				}
			}
			
		});
		form.addComponent(new Label(" "));
		form.addComponent(bSaldo);
	}
	
	//
	
	public String getNumeroConta() {
		return (String)tfNumeroConta.getValue();
	}
	
	public void setNumeroConta(String numeroConta) {
		tfNumeroConta.setValue(numeroConta);
	}
	
	public String getSaldo() {
		return (String)lSaldo.getValue();
	}
	
	public void setSaldo(String saldo) {
		lSaldo.setValue(saldo);
	}
	
	//
	
	@Override
	public Component getComponent() {
		return form;
	}
	
}