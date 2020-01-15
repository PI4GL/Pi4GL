package tn.esprit.PiDev.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.PiDev.Remotes.FormationInterface;
import tn.esprit.PiDev.entities.Formation;

@Stateful
@LocalBean
public class FormationService implements FormationInterface {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void addFormation(Formation formation) {
		em.persist(formation);
	}

	@Override
	public void deleteFormation(int idFormation) {
		Formation f = em.find(Formation.class, idFormation);
		em.remove(f);
	}

	@Override
	public void updateFormation(Formation formation) {
		em.merge(formation);
	}

	@Override
	public List<Formation> getAllFormation() {
		return em.createQuery("from Formation",Formation.class).getResultList();
	}
	
	public List<Formation> getAllFormationN() {
		return em.createQuery("Select f from Formation f where f != All (Select t.formation from Test t where t.formation != null)",Formation.class).getResultList();
	}


	@Override
	public Formation getFormationById(int idFormation) {
		return em.find(Formation.class, idFormation);
	}

	@Override
	public Formation getFormationByTitle(String title) {
		TypedQuery<Formation> query=em.createQuery("select f from Formation f where f.title=:title"+title,Formation.class);
				
		Formation formation=null;
		
		try {
			
			formation=query.getSingleResult();
			
		} catch (Exception e) {
			System.out.println("Pas de formation");
		}
		
		return formation;
	}
	
	

}
