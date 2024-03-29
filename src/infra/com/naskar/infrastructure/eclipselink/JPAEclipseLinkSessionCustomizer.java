package com.naskar.infrastructure.eclipselink;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.eclipse.persistence.config.SessionCustomizer;
import org.eclipse.persistence.sessions.JNDIConnector;
import org.eclipse.persistence.sessions.Session;

/**
 * See http://wiki.eclipse.org/Customizing_the_EclipseLink_Application_(ELUG)w
 * Use for clients that would like to use a JTA SE pu instead of a
 * RESOURCE_LOCAL SE pu.
 */
public class JPAEclipseLinkSessionCustomizer implements SessionCustomizer {
	/**
	 * Get a dataSource connection and set it on the session with
	 * lookupType=STRING_LOOKUP
	 */
	public void customize(Session session) throws NamingException {
		new InitialContext();
		JNDIConnector connector = (JNDIConnector) session.getLogin().getConnector(); // possible
																		// CCE
		// Change from COMPOSITE_NAME_LOOKUP to STRING_LOOKUP
		// Note: if both jta and non-jta elements exist this will only
		// change the first one - and may still result in the
		// COMPOSITE_NAME_LOOKUP being set
		// Make sure only jta-data-source is in persistence.xml with no
		// non-jta-data-source property set
		connector.setLookupType(JNDIConnector.STRING_LOOKUP);
	}

}
