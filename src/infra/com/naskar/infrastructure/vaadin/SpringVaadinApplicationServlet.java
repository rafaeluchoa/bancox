package com.naskar.infrastructure.vaadin;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;

/**
 * Inicializa o Spring e configura a application do Vaadin.
 * 
 * @author rafael
 */
@SuppressWarnings("serial")
public class SpringVaadinApplicationServlet extends AbstractApplicationServlet {
	/**
	 * nome do bean do spring que sera usado como application.
	 */
	private String nameSpringBeanApplication;

	private WebApplicationContext applicationContext;

	/**
	 * Class do application.
	 * 
	 * @uml.property name="applicationClass"
	 */
	private Class<? extends Application> applicationClass;

	/**
	 * @return
	 * @throws ClassNotFoundException
	 * @uml.property name="applicationClass"
	 */
	@Override
	protected final Class<? extends Application> getApplicationClass()
			throws ClassNotFoundException {
		return applicationClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public final void init(final ServletConfig config) throws ServletException {
		super.init(config);

		nameSpringBeanApplication = config
				.getInitParameter("nameSpringBeanApplication");
		applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(config.getServletContext());
		applicationClass = (Class<? extends Application>) applicationContext
				.getType(nameSpringBeanApplication);
	}

	@Override
	protected final Application getNewApplication(final HttpServletRequest request)
			throws ServletException {
		return (Application) applicationContext.getBean(nameSpringBeanApplication);
	}

}
