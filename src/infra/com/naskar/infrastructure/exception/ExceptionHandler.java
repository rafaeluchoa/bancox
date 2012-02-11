package com.naskar.infrastructure.exception;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;

import com.naskar.infrastructure.ui.Controller;


public class ExceptionHandler {
	
	// resourceBundle com as mensagens por exception: Ex.: ApplicationException=Error: {0}
	private static ResourceBundle bundle = ResourceBundle.getBundle("mensagensException");
	
	public Object trateException(ProceedingJoinPoint pjp) {
		try {
			return pjp.proceed();
		} catch(Throwable t) {
			trate(t, pjp);
			return null;
		}
	}
	
	private void trate(Throwable t, ProceedingJoinPoint pjp) {
		String msg = null;
		Throwable raiz = getRaiz(t);
		
		if (raiz instanceof ApplicationException) {
			msg = raiz.getMessage();
			if(bundle.containsKey(raiz.getClass().getSimpleName())) {
				msg += " " + MessageFormat.format(
						bundle.getString(raiz.getClass().getSimpleName()), // pattern
						((ApplicationException)raiz).getDados()
				);
			}
			
		} else {
			msg = raiz.getMessage();
		}		
		
		if(pjp.getTarget() instanceof Controller) {
			((Controller)pjp.getTarget()).getViewManager().showError(msg);
		} else {
			throw new RuntimeException(msg, t);
		}
		
		// TODO: gerar numero de codigo de erro
		logException(t, pjp, msg);
		
	}
	
	//	loga a mensagem
	private void logException(Throwable t, ProceedingJoinPoint pjp, String msg) {
		Logger log = Logger.getLogger(pjp.getTarget().getClass().getName());
		log.log(Level.SEVERE, t.getMessage(), t);	
	}
	
	private static Throwable getRaiz(Throwable ex) {
		Throwable e = ex;
		while(e.getCause() != null) e = (Throwable)e.getCause();
		return e;
	}

}
