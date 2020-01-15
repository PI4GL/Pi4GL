package tn.esprit.ressources;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.PiDev.Services.TicketServicesR;

import tn.esprit.PiDev.entities.Ticket;
import javax.ws.rs.core.Response.Status;

@Path("tic")
@RequestScoped
public class TicketDeleteService {
	@EJB
	TicketServicesR Us;
	
	
	
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteEmploye(@PathParam("id") int id) {
		 
		Us.deleteTicketByID(id);
			return Response.status(Status.OK).entity("ticket Deleted").build();
			

	}
	
	// ajout book
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response addT(Ticket b) {
		Us.addTicket(b);
		return Response.status(Status.CREATED).entity("l element vous a été ajouté avec succes").build();
	
	
	
	
	

}
}