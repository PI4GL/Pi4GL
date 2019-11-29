package tn.esprit.PiDev.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.PiDev.Remotes.TestInterface;
import tn.esprit.PiDev.entities.Formation;
import tn.esprit.PiDev.entities.Former;
import tn.esprit.PiDev.entities.Question;
import tn.esprit.PiDev.entities.Reponse;
import tn.esprit.PiDev.entities.Test;

@Stateful
@LocalBean
public class TestService implements TestInterface{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void addQuestion(Question question) {
		em.persist(question);
		
	}

	@Override
	public void deleteQuestion(int idQ) {
		Question q = em.find(Question.class, idQ);
		em.remove(q);
	}

	@Override
	public void updateQuestion(Question question) {
		em.merge(question);
	}

	@Override
	public List<Question> AllQuestion() {
		return em.createQuery("from Question",Question.class).getResultList();
	}

	@Override
	public Question getQuestionById(int idQuestion) {
		return em.find(Question.class, idQuestion);
	}


	
	
	@Override
	public void addReponse(Reponse reponse) {
		em.persist(reponse);
	}

	@Override
	public void deleteReponse(int idR) {
		Reponse r = em.find(Reponse.class, idR);
		em.remove(r);
	}

	@Override
	public void updateReponse(Reponse reponse) {
		em.merge(reponse);
	}

	@Override
	public List<Reponse> AllReponse() {
		return em.createQuery("from Reponse",Reponse.class).getResultList();
	}

	@Override
	public Reponse getReponseById(int idReponse) {
		return em.find(Reponse.class, idReponse);
	}
	
	
	
	
	
	@Override
	public Test get_Test(int idTest) {
		return em.find(Test.class, idTest);
	}


	@Override
	public List<Test> AllTest() {
		return em.createQuery("from Test",Test.class).getResultList();
	}

	@Override
	public void addTest(Test test) {
		em.persist(test);
	}

	@Override
	public void deleteTest(int idT) {
		Test t = em.find(Test.class, idT);
		em.remove(t);
	}

	@Override
	public void updateTest(Test test) {
		em.merge(test);
	}

	@Override
	public void removeTest(Test t) {
		
		Test test = em.find(Test.class, t.getIdTest());
		em.remove(test);
	}

	@Override
	public void removeQuestion(Question question) {
		
		Question quest = em.find(Question.class, question.getIdQues());
		em.remove(quest);
	}

	@Override
	public void removeReponse(Reponse reponse) {
		
		Reponse rsp = em.find(Reponse.class, reponse.getIdRep());
		em.remove(rsp);
	}
	
	

}
