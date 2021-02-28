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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.pwa.webservice.dao.AutomateDAO;
import fr.pwa.webservice.model.Automate;

@Path("/automate/")
public class AutomatesServices {
	private final AutomateDAO Auto= new AutomateDAO();

	
	@Path("/get/")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Automate> getAutomate() {
		return Auto.listerAutomates();
		
	}
	
	@Path("/get/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Automate getAutomateId(@PathParam("id")String id) {
		return Auto.fetchAuto(id);
		
	}


	
	//Post pour les automates
	@Path("/add/")
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Automate setAutomateJSON(Automate r) throws URISyntaxException{
		Auto.AjouterAutomate(r);
		
		return r;
	}

	
	@Path("/delete/{id}")
	@DELETE
	public Response delAuto(@PathParam("id")String id) {
		Auto.supprimerAutomate(id);
		 return Response.ok().build();	 
	}
	
	

}
