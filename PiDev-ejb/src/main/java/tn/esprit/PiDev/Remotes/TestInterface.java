package tn.esprit.PiDev.Remotes;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PiDev.entities.Question;
import tn.esprit.PiDev.entities.Reponse;
import tn.esprit.PiDev.entities.Test;

@Remote
public interface TestInterface {

	void addQuestion(Question question);
	void deleteQuestion(int idQ);
	void updateQuestion(Question question);
	List<Question> AllQuestion();
	Question getQuestionById(int idQuestion);
	void removeQuestion(Question question);
	
	Test get_Test(int idTest);
	List<Test> AllTest();
	void addTest(Test test);
	void deleteTest(int idT);
	void updateTest(Test test);
	void removeTest(Test t);
	
	void addReponse(Reponse reponse);
	void deleteReponse(int idR);
	void updateReponse(Reponse reponse);
	List<Reponse> AllReponse();
	Reponse getReponseById(int idReponse);
	void removeReponse(Reponse reponse);
	
	List<Question> getAllQ(int id);
	List<Reponse> getAllR(int id);
}
