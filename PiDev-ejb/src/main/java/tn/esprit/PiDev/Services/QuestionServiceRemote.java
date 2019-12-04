package tn.esprit.PiDev.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PiDev.entities.QuestionResponse;
import tn.esprit.PiDev.entities.QuizQuestion;
import tn.esprit.PiDev.entities.UserQuizResponse;
import tn.esprit.PiDev.entities.UserQuizResponse;
@Remote
public interface QuestionServiceRemote {

	public void addQuestion(QuizQuestion question);
	public void addResopnse(QuizQuestion question,QuestionResponse response);
	public List<QuestionResponse> listResponses(QuizQuestion question);
	public List<QuestionResponse> listResponsesByQuestionId(int questionId);
	public QuizQuestion getQuestionById(int questionId);
	public UserQuizResponse getOrCreateUserQuestionResponse(long userId, long responseId);
	public void updateUserQuizResponse(UserQuizResponse userQuizResponse);
}
