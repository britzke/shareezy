package org.shareezy;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener Implementierung Initialisiert das
 * Context-Attribut "mail.properties" aus den Context-Parametern.
 */
@WebListener
public class ContextListener implements ServletContextListener {

	/**
	 * Erzeugt aus den folgenden Kontextparametern ein Properties-Objekt und
	 * speichert es in das Context-Attribut "org.shareezy.MAIL_PROPERTIES"
	 * <dl>
	 * <dt>org.shareezy.MAIL_FROM</dt>
	 * <dd>mail.from - E-Mailadresse des Absenders</dd>
	 * <dt>org.shareezy.MAIL_SMTP_STARTTLS</dt>
	 * <dd>mail.smtp.starttls - Gibt an, ob die Authentisierung mit dem
	 * SMTP-Server mittels TLS durchgeführt wird</dd>
	 * <dt>org.shareezy.MAIL_SMTP_AUTH</dt>
	 * <dd>mail.smtp.auth - Gibt an, ob eine Authentisierung mit dem SMTP-Server
	 * durchgeführt werden muss</dd>
	 * <dt>org.shareezy.MAIL_SMTP_HOST</dt>
	 * <dd>mail.smtp.host - Name des SMTP-Mailservers</dd>
	 * <dt>org.shareezy.MAIL_SMTP_PORT</dt>
	 * <dd>mail.smtp.port - Port, an dem der SMTP-Service zur Verfügung gestellt
	 * wird</dd>
	 * <dt>org.shareezy.MAIL_SMTP_USER</dt>
	 * <dd>mail.smtp.user - Name des Benutzers am SMTP-Server (wird nur
	 * beachtet, wenn org.shareezy.MAIL_SMTP_AUTH=true)</dd>
	 * <dt>org.shareezy.MAIL_SMTP_WORD</dt>
	 * <dd>mail.smtp.word - Kennwort des Benutzers am SMTP-Server (wird nur
	 * beachtet, wenn org.shareezy.MAIL_SMTP_AUTH=true)</dd>
	 * </dl>
	 * 
	 * Das Kontext-Attribut kann innerhalb der Applikation genutzt werden, um
	 * E-Mails mit Hilfe javax.mail-APIs zu versenden und zu empfangen.
	 * 
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent e) {
		Properties ps = new Properties();
		ServletContext sc = e.getServletContext();
		ps.put("mail.from", sc.getInitParameter("org.shareezy.MAIL_FROM"));
		ps.put("mail.smtp.host",
				sc.getInitParameter("org.shareezy.MAIL_SMTP_HOST"));
		ps.put("mail.smtp.port", Integer.parseInt(sc
				.getInitParameter("org.shareezy.MAIL_SMTP_PORT")));
		ps.put("mail.smtp.starttls.enable", Boolean.parseBoolean(sc
				.getInitParameter("org.shareezy.MAIL_SMTP_STARTTLS_ENABLE")));

		boolean smtpAuth = Boolean.parseBoolean(sc
				.getInitParameter("org.shareezy.MAIL_SMTP_AUTH"));
		ps.put("mail.smtp.auth", smtpAuth);
		if (smtpAuth) {
			ps.put("mail.smtp.user",
					sc.getInitParameter("org.shareezy.MAIL_SMTP_USER"));
			ps.put("mail.smtp.word",
					sc.getInitParameter("org.shareezy.MAIL_SMTP_WORD"));
			sc.setAttribute("org.shareezy.MAIL_PROPERTIES", ps);
			sc.log("SHAREEZY: Context Attribut 'org.shareezy.MAIL_PROPERTIES' hinzugefügt");
		}
	}

	/**
	 * Leerer Platzhalter (wird nicht benötigt).
	 * 
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent e) {
	}
}
