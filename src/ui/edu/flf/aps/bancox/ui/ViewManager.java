package edu.flf.aps.bancox.ui;

import com.vaadin.ui.Window;

public interface ViewManager {
	void feche(View view);
	void mostreMensagem(String msg);
	void mostreErro(String error);
	Window getWindow();
}
