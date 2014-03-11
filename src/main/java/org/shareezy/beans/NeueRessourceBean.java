package org.shareezy.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.shareezy.entities.Benutzer;
import org.shareezy.entities.Ressource;
import org.shareezy.entities.Typ;

/**
 * Die neueRessourcenBean dient zum Erzeugen von neuen Ressourcen.
 * 
 * @author Klawitter, Mueller, Chenaux
 * @version 12.12.2013
 */
@RequestScoped
@Named("neueRessourcenBean")
public class NeueRessourceBean {

	/**
	 * 
	 */
	@Inject
	private EntityManagerFactory emf;
	private Ressource ressource;
	private EntityManager em;
	private Typ typ;
	private List<Typ> typListe;
	@Inject
	private Benutzer benutzer;

	/**
	 * Die init() Methode dient zum erzeugen des ressource Objekts, das mit
	 * Inhalten befüllt wird
	 * 
	 */
	@PostConstruct
	public void init() {

		em = emf.createEntityManager();
		EntityTransaction ent = em.getTransaction();
		ent.begin();
		ressource = new Ressource();
		em.persist(ressource);
		ladeTyp();
		ent.commit();
		em.close();
		this.typ = typListe.get(0);
	}

	/**
	 * Lädt die Typen aus der Datenbank
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void ladeTyp() {
		
		Query query = em.createQuery("SELECT t FROM Typ t");
		typListe = query.getResultList();
	}

	/**
	 * In der speichern Methode wird das ressorce Objekt befüllt und mit
	 * setTyp() der ausgewählte Typ zugeordnet
	 */
	public String speichern() {

		em = emf.createEntityManager();
		em.getTransaction().begin();
		ressource.setTyp(typ);
		em.merge(ressource);
		em.getTransaction().commit();
		em.close();

		return "ressourcenList.xhtml";
	}

	public Ressource getRessource() {
		return ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}

	public Typ getTyp() {
		return typ;
	}

	public void setTyp(Typ typ) {
		this.typ = typ;
	}

	public List<Typ> getTypListe() {
		return typListe;
	}

	public void setTypListe(List<Typ> typListe) {
		this.typListe = typListe;
	}

}