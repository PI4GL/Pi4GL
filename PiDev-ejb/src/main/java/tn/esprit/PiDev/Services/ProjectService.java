package tn.esprit.PiDev.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.swing.plaf.metal.MetalBorders.Flush3DBorder;

import tn.esprit.PiDev.Remotes.ProjectRemote;
import tn.esprit.PiDev.entities.DevTeam;
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
		em.createQuery("delete From Project e where e.idProject=:id").setParameter("id", idProject).executeUpdate();
		em.flush();
	}

	@Override
	public void addProject(Project p) {
          em.persist(p);
          em.flush();
          
		
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


	@Override
	public List<DevTeam> getdevTeam() {
		
		TypedQuery<DevTeam> query = em.createQuery("Select d From Employe e , DevTeam d Where e.=", DevTeam.class);
		List<DevTeam> result = query.getResultList();
		return result;
	}

	

}
