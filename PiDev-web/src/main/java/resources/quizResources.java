package resources;

import java.util.List;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import tn.esprit.PiDev.entities.*;
import tn.esprit.PiDev.Services.*;


@Path("gestionQuiz")
@RequestScoped
public class quizResources {

	@EJB
	CategoryService categoryService;
	@EJB
	SkillService skillService;
	@EJB
	QuizService quizService;
	@EJB
	QuestionService questionService;

	@GET
	@Path("category")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCategories() {
		return Response.status(Response.Status.OK).entity(this.categoryService.ListAllCategories()).build();
	}

	@GET
	@Path("skill/{categoryId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSkillsByCategoryId(@PathParam(value = "categoryId") long categoryId) {
		return Response.status(Response.Status.OK).entity(this.skillService.getSkillsByCategoryId(categoryId)).build();
	}
	
	@GET
	@Path("quiz/{skillId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuizBySkillId(@PathParam(value = "skillId") long skillId) {
		
		return Response.status(Response.Status.OK).entity(this.skillService.getQuizBySkillId(skillId)).build();
		
	}
	@GET
	@Path("question/{quizId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionsByQuizId(@PathParam(value = "quizId") long quizId) {
		
		return Response.status(Response.Status.OK).entity(this.quizService.listQuestionsByQuizId(quizId)).build();
		
	}
	
	@GET
	@Path("quiz/{quizId}/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrCreateUserQuiz( @PathParam(value="userId") long userId, @PathParam(value = "quizId") long quizId) {
		
		return Response.status(Response.Status.OK).entity(this.quizService.getOrCreateUserQuiz(userId, quizId)).build();
		
	}
	
	@GET
	@Path("responses/{questionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getResponsesByQuestionId( @PathParam(value="questionId") int questionId) {
		
		return Response.status(Response.Status.OK).entity(this.questionService.listResponsesByQuestionId(questionId)).build();
		
	}
	
	@GET
	@Path("userSkill/{skillId}/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrCreateUserSkill( @PathParam(value="userId") long userId, @PathParam(value = "skillId") long skillId) {
		
		return Response.status(Response.Status.OK).entity(this.skillService.getOrCreateUserSkill(skillId, userId)).build();
		
	}
	
	@GET
	@Path("quizBySkillAndLevel/{skillId}/{level}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuizOfSkillWithLevel( @PathParam(value="level") int level, @PathParam(value = "skillId") long skillId)
	{
		return Response.status(Response.Status.OK).entity(this.quizService.getQuizOfSkillWithLevel(skillId, level)).build();
	}

	@GET
	@Path("updateResponse/{userId}/{responseId}/{check}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUserQuestionResponseCheck(@PathParam(value="userId") long userId, @PathParam(value="responseId") long responseId, @PathParam(value = "check") boolean check)
	{
		UserQuizResponse response = this.questionService.getOrCreateUserQuestionResponse(userId, responseId);
		
		if(response == null)
			return Response.status(Response.Status.NOT_FOUND).entity("Not found... check response id.").build();
		
		response.setIsChecked(check);
		
		this.questionService.updateUserQuizResponse(response);
		
		return Response.status(Response.Status.OK).entity("Update done...").build();
	}
	
	@GET
	@Path("updateQuestionIndex/{uqId}/{index}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUserQuizQuestionIndex(@PathParam(value="index") int newIndex, @PathParam(value="uqId") long uqId)
	{
		quizService.updateUserQuizQuestionIndex(uqId, newIndex);
		return Response.status(Response.Status.OK).entity("Update done...").build();
	}
	
	
	@GET
	@Path("getUserQuestionResponses/{userId}/{questionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserResponsesByQuizAndQuestionId(
			@PathParam(value="userId") long userId,
			@PathParam(value="questionId") int questionId)
	{
		
		QuizQuestion quizQuestion = questionService.getQuestionById(questionId);
		
		if(quizQuestion == null)
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		
		List<UserQuizResponse> uqrs = new ArrayList<>();
		
		for(QuestionResponse qr : quizQuestion.getResponses())
		{
			uqrs.add(questionService.getOrCreateUserQuestionResponse(userId, qr.getId()));
		}

		return Response.status(Response.Status.OK).entity(uqrs).build();
	}
	
	@GET
	@Path("updateScore/{quizId}/{userId}/{score}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setUserQuizScore(@PathParam(value="score") int score, @PathParam(value="userId") long userId, @PathParam(value = "quizId") long quizId)
	{
		UserQuiz userQuiz = this.quizService.getOrCreateUserQuiz(userId, quizId);
		
		userQuiz.setScore(score);
		
		this.quizService.updateUserQuiz(userQuiz);
		
		return Response.status(Response.Status.OK).entity("Done...").build();
	}
	
	@GET
	@Path("levelUpUserSkill/{userId}/{skillId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response levelUpUserSkill(@PathParam(value="userId") long userId, @PathParam(value="skillId") long skillId)
	{
		
        UserSkill userSkill = skillService.getOrCreateUserSkill(userId, skillId);
        userSkill.setLevel(userSkill.getLevel() + 1);
        skillService.updateUserSkill(userSkill);
		
		
		return Response.status(Response.Status.OK).entity("Done...").build();
	}
	
	
}
