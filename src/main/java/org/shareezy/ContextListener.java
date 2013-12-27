package org.shareezy;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener Implementierung Initialisiert das
 * Context-Attribut "mail.properties" aus den Context-Parametern.
 */
public class ContextListener implements ServletContextListener {

	/**
	 * Erzeugt aus den folgenden Kontextparametern ein Properties-Objekt und
	 * speichert es in das Context-Attribut "mail.properties"
	 * <dl>
	 * <dt>mail.from</dt>
	 * <dd>E-Mailadresse des Absenders</dd>
	 * <dt>mail.smtp.starttls</dt>
	 * <dd>Gibt an, ob die Authentisierung mit dem SMTP-Server mittels TLS
	 * durchgeführt wird</dd>
	 * <dt>mail.smtp.auth</dt>
	 * <dd>Gibt an, ob eine Authentisierung mit dem SMTP-Server durchgeführt werden muss</dd>
	 * <dt>mail.smtp.host</dt>
	 * <dd>Name des SMTP-Mailservers</dd>
	 * <dt>mail.smtp.port</dt>
	 * <dd>Port, an dem der SMTP-Service zur Verfügung gestellt wird</dd>
	 * <dt>mail.smtp.user</dt>
	 * <dd>Name des Benutzers am SMTP-Server</dd>
	 * <dt>mail.smtp.word</dt>
	 * <dd>Kennwort des Benutzers am SMTP-Server</dd>
	 * </dl>
	 * 
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent e) {
		Properties ps = new Properties();
		ServletContext sc = e.getServletContext();
		ps.put("mail.from", sc.getInitParameter("mail.from"));
		ps.put("mail.smtp.auth",
				Boolean.parseBoolean(sc.getInitParameter("mail.smtp.auth")));
		ps.put("mail.smtp.starttls.enable", Boolean.parseBoolean(sc
				.getInitParameter("mail.smtp.starttls.enable")));
		ps.put("mail.smtp.host", sc.getInitParameter("mail.smtp.host"));
		ps.put("mail.smtp.port",
				Integer.parseInt(sc.getInitParameter("mail.smtp.port")));
		ps.put("mail.smtp.user", sc.getInitParameter("mail.smtp.user"));
		ps.put("mail.smtp.word", sc.getInitParameter("mail.smtp.word"));
		sc.setAttribute("mail.properties", ps);
	}

	/**
	 * Leerer Platzhalter (wird nicht benötigt).
	 * 
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent e) {
	}

}
