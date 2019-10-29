package tn.esprit.PiDev.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.PiDev.entities.CompetenceMatrix;
import tn.esprit.interfaces.CompetenceMatrixRemote;

@Stateless
@LocalBean
public class CompetenceMatrixService implements CompetenceMatrixRemote{
	@PersistenceContext
	EntityManager em;

	@Override
	public void addCompetenceMatrix(CompetenceMatrix e) {
		em.persist(e);
		
	}

	@Override
	public void updateCompetenceMatrix(CompetenceMatrix e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CompetenceMatrix> getListCompetenceMatrixs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCompetenceMatrix(CompetenceMatrix e) {
		// TODO Auto-generated method stub
		
	}
}
