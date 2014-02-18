package org.shareezy.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.shareezy.beans.AccountBearbeitenBean;

public class AccountBearbeitenValidator implements Validator {

	String eingabePasswortWiederholen;
	String eingabePasswortAlt;
	AccountBearbeitenBean bean;
	EntityManagerFactory entityManagerFactory;
	String altesPasswort;

	public void validate(FacesContext context, UIComponent component,
			Object eingabePasswort) throws ValidatorException {

		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em
				.createQuery("select b.kurname from Benutzer b where b.kurzname=:kurzname");
		q.setParameter("kurzname", altesPasswort);

		eingabePasswortWiederholen = (String) context.getAttributes().get(
				eingabePasswortWiederholen);
		eingabePasswortAlt = (String) context.getAttributes().get(
				eingabePasswortAlt);
		altesPasswort = "123";

		if (eingabePasswort.equals("")) {
			bean.datensatzÄndern();
		} else {
			if (eingabePasswort.equals(eingabePasswortWiederholen)) {
				if (eingabePasswort.equals(eingabePasswortAlt)) {

					String message = String
							.format("Das neue passwort sollte nicht mit dem neuen Passwort übereinstimmen.");
					throw new ValidatorException(new FacesMessage(message));

				} else {
					if (eingabePasswortAlt.equals(altesPasswort)) {
						String eingabe = (String) eingabePasswort;
						bean.setEingabePasswort(eingabe);
						bean.datensatzÄndern();

					} else {
						String message = String
								.format("Das eingegebene Passwort ist falsch.");
						throw new ValidatorException(new FacesMessage(message));
					}

				}
			} else {
				String message = String
						.format("Die Passwörter müssen übereinstimmen.");
				throw new ValidatorException(new FacesMessage(message));
			}
		}

	}
}
