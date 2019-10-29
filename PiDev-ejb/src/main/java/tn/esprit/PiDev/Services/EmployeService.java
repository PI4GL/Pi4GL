package tn.esprit.PiDev.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.PiDev.Remotes.EmployeServiceRemote;
import tn.esprit.PiDev.entities.DevTeam;
import tn.esprit.PiDev.entities.Employe;


@Stateless
@LocalBean
public class EmployeService implements EmployeServiceRemote{
	@PersistenceContext(unitName = "PiDev-ejb")
	EntityManager em;
	

	@Override
	public void deleteEmployeById(int idEmp) {
		// TODO Auto-generated method stub
		Employe employe = em.find(Employe.class, idEmp);

		em.remove(employe);
		
	}

	@Override
	public void ajouterEmploye(Employe e) {
		// TODO Auto-generated method stub
		em.persist(e);
		
	}

	@Override
	public void updateEmploye(Employe e) {
		// TODO Auto-generated method stub
		em.merge(e);
		
	}

	@Override
	public void supprimerEmploye(int idEnt) {
		em.remove(em.find(Employe.class, idEnt));
	}

	@Override
	public Employe getEmployeById(int idEnt) {
		return em.find(Employe.class, idEnt);
	}

	@Override
	public List<Employe> getListEmployes() {
		TypedQuery<Employe> query = em.createQuery("Select e from Employe e", Employe.class);
		List<Employe> result = query.getResultList();
		return result;
	}

	@Override
	public Employe getEmployeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employe getEmployeByLoginAndPwd(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employe getEmployeByEmailAndPassword(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	


}