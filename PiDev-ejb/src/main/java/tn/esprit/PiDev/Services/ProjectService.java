package tn.esprit.PiDev.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.PiDev.Remotes.ProjectRemote;
import tn.esprit.PiDev.entities.Employe;
import tn.esprit.PiDev.entities.Project;


@Stateless
@LocalBean

public class ProjectService implements ProjectRemote{
	
	@PersistenceContext(unitName = "PiDev-ejb")
	EntityManager em;

	
	@Override
	public Project findbyId(int i) {
		// TODO Auto-generated method stub
		return em.find(Project.class, i);
	}


	@Override
	public void deleteProjet(int idProject) {
		em.remove(em.find(Project.class, idProject));
		
	}

	@Override
	public void addProject(Project p) {
          em.persist(p);
		
	}

	@Override
	public void updateProject(Project p) {	
		
		em.merge(p);
	
		
	}


	@Override
	public List<Project> getListProjects() {
		TypedQuery<Project> query = em.createQuery("Select e from Project e", Project.class);
		List<Project> result = query.getResultList();
		return result;
	}

	

}
