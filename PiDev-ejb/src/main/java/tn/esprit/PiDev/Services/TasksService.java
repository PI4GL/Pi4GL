package tn.esprit.PiDev.Services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.PiDev.Remotes.TasksRemote;
import tn.esprit.PiDev.entities.Project;
import tn.esprit.PiDev.entities.Task;

@Stateless
@LocalBean
public class TasksService implements TasksRemote{
	@PersistenceContext(unitName = "PiDev-ejb")
	EntityManager em;
	@Override
	public void addTask(Task t) {
		// TODO Auto-generated method stub
		em.persist(t);
		
	}

	@Override
	public void updateTask(Task t) {
		// TODO Auto-generated method stub
		em.merge(t);
	}

	@Override
	public void deleteTask(int idT) {
		// TODO Auto-generated method stub
		em.remove(em.find(Task.class, idT));
		
		
	}
	
	


	
	
	

}
