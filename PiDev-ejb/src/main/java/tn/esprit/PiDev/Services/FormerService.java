package tn.esprit.PiDev.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.PiDev.Remotes.FormerInterface;
import tn.esprit.PiDev.entities.Former;


@Stateful
@LocalBean
public class FormerService implements FormerInterface{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void addFormer(Former former) {
		em.persist(former);
	}
	
	@Override
	public void deleteFormer(int idFormer) {
		Former fr = em.find(Former.class, idFormer);
		em.remove(fr);
	}

	@Override
	public void updateFormer(Former former) {
		em.merge(former);
	}
	
	@Override
	public void updateFormer2(Former former) { 
		Former fff= em.find(Former.class, former.getIdFormer());
		fff.setNameFormer(former.getNameFormer());
		fff.setLastNameFormer(former.getLastNameFormer());
		fff.setSpecialty(former.getSpecialty());
	}

	@Override
	public List<Former> getAllFormer() {
		return em.createQuery("from Former",Former.class).getResultList();
	}

	@Override
	public Former getFormerById(int idFormer) {
		return em.find(Former.class, idFormer);
	}

	@Override
	public Former getFormerByName(String nameFormer) {
		TypedQuery<Former> query=em.createQuery("select fr from Former fr where fr.name=:name"+nameFormer,Former.class);
		
		Former former=null;
		
		try {
			
			former=query.getSingleResult();
			
		} catch (Exception e) {
			System.out.println("Pas de former");
		}
		
		return former;
	}

	@Override
	public Former getFormerBySpeciality(String specialty) {
		TypedQuery<Former> query=em.createQuery("select fr from Former fr where fr.specialty=:specialty"+specialty,Former.class);
		
		Former former=null;
		
		try {
			
			former=query.getSingleResult();
			
		} catch (Exception e) {
			System.out.println("Pas de former dans ce specialty");
		}
		
		return former;
	}

}
