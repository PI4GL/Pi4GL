package tn.esprit.PiDev.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.PiDev.entities.JobSheet;
import tn.esprit.interfaces.JobSheetRemote;

@Stateless
@LocalBean
public class JobSheetService implements JobSheetRemote{
	@PersistenceContext
	EntityManager em;

	@Override
	public void addJobSeet(JobSheet e) {
		em.persist(e);
		
	}

	@Override
	public void updateJobSheet(JobSheet e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<JobSheet> getListJobSheets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteJobSheet(JobSheet e) {
		// TODO Auto-generated method stub
		
	}
}
