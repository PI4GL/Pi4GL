package tn.esprit.PiDev.resources;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.PiDev.Services.FormationService;
import tn.esprit.PiDev.Services.TestService;
import tn.esprit.PiDev.entities.Formation;
import tn.esprit.PiDev.entities.Question;
import tn.esprit.PiDev.entities.Reponse;
import tn.esprit.PiDev.entities.Test;


@Path("test")
public class GestionTest {
	
	@EJB
	TestService testService;
	
	@EJB
	FormationService formationService;
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	public Response getTest(@PathParam("id") int id) {
		
		Test test = testService.get_Test(id);
		return Response.status(Response.Status.OK).entity(test).build();			
		
	}
	/*
	@GET
	@Path("formation/{id}")
	@Produces("application/json")
	public Response getFormation(@PathParam("id") int id, Formation formation) {
		
		Formation formation = formationService
		return Response.status(Response.Status.OK).entity(test).build();			
		
	}*/
	
	@GET
	@Path("Quest/{id}")
	@Produces("application/json")
	public Response getQuest(@PathParam("id") int id) {
				
		return Response.status(Response.Status.OK).entity(testService.getQuestionById(id)).build();
					
	}
	
	@GET
	@Path("Quest/Rep/{id}")
	@Produces("application/json")
	public Response getRep(@PathParam("id") int id) {
				
		return Response.status(Response.Status.OK).entity(testService.getReponseById(id)).build();
					
	}
	
	@GET
	@Produces("application/json")
	public Response get() {
		
		List<Test> test = testService.AllTest();
		return Response.status(Response.Status.OK).entity(test).build();			
		
	}

	@GET
	@Path("allQ")
	@Produces("application/json")
	public Response getQ() {
		
		List<Question> question =testService.AllQuestion();
		return Response.status(Response.Status.OK).entity(question).build();			
		
	}
	
	@GET
	@Path("allR")
	@Produces("application/json")
	public Response getR() {
		
		List<Reponse> reponse =testService.AllReponse();
		return Response.status(Response.Status.OK).entity(reponse).build();			
		
	}

	
	@POST
	@Path("addtest/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Test t, @PathParam("id") int id)
	{
		Formation f = formationService.getFormationById(id);
		t.setFormation(f);
		
		testService.addTest(t);
		return Response.status(Response.Status.OK).build();
	}
	
	@POST
	@Path("addQ/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addQ(@PathParam("id") int id,Question q)
	{	
		Test t = testService.get_Test(id);
		q.setTestt(t);
		testService.addQuestion(q);
		return Response.status(Response.Status.OK).build();
		
	}
	
	@POST
	@Path("addR/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addR(@PathParam("id") int id,Reponse r)
	{	
		Question q = testService.getQuestionById(id);
		r.setQuest(q);
		testService.addReponse(r);
		return Response.status(Response.Status.OK).build();		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateT(Test t)
	{
		testService.updateTest(t);
		return Response.status(Response.Status.OK).build();
	}
	
	@PUT
	@Path("QuestionUp")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateQ(Question q)
	{
		testService.updateQuestion(q);
		return Response.status(Response.Status.OK).build();
	}
	
	@PUT
	@Path("ReponseUp")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateR(Reponse r)
	{
		testService.updateReponse(r);;
		return Response.status(Response.Status.OK).build();
	}
	
	@PUT
	@Path("formationUp/{idtest}/{idformation}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addtestToFormation(@PathParam("idtest") int idtest,@PathParam("idformation") int idformation)
	{
		Formation f = formationService.getFormationById(idformation);
		Test t = testService.get_Test(idtest);
		t.setFormation(f);
		testService.updateTest(t);
		return Response.status(Response.Status.OK).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteTest(Test t)
	{
		testService.removeTest(t);
		return Response.status(Response.Status.OK).build();
	}
	
	@DELETE
	@Path("QuestionD")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteQ(Question q)
	{

		testService.removeQuestion(q);
		return Response.status(Response.Status.OK).build();
	}
	
	@DELETE
	@Path("ReponseD")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteR(Reponse r)
	{

		testService.removeReponse(r);
		return Response.status(Response.Status.OK).build();
	}
	
	@DELETE
	@Path("del/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteReponse(@PathParam("id") int id) {
		 
		testService.deleteReponse(id);
			return Response.status(Status.OK).entity("Projet Deleted").build();
			

	}

}
