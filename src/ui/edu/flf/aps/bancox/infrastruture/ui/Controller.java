package edu.flf.aps.bancox.infrastruture.ui;

public abstract class Controller {
	
	private ViewManager viewManager;

	public ViewManager getViewManager() {
		return viewManager;
	}

	public void setViewManager(ViewManager viewManager) {
		this.viewManager = viewManager;
	}

	public abstract View init();

}
