package com.naskar.infrastructure.ui;

import com.vaadin.ui.Component;

/**
 * View do MVC
 * 
 * @author rafael
 *
 */
public interface View {

	/**
	 * Retorna o componente visual dessa view.
	 */
	Component getComponent();
	
	void init();
	
	ViewManager getViewManager();
	
	void setViewManager(ViewManager viewManager);
	
}
