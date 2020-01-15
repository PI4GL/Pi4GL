package tn.esprit.PiDev.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.PiDev.Remotes.SkillServiceLocal;
import tn.esprit.PiDev.entities.Skill;;

@Stateless
@LocalBean
public class SkillService implements SkillServiceLocal {
	@PersistenceContext
	EntityManager em;

	@Override
	public void persistSkill(Skill skill) {
		em.persist(skill);
	}
	@Override
	public Skill findSkill(int id) {
		return em.find(Skill.class, id);
	}
	@Override
	public void removeSkill(Skill skill) {
		em.remove(em.contains(skill) ? skill : em.merge(skill));
	}
	@Override
	public Skill mergeSkill(Skill skill) {
		return em.merge(skill);
	}
	@Override
	public boolean contains(Skill skill) {
		return em.contains(skill);
	}
	@Override
	public int removeSkillById(String id) {
		int idS = Integer.parseInt(id);
		Query query = em.createQuery("DELETE FROM Skill s WHERE s.skillId = :id");
		return query.setParameter("id", idS).executeUpdate();
	}
	@Override
	public long getCountByCategory(String category) {
		TypedQuery<Long> query = em.createQuery("SELECT count(s) FROM Skill s WHERE s.category LIKE CONCAT('%',:category,'%')",Long.class);
		return query.setParameter("category", category).getSingleResult();
	}/*
	@Override
	public long getCountByName(int id) {
		Skill s = new Skill();
		try {
			s = em.find(Skill.class, id);
		}catch (Exception e) {
		}
		TypedQuery<Long> query = em.createQuery("SELECT count(r) FROM Resume r where :name MEMBER OF r.skills)",Long.class);
		return query.setParameter("name", s).getSingleResult();
	}*/
	@Override
	public List<Skill> searchByName(String name) {
		TypedQuery<Skill> query = em.createQuery("SELECT s FROM Skill s where s.name LIKE CONCAT('%',:name,'%')",Skill.class);
		return query.setParameter("name", name).getResultList();
	}
	@Override
	public List<Skill> searchByCategory(String category) {
		TypedQuery<Skill> query = em.createQuery("SELECT s FROM Skill s where s.category LIKE CONCAT('%',:category,'%')",Skill.class);
		return query.setParameter("category",category).getResultList();
	}
	@Override
	public List<Skill> listAll() {
		TypedQuery<Skill> query = em.createQuery("SELECT s FROM Skill s",Skill.class);
		return query.getResultList();
	}

	@Override
	public List<String> getCategories() {
		TypedQuery<String> query = em.createQuery("SELECT DISTINCT(s.category) from Skill s",String.class);
		return query.getResultList();
	}
	@Override
	public long getCountByName(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Skill getSkillByName(String skillName) {
		Query query = em.createQuery("SELECT S FROM " + Skill.class.getName() + " S WHERE S.name=:name");
		query.setParameter("name", skillName);
		List<Skill> skills = query.getResultList();
		if (skills == null || skills.size() == 0)
			return null;
		return skills.get(0);
	}
}
