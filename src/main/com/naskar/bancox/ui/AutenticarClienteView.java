package com.naskar.bancox.ui;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.naskar.infrastructure.ui.View;
import com.naskar.infrastructure.ui.ViewManager;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;


/**
 * @author rafaeluchoa
 */
@Service
@Scope("prototype")
public class AutenticarClienteView implements View {
	
	private VerticalLayout form;

	private TextField tfNumeroConta = new TextField();
	
	private final TextField tfSenha = new TextField();
	private final List<Integer[]> digitados = new ArrayList<Integer[]>(); 

	@Autowired
	private AutenticarClienteController controller;
	
	private ViewManager viewManager;
	
	public ViewManager getViewManager() {
		return viewManager;
	}

	public void setViewManager(ViewManager viewManager) {
		this.viewManager = viewManager;
	}

	public AutenticarClienteView _this() {
		return this;
	}

	@SuppressWarnings("serial")
	public void init() {
		form = new VerticalLayout();
		form.setSpacing(true);
		form.setMargin(true);
		
		form.addComponent(new Label("Número da Conta: "));
		form.addComponent(tfNumeroConta);
		
		tfSenha.setEnabled(false);
		tfSenha.setValue("");
		form.addComponent(new Label("Senha (Use o teclado abaixo): "));
		form.addComponent(tfSenha);

		List<Integer[]> digitos = controller.gerarTeclasAleatorias();
		form.addComponent(new Label("Teclado Numérico: "));
		for(final Integer[] tecla : digitos) {
			Button botao = new Button(tecla[0] + " - " + tecla[1]);
			botao.addListener(new ClickListener() {
				
				@Override
				public void buttonClick(ClickEvent event) {
					digitados.add(tecla);
					tfSenha.setValue(tfSenha.getValue()+"*");
				}
			});
			form.addComponent(botao);
		}
		
		Button btLimparSenha = new Button("Limpar Senha");
		btLimparSenha.addListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				digitados.clear();
				tfSenha.setValue("");				
			}
		});
		form.addComponent(new Label(""));
		form.addComponent(btLimparSenha);
			
		Button btAcessar = new Button("Acessar");
		btAcessar.addListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				controller.autenticar(_this());
			}
		});
		form.addComponent(new Label(""));
		form.addComponent(btAcessar);
	}

	public Component getComponent() {
		return form;
	}

	public List<Integer[]> getSenha() {
		return digitados;
	}
	
	public String getNumeroConta() {
		return (String)tfNumeroConta.getValue();
	}

}
