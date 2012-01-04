package edu.flf.aps.bancox.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import edu.flf.aps.bancox.infrastruture.ui.Controller;
import edu.flf.aps.bancox.infrastruture.ui.TelaUtils;
import edu.flf.aps.bancox.infrastruture.ui.View;
import edu.flf.aps.bancox.infrastruture.ui.ViewManager;

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
	
	@Autowired
	private Controller consultarSaldoController;
	
	@Autowired
	private Controller manterAgenciaController;

	private Window mainWindow = new Window("Banco X");
	private TabSheet tabs = new TabSheet();
	
	public HomeApplication _this() {
		return this;
	}

	private Component crieAcessoController(final String nome,
			final Controller controller) {
		
		controller.setViewManager(_this());
		
		Button b = new Button(nome);
		b.addListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				
				View view = controller.init();
				addView(view, nome);
				
			}
		});
		return b;
	}

	private Component crieAcoes() {
		HorizontalLayout hl = new HorizontalLayout();
		hl.setSpacing(true);
		hl.setMargin(true);
		hl.addComponent(crieAcessoController("Abrir Conta", abrirContaController));
		hl.addComponent(crieAcessoController("Acessar Conta", autenticarClienteController));
		hl.addComponent(crieAcessoController("Consultar Saldo", consultarSaldoController));
		hl.addComponent(crieAcessoController("Manter Agência", manterAgenciaController));
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
	public void addView(View view, String nome) {
		Component c = view.getComponent();
		Tab t = tabs.addTab(c, nome, null);
		t.setClosable(true);
		tabs.setSelectedTab(c);
	}
	
	@Override
	public void removeView(View view) {
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
	public void mostreAviso(String aviso) {
		TelaUtils.mostreAviso(mainWindow, aviso);
	}

	@Override
	public Window getWindow() {
		return mainWindow;
	}
	
}
