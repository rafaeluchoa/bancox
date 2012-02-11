package com.naskar.infrastructure.ui;

import com.vaadin.ui.Component;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;

public class MsgUtils {
	
	public static Window getRootWindow(Component c) {
		Window w = c.getWindow();
		while(w.getParent() != null) w = (Window)w.getParent();
		return w;
	}
	
	public static void showMsg(Component c, String msg) {
		getRootWindow(c)
			.showNotification(msg, Notification.TYPE_HUMANIZED_MESSAGE);
	}
		
	public static void showWarn(Component c, String msg) {
		getRootWindow(c).
			showNotification(msg, Notification.TYPE_WARNING_MESSAGE);
	}
	
	public static void showError(Component c, String msg) {
		getRootWindow(c).
			showNotification(msg, Notification.TYPE_ERROR_MESSAGE);
	}
	
}
