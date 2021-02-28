package fr.pwa.webservice.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.pwa.webservice.model.Article;
import fr.pwa.webservice.model.ArticleId;
import fr.pwa.webservice.util.HibernateUtil;


public class ArticlesDAO {
	SessionFactory factory= HibernateUtil.getSessionFactory();
	
	public List<Article> listerArticles( ){
	      Session session = factory.openSession();
	      Transaction tx = null;	      
	      try {
	         tx = session.beginTransaction();
	         List<Article> articles = session.createQuery("FROM Article").list(); 
	         tx.commit();
	         session.close(); 
	         return articles;
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } 
	      return null;
	   }
	
	
	
	public void AjouterArticle( Article art) {

		 SessionFactory sf = HibernateUtil.getSessionFactory();
	        Session session = sf.openSession();
	        session.beginTransaction();

	        session.save(art);
	        session.getTransaction().commit();
	   	 	session.close(); 
	   	}
	
	public void SupprimerArticle(String Num,String Nom){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Article article = (Article)session.get(Article.class, new ArticleId(Num,Nom)); 
	         session.delete(article); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	
	public Article getArticles(String Num,String Nom){
	      Session session = factory.openSession();
	      Transaction trans = null;
	      
	      try {
	         trans = session.beginTransaction();
	         Article article = (Article)session.get(Article.class, new ArticleId(Num,Nom)); 
	         trans.commit();
	         return article;
	      } catch (HibernateException e) {
	         if (trans!=null) trans.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	         return null;

	   }
	
	
	
	public void UpdateArticle(String Num,String Nom ,int quantite){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Article article = (Article)session.get(Article.class,new ArticleId(Num,Nom)); 
	         article.setQuantite(quantite);
	         session.update(article); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
}
