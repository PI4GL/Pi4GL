package tn.esprit.PiDev.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.PiDev.entities.Skill;
import tn.esprit.PiDev.entities.UserSkill;
import tn.esprit.PiDev.Remotes.*;
import tn.esprit.PiDev.entities.Category;
import tn.esprit.PiDev.entities.Employe;
import tn.esprit.PiDev.entities.Quiz;

@Stateless
@LocalBean
public class SkillService implements SkillServiceRemote  {

	@PersistenceContext
	EntityManager em;

	public Skill getSkillById(long skillId) {
		return em.find(Skill.class, skillId);

	}

	@Override
	public Skill addSkill(Skill skill) {
		em.persist(em.contains(skill) ? skill : em.merge(skill));
		return skill;

	}

	@Override
	public Skill updateSkill(Skill skill) {
		em.persist(em.contains(skill) ? skill : em.merge(skill));
		return skill;
	}

	@Override
	public void updateUserSkill(UserSkill userSkill) {
		em.persist(em.contains(userSkill) ? userSkill : em.merge(userSkill));
	}

	@Override
	public void deleteSkill(Skill skill) {
		em.remove(em.contains(skill) ? skill : em.merge(skill));

	}

	@Override
	public Skill addCategory(Skill skill, Category category) {
		skill.setCategory(category);
		em.persist(skill);
		return skill;
	}

	@Override
	public List<Employe> listUsers(Skill skill) {
		TypedQuery<Employe> query = em.createQuery("Select u from Employe where u.skill=:skill",
				Employe.class);
		try {
			return query.getResultList();
		}

		catch (Exception e) {
			System.out.print("error");
		}
		return null;
	}

	@Override
	public List<Quiz> listQuizzes(Skill skill) {
		TypedQuery<Quiz> query = em.createQuery("Select q from Quiz where q.skill=:skill", Quiz.class);
		try {
			return query.getResultList();
		}

		catch (Exception e) {
			System.out.print("error");
		}
		return null;
	}

	@Override
	public List<Skill> getSkillsByCategoryId(long categoryId) {
		List<Skill> skills = em
				.createQuery("SELECT S FROM " + Skill.class.getName() + " S" + " WHERE S.category.id = :categoryId",
						Skill.class)
				.setParameter("categoryId", categoryId).getResultList();

		return skills;
	}

	@Override
	public UserSkill getOrCreateUserSkill(long userId, long skillId) {
		List<UserSkill> userSkills = em
				.createQuery("SELECT US FROM " + UserSkill.class.getName() + " US"
						+ " WHERE US.user.id = :userId AND US.skill.id = :skillId", UserSkill.class)
				.setParameter("userId", userId).setParameter("skillId", skillId).getResultList();

		UserSkill userSkill = null;

		// Does it exist?
		if (userSkills == null || userSkills.size() == 0) {
			// Then create one

			Employe user = em.find(Employe.class, userId);

			if (user == null) {
				System.out.println("Got a non-valid user id: " + userId + ".");
				return null;
			}

			Skill skill = em.find(Skill.class, skillId);

			if (skill == null) {
				System.out.println("Got a non-valid skill id: " + skillId + ".");
				return null;
			}

			// 0 for actual relation level, to start with quiz 1, and so...
			userSkill = new UserSkill(user, skill, 0);
			em.persist(userSkill);

		} else {
			userSkill = userSkills.get(0);
		}

		return userSkill;

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
