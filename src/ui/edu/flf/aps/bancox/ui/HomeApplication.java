package edu.flf.aps.bancox.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.TabSheet.Tab;

/**
 * @author rafaeluchoa
 */
@SuppressWarnings("serial")
@Service
@Scope("prototype")
public class HomeApplication extends Application implements ViewManager {


	@Autowired
	private Controller abrirContaController;
	
	@Autowired
	private Controller autenticarClienteController;

	private Window mainWindow = new Window("Banco X");
	private TabSheet tabs = new TabSheet();
	
	public HomeApplication _this() {
		return this;
	}

	private Component crieAcessoController(final String nome,
			final Controller controller) {
		Button b = new Button(nome);
		b.addListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				View view = controller.init(_this());
				Component c = view.getComponent();

				Tab t = tabs.addTab(c, nome, null);
				t.setClosable(true);
				tabs.setSelectedTab(c);
			}
		});
		return b;
	}

	private Component crieAcoes() {
		HorizontalLayout hl = new HorizontalLayout();
		hl.addComponent(crieAcessoController("Abrir Conta", abrirContaController));
		hl.addComponent(crieAcessoController("Acessar Conta", autenticarClienteController));
		return hl;
	}

	public final Window crieWindow() {
		tabs.setSizeFull();
		mainWindow.addComponent(crieAcoes());
		mainWindow.addComponent(tabs);
		((VerticalLayout) mainWindow.getContent()).setExpandRatio(tabs, 3);
		return mainWindow;
	}

	@Override
	public final void init() {
		this.setMainWindow(crieWindow());
	}
	
	@Override
	public void feche(View view) {
		tabs.removeComponent(view.getComponent());
	}

	@Override
	public void mostreMensagem(String msg) {
		TelaUtils.mostreMsg(mainWindow, msg);
	}
	
	@Override
	public void mostreErro(String erro) {
		TelaUtils.mostreMsg(mainWindow, erro);
	}

	@Override
	public Window getWindow() {
		return mainWindow;
	}

}
