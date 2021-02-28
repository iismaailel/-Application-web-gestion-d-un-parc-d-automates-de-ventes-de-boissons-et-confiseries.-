package fr.pwa.webservice.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.pwa.webservice.model.Automate;
import fr.pwa.webservice.util.HibernateUtil;


public class AutomateDAO {
	SessionFactory factory= HibernateUtil.getSessionFactory();
	
	public List<Automate> listerAutomates( ){
	      Session session = factory.openSession();
	      Transaction trans = null;
	      try {
	    	  trans = session.beginTransaction();
	         List<Automate> automates = session.createQuery("FROM Automate").list(); 	       
	         trans.commit();
	         session.close(); 
	         return automates;
	      } catch (HibernateException e) {
	         if (trans!=null) trans.rollback();
	         e.printStackTrace(); 
	      } 
	      return null;
	   }
		
	public void AjouterAutomate( Automate auto) {

	        Session session = factory.openSession();
	        session.beginTransaction();
	        session.save(auto);
	        session.getTransaction().commit();
	   	 	session.close(); 
	}
	
	public Automate fetchAuto(String id) {
		Session session= factory.openSession();
		session.beginTransaction();
		Automate r= (Automate) session
                .createQuery("select r from Automate r where r.numSerie = :pid")
                .setParameter("pid", id)
                .uniqueResult();
		session.getTransaction().commit();
		session.close();
		return r;
	}
	
	public void supprimerAutomate(String id){
	      Session session = factory.openSession();
	      Transaction trans = null;
	      
	      try {
	    	  trans = session.beginTransaction();
	         Automate automate = (Automate)session.get(Automate.class, id); 
	         session.delete(automate); 
	         trans.commit();
	      } catch (HibernateException e) {
	         if (trans!=null) trans.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
 
	public void modifierAuto(Automate a){
	      Session session = factory.openSession();
	      Transaction trans = null;
	      
	      try {
	    	  trans = session.beginTransaction();
	         Automate auto = (Automate)session.get(Automate.class,a.getNumSerie()); 
	         auto.setAdresse_insta(a.getAdresse_insta());
	         auto.setEmplacement(a.getEmplacement());
	         auto.setGpsLatitude(a.getGpsLatitude());
	         auto.setGpsLongitude(a.getGpsLongitude());
	         auto.setNotes(a.getNotes());        
	         session.update(auto); 
	         trans.commit();
	      } catch (HibernateException e) {
	         if (trans!=null) trans.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
}
