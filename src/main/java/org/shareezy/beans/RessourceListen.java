/**
 * 
 */
package org.shareezy.beans;

import javax.faces.bean.ManagedBean;

/**
 * Diese Klasse stellt die Eigenschaften und Funktinen für das Listen von Ressourcen zur Verfügung.
 * Ressourcen werden in der Ressourcenansicht.xhtml, EigeneRessourcen.xhtml, Gruppenverwaltung.xhtml und eigeneBuchungen.xhtml
 * gelistet.
 * 
 * @author e1_treibmann
 *
 */
@ManagedBean
public class RessourceListen {
	/**
	 * Die Methode ressourceClicked leitet bei einem Klick auf den Namen der Ressource, den Benutzer auf die Detailansicht der Ressource weiter.
	 * @return "ressourcendetail" gibt die ressourcendetail zurück wenn auf einen Ressourcennamen geklickt wurde.
	 */
	public String ressourceClicked(){
	return "ressourcendetail";
	}

}
