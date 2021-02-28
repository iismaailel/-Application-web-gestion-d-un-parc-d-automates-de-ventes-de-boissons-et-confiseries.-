package fr.pwa.webservice.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.pwa.webservice.model.Article;
import fr.pwa.webservice.model.Automate;
import fr.pwa.webservice.model.Rapport;
import fr.pwa.webservice.util.HibernateUtil;


public class RapportDAO {
	SessionFactory factory=HibernateUtil.getSessionFactory();
	
	public List<Rapport> listerRapports( ){
	      Session session = factory.openSession();
	      Transaction trans = null;
	      try {
	    	 trans = session.beginTransaction();
	         List<Rapport> rapports = (List<Rapport>) session.createQuery("select r from Rapport r order by montant ").list(); 	       
	         trans.commit();
	         session.close(); 
	         return rapports;
	      } catch (HibernateException e) {
	         if (trans!=null) trans.rollback();
	         e.printStackTrace(); 
	      } 
	      return null;
	   }
	
	
	public Rapport fetchRapport(int id) {
		Session session= factory.openSession();
		session.beginTransaction();
		Rapport r= (Rapport) session
                .createQuery("select r from Rapport r where r.id = :pid")
                .setParameter("pid", id)
                .uniqueResult();
		session.getTransaction().commit();
		session.close();
		return r;
	}
	
	public Rapport fetchRapp(String id) {
		Session session= factory.openSession();
		session.beginTransaction();
		Rapport r= (Rapport) session
                .createQuery("select r from Rapport r where r.numSerieR = :pid")
                .setParameter("pid", id)
                .uniqueResult();
		session.getTransaction().commit();
		session.close();
		return r;
	}
	
	public void ajouterRapport(Rapport rapport) {

	        Session session = factory.openSession();
	        session.beginTransaction();
	        session.save(rapport);
	        session.getTransaction().commit();
	}
	
	
	public void SupprimerRapport(int RapportID){
	      Session session = factory.openSession();
	      Transaction trans = null;
	      
	      try {
	    	 trans = session.beginTransaction();
	         Rapport rapport = (Rapport)session.get(Rapport.class, RapportID); 
	         session.delete(rapport); 
	         trans.commit();
	      } catch (HibernateException e) {
	         if (trans!=null) trans.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	
	
	

	
	
	public List<Article> reaprovisionnement() {
		Session session = factory.openSession();
	      Transaction trans = null;
	      List<Article> art= new ArrayList<Article>();
	    
	      try {
	    	 trans = session.beginTransaction();
	         List<Rapport> rapports = (List<Rapport>) session.createQuery("select r from Rapport r order by montant ").list();
	         trans.commit();
	        List<Article> ListArticle= new ArrayList<Article>();
	        Session session2=factory.openSession();
	        session2.beginTransaction();
	         for (Rapport r :rapports){       	 
	        	 //trouver l'automate pour avoir le type
	        	 String id=r.getNumero_serie();	        	 
	        	 
	        	 String type= (String) session2
	                     .createQuery("select r.type from Automate r where r.numSerie = '"+id+"'")
	                     .uniqueResult();
	        	 ListArticle=r.getArticles();
	        	 for(Article article: ListArticle) {
	        		 
	        		 if(type.equalsIgnoreCase("BOISSON CHAUDE ")) {
	        			 //regarder la T
	        			 if(r.getTemperature()>25 ) {
	        				 if(article.getQuantite()<30) {
	        					 art.add(article);
	        				 }
	        			 }
	        			 else {
	        				 if(article.getQuantite()<=10) {
	        					 art.add(article);
	        				 }
	        			 }
	        		 }
	        		 else if(type.equalsIgnoreCase("BOISSIN FRAICHE ")) {
	        			 if(r.getTemperature()<=5 ) {
	        				 if(article.getQuantite()<30) {
	        					 art.add(article);
	        				 }
	        			 }
	        			 else {
	        				 if(article.getQuantite()<=10) {
	        					 art.add(article);
	        				 }
	        			 }
	        		 }
	        		 else {
	        			 if(article.getQuantite()<=10) {
        					 art.add(article);
        				 }
	        		 }
	        		 
	        	 }
	        	 
	         }
	         session2.getTransaction().commit();
		     session.close();
	         session2.close();
	         
	         return art;
	         
	      } catch (HibernateException e) {
	         if (trans!=null) trans.rollback();
	         e.printStackTrace(); 
	         session.close();
	      }
	      return null;
	}
	
}
