package tn.esprit.ressources;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import tn.esprit.PiDev.Services.TicketServicesR;
import tn.esprit.PiDev.Services.UserServices;
import tn.esprit.PiDev.entities.Status;
import tn.esprit.PiDev.entities.Ticket;

@Path("tickets")
@RequestScoped
public class TicketUserService {
	@EJB
	TicketServicesR Us;
	
	public static ArrayList<Ticket> list=new ArrayList<Ticket>();

	
	
	@GET
	@Produces("application/json")
	public Response get() {
		
		List<Ticket> test = Us.getAllTickets();
		return Response.status(Response.Status.OK).entity(test).build();			
		
	}
	
	@GET
	@Path("{status}")
	@Produces("application/json")
	public Response getTest(@PathParam("status") Status status) {
		
		List<Ticket> test = Us.getTicketsByStatus(status);
		return Response.status(Response.Status.OK).entity(test).build();			
		
	}
	
	@GET
	@Path("{assign}")
	@Produces("application/json")
	public Response getTestAss(@PathParam("assign") Boolean assign) {
		
		List<Ticket> test = Us.getTicketByAssignement(assign);
		return Response.status(Response.Status.OK).entity(test).build();			
		
	}
	

		
	

	
	
	
	
	
	

}
