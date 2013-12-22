/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	burghard.britzke (bubi@charmides.in-berlin.de)
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.shareezy.validators;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
//import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.shareezy.entities.Benutzer;

/**
 * Stellt sicher, dass eine Benutzerkennung einzigartig ist.
 * <p>
 * <small>Dieser Validator ist als NamedBean implementiert, da die Injektion von
 * Beans in Validatoren frühestens ab JSF-2.3 funktioniert.</small>
 * </p>
 * 
 * @author burghard.britzke
 * @see http://stackoverflow.com/questions/7572335/
 * @see http://jdevelopment.nl/jsf-22/#injection
 */
@Named
// @FacesValidator(value = "uniqueKurzname")
public class UniqueKurznameValidator implements Validator {
	@Inject
	EntityManagerFactory entityManagerFactory;

	/**
	 * Validiert, dass eine Benutzerkennung einmalig in der Datenbank ist.
	 * 
	 * @param facesContext
	 *            wird nicht verwendet
	 * @param component
	 *            Wird nicht verwendet
	 * @param kurzname
	 *            zu validierender Kurzname
	 * @throws ValidatorException
	 *             wenn der Kurzname bereits in der Datenbank vorhanden ist
	 */
	@Override
	public void validate(FacesContext facesContext, UIComponent component,
			Object kurzname) throws ValidatorException {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em
				.createQuery("select b.kurname from Benutzer b where b.kurzname=:kurzname");
		q.setParameter("kurzname", kurzname);

		@SuppressWarnings("unchecked")
		List<Benutzer> result = (List<Benutzer>) q.getResultList();
		if (result.size() != 0) {
			String message = String.format(
					"Die Benutzerkennung %s ist bereits vorhanden", kurzname);
			throw new ValidatorException(new FacesMessage(message));
		}
	}
}
