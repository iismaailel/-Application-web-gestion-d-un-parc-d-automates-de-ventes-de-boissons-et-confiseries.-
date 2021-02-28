package fr.pwa.webservice.services;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pwa.webservice.dao.ArticlesDAO;
import fr.pwa.webservice.dao.RapportDAO;
import fr.pwa.webservice.model.Article;

@Path("/article/")
public class ArticleService {
	
	RapportDAO Rapp= new RapportDAO();
	ArticlesDAO Artic= new ArticlesDAO();
	
	
	
	@Path("/get/")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Article> getArticles() {
		return Artic.listerArticles();
		
	}
	

	
	@Path("/reap/")
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Article> getReap(){
		return Rapp.reaprovisionnement();
	}
	

}
