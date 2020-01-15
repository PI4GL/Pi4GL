package tn.esprit.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import tn.esprit.PiDev.entities.User;


import tn.esprit.PiDev.Services.UserServices;

import java.util.ArrayList;
import java.util.List;

@Path("users")
@RequestScoped
public class UserRestService {
	@EJB
	UserServices Us;
	
	
	public static ArrayList<User> employes = new ArrayList<User>();

	@GET
	@Produces("application/json")
	public Response get() {
		
		List<User> test = Us.getAllEmploye();
		return Response.status(Response.Status.OK).entity(test).build();			
		
	}
	
	





}
