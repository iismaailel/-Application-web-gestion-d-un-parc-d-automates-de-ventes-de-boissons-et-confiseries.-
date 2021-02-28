package fr.pwa.webservice.services;

import java.net.URISyntaxException;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import fr.pwa.webservice.dao.RapportDAO;
import fr.pwa.webservice.model.Rapport;


@Path("/rapport/")
public class RapportService {
	
	private RapportDAO Rapp= new RapportDAO();

	
	@Path("/get/")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Rapport> getRapport() {
		return Rapp.listerRapports();
		
	}
	@GET
	@Path("/get/T1/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Rapport getRapportXml(@PathParam("id") String id) {
		return Rapp.fetchRapp(id);
		}
	
	
	@GET
	@Path("/get/T2/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Rapport getRapportJson(@PathParam("id") String id) {
		return Rapp.fetchRapp(id);
		}

	@Path("/add/")
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Rapport setRapportJSON(Rapport r,@Context UriInfo uriInfo) throws URISyntaxException{
		Rapp.ajouterRapport(r);
		return r;
	}
	

	@Path("/delete/{id}")
	@DELETE
	public Response deleteRapportId(@PathParam("id") String id) {
		int Id = Integer.parseInt(id);
		Rapp.SupprimerRapport(Id);
		return Response.ok().build();
	}
	

	
	

}
