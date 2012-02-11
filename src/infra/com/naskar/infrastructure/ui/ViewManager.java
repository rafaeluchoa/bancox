package com.naskar.infrastructure.ui;

import com.vaadin.ui.Window;

public interface ViewManager {
	
	void addView(View view, String name);
	void removeView(View view);
	
	void showMsg(String msg);
	void showError(String error);
	void showWarn(String warn);
	
	Window getWindow();
	
}
