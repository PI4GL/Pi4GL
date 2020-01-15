package ressources;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.PiDev.entities.*;
import tn.esprit.PiDev.Remotes.*;
import tn.esprit.PiDev.Services.*;

@Path("resources")
@RequestScoped
public class RessourceResource {
	
	@EJB(beanName = "RessourceService")
	private RessourceServiceLocal rs;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addRessource(Ressource r) {
		if (r != null) {
			rs.persistRessource(r);
			return Response.status(Status.CREATED).entity("OK: " + r.getFirstName() + " ajouté").build();
		} else {
			return Response.status(Status.NOT_ACCEPTABLE).entity("ERREUR D AJOUT").build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateRessource(Ressource r) {
		rs.mergeRessource(r);
		return Response.status(Status.OK).entity("Resource modified").build();
	}

	@GET
	@Path("remove")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response deleteRessource(@QueryParam(value = "id") String id) {
		if (rs.removeResourceById(id) > 0) {
			return Response.status(Status.OK).entity("Removed").build();
		} else {
			return Response.status(Status.NOT_FOUND).entity("Resource not found").build();
		}
	}

	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/skills/{id}")
	public Response listResourceSkills(@PathParam(value="id")String id)
	{
		return Response.status(Status.OK).entity(rs.getResourceSkills(id)).build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/resume/{id}")
	public Response getResourceResume(@PathParam(value="id")String id)
	{
		return Response.status(Status.OK).entity(rs.getResourceResume(id)).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/rank")
	public Response rankResources(@QueryParam(value="category")String category)
	{
		return Response.status(Status.OK).entity(rs.rankResourcesBySkillNumber()).build();
	}
	
	
	
}
