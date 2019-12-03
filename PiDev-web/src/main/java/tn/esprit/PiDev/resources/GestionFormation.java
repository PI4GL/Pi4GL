package tn.esprit.PiDev.resources;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import tn.esprit.PiDev.Services.FormationService;

@Path("formation")
public class GestionFormation {
	
	@EJB
	FormationService formationService;
	
	@GET
	@Produces("application/json")
	public Response getFormation()
	{
		return Response.status(Response.Status.OK).entity(formationService.getAllFormationN()).build();
	}
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	public Response getFormationID(@PathParam("id") int id)
	{
		return Response.status(Response.Status.OK).entity(formationService.getFormationById(id)).build();
	}

}
