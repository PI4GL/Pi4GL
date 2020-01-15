package tn.esprit.PiDev.Services;

import javax.ejb.Remote;

import tn.esprit.PiDev.entities.Utilisateur;
import tn.esprit.PiDev.entities.QuestionResponse;
import tn.esprit.PiDev.entities.Quiz;
import tn.esprit.PiDev.entities.QuizQuestion;

@Remote
public interface ResponseServiceRemote {

	public void addResponse(QuestionResponse response);
	
	
}
