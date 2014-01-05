package org.shareezy.beans;

import java.awt.Image;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.shareezy.entities.Ressource;

/**
 * Klasse ist zustaendig fuer die detailierte Ansicht der Ressourcen. Ansicht
 * besteht aus Bild, Beschreibung, Kalender und dem Buchungsbutton
 * 
 * @author Vanessa Krohn
 * @date 05/12/13
 */

public class RessourcenDetailBean {
	
	private EntityManagerFactory emf;
	private Ressource ressource;

	private Image pic;
	private String summary;
	
	/**
	 * erzeugt eine neue RessourcenDetailBean
	 * initialisiert Ressource
	 */
	public RessourcenDetailBean() {
		ressource = new Ressource();
	}
	
	/**
	 * liest aus der Entität "Ressource" der Datenbank einen Datensatz aus
	 * 
	 */
	public String selectDatensatz() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select re from Ressource re");
		
		List<Ressource> ressource = q.getResultList();
		for(Ressource re : ressource){
			System.out.println(re);
		}
	
		return null;
	}
	
	/**
	 * Um den TimePicker zu oeffnen wird beim Klick auf den Buchungsbutton
	 * (Detailressourcenansicht) ausgefuehrt
	 */
	public String timePicker() {
		return null;
	}

	/**
	 * zeigt ein Bild der Ressource an
	 * 
	 */
	public Image resourcePic() {
		return pic;
	}

	/**
	 * zustaendig fuer die Beschreibung der Ressource
	 * 
	 */
	public String resourceSummary() {
		return summary;
	}
}
