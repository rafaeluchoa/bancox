package edu.flf.aps.bancox.infrastruture.ui;

import com.vaadin.ui.Window;

public interface ViewManager {
	
	void addView(View view, String nome);
	void removeView(View view);
	
	void mostreMensagem(String msg);
	void mostreErro(String error);
	void mostreAviso(String aviso);
	
	Window getWindow();
	
}
