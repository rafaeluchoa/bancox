package edu.flf.aps.bancox.infrastruture.ui;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class Controller {
	
	@Autowired
	private ViewFactory viewFactory;
	
	private ViewManager viewManager;

	public ViewManager getViewManager() {
		return viewManager;
	}

	public void setViewManager(ViewManager viewManager) {
		this.viewManager = viewManager;
	}
	
	public ViewFactory getViewFactory() {
		return viewFactory;
	}

	public void setViewFactory(ViewFactory viewFactory) {
		this.viewFactory = viewFactory;
	}

	public abstract View init();

}
