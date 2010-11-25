package edu.flf.aps.bancox.ui;

import com.vaadin.ui.Component;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;

public class TelaUtils {
	
	public static Window getWindowRaiz(Component c) {
		Window w = c.getWindow();
		while(w.getParent() != null) w = (Window)w.getParent();
		return w;
	}
	
	public static void mostreMsg(Component c, String mensagem) {
		getWindowRaiz(c)
			.showNotification(mensagem, Notification.TYPE_HUMANIZED_MESSAGE);
	}
		
	public static void mostreAviso(Component c, String msg) {
		getWindowRaiz(c).
			showNotification(
				"Erro", msg,
				Notification.TYPE_WARNING_MESSAGE
			);
	}
	
	public static void mostreErro(Component c, String msg) {
		getWindowRaiz(c).
			showNotification(
				"Erro", msg,
				Notification.TYPE_ERROR_MESSAGE
			);
	}
	
}
