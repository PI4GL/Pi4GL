package tn.esprit.PiDev.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.PiDev.entities.*;
import tn.esprit.PiDev.Remotes.*;

@Stateless
@LocalBean
public class QuizService implements QuizServiceRemote {

	@PersistenceContext
	EntityManager em;

	@Override
	public void ajouterQuiz(Quiz quiz) {
		em.persist(quiz);

	}

	@Override
	public void addSkillQuiz(Quiz quiz, Skill skill) {
		quiz.setSkill(skill);
		em.persist(quiz);

	}

	@Override
	public void addQuestions(Quiz quiz, QuizQuestion question) {
		quiz.getQuestions().add(question);
		em.persist(quiz);

	}

	@Override
	public List<QuizQuestion> listQuestions(Quiz quiz) {

		TypedQuery<QuizQuestion> query = em.createQuery("SELECT Q FROM " + QuizQuestion.class.getName() + " Q WHERE Q.quiz = :quiz",
				QuizQuestion.class).setParameter("quiz", quiz);
		try {
			return query.getResultList();
		}

		catch (Exception e) {
			System.out.print("error");
		}
		return null;
	}

	@Override
	public UserQuiz getOrCreateUserQuiz(long userId, long quizId) {
		List<UserQuiz> userQuizs = em
				.createQuery("SELECT UQ FROM " + UserQuiz.class.getName() + " UQ"
						+ " JOIN FETCH UQ.quiz Q JOIN FETCH Q.questions QS"
						+ " WHERE UQ.user.id = :userId AND UQ.quiz.id = :quizId", UserQuiz.class)
				.setParameter("userId", userId).setParameter("quizId", quizId).getResultList();

		UserQuiz userQuiz = null;

		// Does it exist?
		if (userQuizs == null || userQuizs.size() == 0) {
			// Then create one

			Employe user = em.find(Employe.class, userId);

			if (user == null) {
				System.out.println("Got a non-valid user id: " + userId + ".");
				return null;
			}

			Quiz quiz = em.find(Quiz.class, quizId);

			if (quiz == null) {
				System.out.println("Got a non-valid quiz id: " + quizId + ".");
				return null;
			}

			userQuiz = new UserQuiz(user, quiz, 1);
			
			em.persist(userQuiz);

		} else {
			userQuiz = userQuizs.get(0);
		}

		return userQuiz;
	}

	@Override
	public Quiz getQuizOfSkillWithLevel(long skillId, int quizLevel)
	{
		Quiz quiz;
		
		// Check if requested quiz level is not above max quiz level
		boolean notAbove = quizLevel <= Quiz.getMaxquizlevel();
		
		if(!notAbove)
			return null;
		
		List<Quiz> quizs = em.createQuery("SELECT Q FROM " +  Quiz.class.getName() + " Q"
				+ " WHERE Q.skill.id = :skillId AND Q.requiredMinLevel = :quizLevel", Quiz.class)
				.setParameter("skillId", skillId)
				.setParameter("quizLevel", quizLevel)
				.getResultList();
		
		// Is there any???
		if(quizs == null || quizs.size() == 0)
			return null;
		
		quiz = quizs.get(0);
		
		return quiz;
	}
	
	@Override
	public void updateUserQuiz(UserQuiz userQuiz)
	{
		em.persist(em.contains(userQuiz) ? userQuiz : em.merge(userQuiz));
	}

	@Override
	public Map<QuizQuestion, List<UserQuizResponse>> getUserQuizQuestionResponseMap(long userId, long quizId) {
Map<QuizQuestion, List<UserQuizResponse>> map = new HashMap<QuizQuestion, List<UserQuizResponse>>();
		
		// Get all questions relevant to this quiz
		List<QuizQuestion> quizQuestions = em.createQuery("SELECT QQ FROM " + QuizQuestion.class.getName() + " QQ"
				+ " WHERE QQ.quiz.id = :quizId", QuizQuestion.class)
				.setParameter("quizId", quizId)
				.getResultList();

		for(QuizQuestion quizQuestion : quizQuestions)
		{
			System.out.println("Fetching Responses for quiz question with id: " + quizQuestion.getId());
			
			String queryStr = "SELECT UQR FROM " + UserQuizResponse.class.getName() + " UQR"
					+ " WHERE UQR.response.question.id = :questionId";
			
			List<UserQuizResponse> responses = em.createQuery(queryStr, UserQuizResponse.class)
					.setParameter("questionId", quizQuestion.getId())
					.getResultList();
			
			map.put(quizQuestion, responses);
		}
		
	    return map;
	}
	
}
