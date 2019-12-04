package tn.esprit.PiDev.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.PiDev.Remotes.RessourceServiceLocal;
import tn.esprit.PiDev.entities.*;
@Stateless
public class RessourceService implements RessourceServiceLocal {
	@PersistenceContext
	EntityManager em;

	@Override
	public void persistRessource(Ressource res) {
		em.persist(res);
	}

	@Override
	public Ressource findRessource(int id) {
		return em.find(Ressource.class, id);
	}

	@Override
	public void removeRessource(Ressource res) {
		em.remove(res);
	}

	@Override
	public Ressource mergeRessource(Ressource res) {
		return em.merge(res);
	}

	@Override
	public boolean contains(Ressource res) {
		return em.contains(res);
	}
	@Override
	public int removeResourceById(String id) {
		int idS = Integer.parseInt(id);
		Query query = em.createQuery("UPDATE Ressource r SET r.isActive = 0");
		return query.setParameter("id", idS).executeUpdate();
	}
	@Override
	public List<Ressource> listAll()
	{
		TypedQuery<Ressource> query = em.createQuery("SELECT r FROM Ressource r",Ressource.class);
		return query.getResultList();
	}

	

	@Override
	public Resume getResourceResume(String id) {
		int idR = Integer.parseInt(id);
		TypedQuery<Resume> query = em.createQuery("SELECT r FROM Resume r WHERE r.owner.cin = :id",Resume.class);
		return query.setParameter("id", idR).getSingleResult();
	}

	@Override
	public List<Competence> getResourceSkills(String id) {
		int idR = Integer.parseInt(id);
		TypedQuery<Competence> query = em.createQuery("SELECT s "
				+ "FROM Resume r JOIN r.Skills s "
				+ "WHERE r.owner.cin = :id"
				,Competence.class);
		return query.setParameter("id", idR).getResultList();
	}
	@Override
	public Map<String, Long> rankResourcesBySkillNumber()
	{
		
		TypedQuery<Object[]> q = em.createQuery(
			    "SELECT r.cin, count(r.Skills) " +
			    "FROM Ressource r JOIN r.resume cv " +
			    "ORDER BY r.cin", Object[].class);

			List<Object[]> resultList = q.getResultList();
			Map<String, Long> resultMap = new HashMap<String, Long>(resultList.size());
			for (Object[] result : resultList)
			  resultMap.put((String)result[0], (Long)result[1]);
			return resultMap;
			/*
			 * TypedQuery<Object[]> q = em.createQuery(
			    "SELECT res.name,size(res.resume.skills)" +
			    " FROM Ressource res"+
			    " ORDER BY size(res.resume.skills)", Object[].class);

			return q.getResultList();
			*/
	}




}
