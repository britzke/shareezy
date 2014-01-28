package org.shareezy.beans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.shareezy.entities.Benutzer;
import org.shareezy.entities.Buchung;
import org.shareezy.entities.Gruppe;
import org.shareezy.entities.Ressource;
import org.shareezy.entities.Typ;

/**
 * 
 */

/**
 * Die Annotation ManagedBean sorgt dafür, dass diese Klasse als ManagedBean
 * erkannt wird. SessionScoped sorgt dafür das diese ManagedBean nur bis zum
 * Ende der Session lebt.
 * 
 * @author ThomasKLawitter
 * @version 12.12.2013
 */
@ManagedBean
public class NeueRessourceBean {

	@Inject
	private EntityManagerFactory emf;
	private EntityManager em;
	private Benutzer benutzer;
	private String beschreibung;
	private byte[] bild;
	private List<Buchung> buchungen;
	private Date einstellungsdatum;
	private Date enddatum;
	private List<Gruppe> gruppen;
	private String name;
	private int id;
	private Date startdatum;
	private Typ typ;

	public NeueRessourceBean() {
		
		
		
	}

	/**
	 * Action-Routine für den View <code>neueRessource</code>. Wird
	 * angesprochen, wenn der Benutzer die Schaltfläche <code>löschen</code>
	 * anwählt. Sorgt dafür, dass Ressourcen aus der Ressourcenliste gelöscht
	 * werden können.
	 * 
	 * @return null - d. h. der View wird nicht gewechselt.
	 */
	public String loescheRessource(Ressource ressource) {
		em = emf.createEntityManager();
		EntityTransaction ent = em.getTransaction();
		ent.begin();
		ressource = em.merge(ressource);
		em.remove(ressource);
		ent.commit();
		em.close();
		return null;
	}

	/**
	 * Action-Routine für den View <code>neueRessource</code>. Wird
	 * angesprochen, wenn der Benutzer die Schaltfläche <code>speichern</code>
	 * anwählt. Sorgt dafür, dass die neu eingesetzten Werte für diese Ressource
	 * in der Datenbank gespeichert wird.
	 * 
	 * @return null - d. h. der View wird nicht gewechselt.
	 */
	public String speichern() {

		em.getTransaction().begin();
		Ressource ress = new Ressource();// muss später Injected werden
		ress.setBenutzer(benutzer);
		ress.setBeschreibung(beschreibung);
		ress.setBild(bild);
		ress.setBuchungens(buchungen);
		ress.setEinstellungsdatum(einstellungsdatum);
		ress.setEnddatum(enddatum);
		ress.setGruppens(gruppen);
		ress.setName(name);
		ress.setId(id);
		ress.setStartdatum(startdatum);
		ress.setTyp(typ);
		em.persist(ress);
		em.getTransaction().commit();
		em.close();
		return null;
	}

	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public byte[] getBild() {
		return bild;
	}

	public void setBild(byte[] bild) {
		this.bild = bild;
	}

	public List<Buchung> getBuchungen() {
		return buchungen;
	}

	public void setBuchungen(List<Buchung> buchungen) {
		this.buchungen = buchungen;
	}

	public Date getEinstellungsdatum() {
		return einstellungsdatum;
	}

	public void setEinstellungsdatum(Date einstellungsdatum) {
		this.einstellungsdatum = einstellungsdatum;
	}

	public Date getEnddatum() {
		return enddatum;
	}

	public void setEnddatum(Date enddatum) {
		this.enddatum = enddatum;
	}

	public List<Gruppe> getGruppen() {
		return gruppen;
	}

	public void setGruppen(List<Gruppe> gruppen) {
		this.gruppen = gruppen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartdatum() {
		return startdatum;
	}

	public void setStartdatum(Date startdatum) {
		this.startdatum = startdatum;
	}

	public Typ getTyp() {
		return typ;
	}

	public void setTyp(Typ typ) {
		this.typ = typ;
	}
}
