package edu.flf.aps.bancox.ui;

import com.vaadin.ui.Component;

public interface View {

	Component getComponent();
	void setViewManager(ViewManager viewManager);
	ViewManager getViewManager();

}
