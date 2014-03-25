package org.shareezy.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

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

	@Inject
	private EntityManagerFactory emf;
	private Ressource ressource;
	private EntityManager em;
	private Typ typ;
	private List<Typ> typListe;

	/**
	 * Die init() Methode dient zum erzeugen des ressource Objekts, das später
	 * mit Inhalten befüllt wird und es werden Typen aus der Datenbank geladen,
	 * damit sie im SelectOneMenu angezeigt werden können.
	 * 
	 */
	public NeueRessourceBean()
	{
		ressource = new Ressource();
	}
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT t FROM Typ t");
		typListe = query.getResultList();
		if (typListe == null) {
			typListe = new ArrayList<Typ>();
		} 
		
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * In der speichern Methode wird das ressorce Objekt befüllt und mit
	 * setTyp() der ausgewählte Typ zugeordnet
	 */
	public String speichern() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		ressource.setTyp(typ);
		ressource.setEinstellungsdatum(new Date());
		em.persist(ressource);
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