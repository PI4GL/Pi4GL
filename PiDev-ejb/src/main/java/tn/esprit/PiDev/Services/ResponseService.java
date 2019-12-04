package tn.esprit.PiDev.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.PiDev.entities.Utilisateur;
import tn.esprit.PiDev.entities.QuestionResponse;
import tn.esprit.PiDev.entities.Quiz;
import tn.esprit.PiDev.entities.QuizQuestion;
import tn.esprit.PiDev.Remotes.ResponseServiceRemote;

@Stateless
@LocalBean
public class ResponseService  implements ResponseServiceRemote{
	@PersistenceContext
    EntityManager em;

	@Override
	public void addResponse(QuestionResponse response) {
			em.persist(response);
	}


}
