package tn.esprit.PiDev.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.PiDev.Remotes.DevTeamRemote;
import tn.esprit.PiDev.entities.Client;
import tn.esprit.PiDev.entities.DevTeam;
import tn.esprit.PiDev.entities.Employe;

@Stateless
@LocalBean
public class DevTeamService implements DevTeamRemote {
	@PersistenceContext(unitName = "PiDev-ejb")
	EntityManager em;
	
	
	@Override
	public void addDevTeam(DevTeam DT) {
		// TODO Auto-generated method stub
		em.persist(DT);
	}

	@Override
	public void deleteDevTeam(DevTeam DT) {
		// TODO Auto-generated method stub
		DT = em.merge(DT);//<-Important
		em.remove(DT);
	}

	@Override
	public void updateDevTeam(DevTeam DT) {
		// TODO Auto-generated method stub
		em.merge(DT);
		
		
	}

	@Override
	public List<DevTeam> getDevTeamList() {
		// TODO Auto-generated method stub
		
		TypedQuery<DevTeam> query = em.createQuery("Select e from DevTeam e", DevTeam.class);
		List<DevTeam> result = query.getResultList();
		return result;
	
		
	}

	@Override
	public List<Employe> getEmployeDevTeamByTeaM(int idDevT) {

		TypedQuery<Employe> query = em.createQuery("Select e from Employer e where e.devTeam_idTeamIndex=idDevT", Employe.class).setParameter("idDevT", idDevT);
		List<Employe> result = query.getResultList();
		return result;
	}

	@Override
	public void addEmployeToDevTeam(Employe emp) {
		// TODO Auto-generated method stub
		
		
	}

}
