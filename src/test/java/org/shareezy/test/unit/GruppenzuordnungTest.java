/**
 *Es wird geprüft welche Mitglieder Ressourcen inerhalb der Gruppe verwalten können.
 *Abfrage des Status der Ressource
 *Wenn jemand aus der Gruppe entfernt wird/geht.
 *Welche Ressource zur Gruppe hinzugefügt wird.
 *Nachträgliches bearbeiten der ressourcen zu gruppe/ID.
 *Ressource der gruppe hinzufügen.

 *@author e1_hermann
 *@version update 10.12.2013
 **/
package org.shareezy.beans;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Cache;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Id;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.SynchronizationType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

//import org.eclipse.persistence.jpa.config.Entity;
//import org.shareezy.test.unit.RegistrierungBeanTest.MockEntityManager;

@ManagedBean
@SessionScoped
public class Gruppenzuordnung {

	public String gruppenersteller;
	public String leitunguebertragen;
	public String mitglied;
	public String account_id;
    public String accounts_id;
    public EntityManagerFactory emf;
    public EntityManager em;
    
    
    public class MockEntityManager implements EntityManager{
    	public EntityManager createEntityManager() {
			return new MockEntityManager();
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void close() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean contains(Object arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public <T> EntityGraph<T> createEntityGraph(Class<T> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public EntityGraph<?> createEntityGraph(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query createNamedQuery(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> TypedQuery<T> createNamedQuery(String arg0, Class<T> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public StoredProcedureQuery createNamedStoredProcedureQuery(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query createNativeQuery(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query createNativeQuery(String arg0, Class arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query createNativeQuery(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query createQuery(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> TypedQuery<T> createQuery(CriteriaQuery<T> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query createQuery(CriteriaUpdate arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query createQuery(CriteriaDelete arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> TypedQuery<T> createQuery(String arg0, Class<T> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public StoredProcedureQuery createStoredProcedureQuery(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public StoredProcedureQuery createStoredProcedureQuery(String arg0,
				Class... arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public StoredProcedureQuery createStoredProcedureQuery(String arg0,
				String... arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void detach(Object arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public <T> T find(Class<T> arg0, Object arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T find(Class<T> arg0, Object arg1, Map<String, Object> arg2) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2,
				Map<String, Object> arg3) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void flush() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public CriteriaBuilder getCriteriaBuilder() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getDelegate() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public EntityGraph<?> getEntityGraph(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public EntityManagerFactory getEntityManagerFactory() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public FlushModeType getFlushMode() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public LockModeType getLockMode(Object arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Metamodel getMetamodel() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<String, Object> getProperties() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T getReference(Class<T> arg0, Object arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public EntityTransaction getTransaction() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isJoinedToTransaction() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isOpen() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void joinTransaction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void lock(Object arg0, LockModeType arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void lock(Object arg0, LockModeType arg1,
				Map<String, Object> arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public <T> T merge(T arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void persist(Object arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void refresh(Object arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void refresh(Object arg0, Map<String, Object> arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void refresh(Object arg0, LockModeType arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void refresh(Object arg0, LockModeType arg1,
				Map<String, Object> arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void remove(Object arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setFlushMode(FlushModeType arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setProperty(String arg0, Object arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public <T> T unwrap(Class<T> arg0) {
			// TODO Auto-generated method stub
			return null;
		}
    	
    }

	public class MockEntityManagerFactory implements EntityManagerFactory{

		@Override
		public EntityManager createEntityManager() {
			return null;
		}

		@Override
		public EntityManager createEntityManager(Map map) {
			return null;
		}

		@Override
		public EntityManager createEntityManager(
				SynchronizationType synchronizationType) {
			return null;
		}

		@Override
		public EntityManager createEntityManager(
				SynchronizationType synchronizationType, Map map) {
			return null;
		}

		@Override
		public CriteriaBuilder getCriteriaBuilder() {
			return null;
		}

		@Override
		public Metamodel getMetamodel() {
			return null;
		}

		@Override
		public boolean isOpen() {
			return false;
		}

		@Override
		public void close() {
			
		}

		@Override
		public Map<String, Object> getProperties() {
			return null;
		}

		@Override
		public Cache getCache() {
			return null;
		}

		@Override
		public PersistenceUnitUtil getPersistenceUnitUtil() {
			return null;
		}

		@Override
		public void addNamedQuery(String name, Query query) {
			
		}

		@Override
		public <T> T unwrap(Class<T> cls) {
			return null;
		}

		@Override
		public <T> void addNamedEntityGraph(String graphName,
				EntityGraph<T> entityGraph) {
			
		}
		
	}
	

	/**
	 * Welches Mitglied ist berechtigt zum abfragen/erstellen/verwalten von
	 * Ressourcen
	 * 
	 * @return accountID
	 */
	public String mitgliederabfragen() {
		return account_id;
		
	}

	/**
	 * Abfrage des status der ressource
	 * 
	 * @return
	 */
	public String ressourcestatus() {

		return accounts_id;

	}

	/**
	 * Mitglied aus der Gruppe entfernen/gruppenID
	 * 
	 * @return
	 */
	public String mitgliedentfernen() {
		return null;
	}

	/**
	 * Ressource zur gruppe hinzufügen. Erstmal aus der View abfragen, dann
	 * Datenbankabfrage
	 * 
	 * @return
	 */
	public String addressourcen(int ressourcenid) {
		return null;
	}

	/**
	 * bearbeiten der ressource
	 * 
	 * @return
	 */
	public String editressource() {
		return null;
	}

}
