package tn.esprit.PiDev.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PiDev.entities.Utilisateur;

import tn.esprit.PiDev.entities.Category;
import tn.esprit.PiDev.entities.Quiz;
import tn.esprit.PiDev.entities.Skill;
import tn.esprit.PiDev.entities.UserSkill;

@Remote
public interface SkillServiceRemote {

	public Skill addSkill(Skill skill);
	public Skill updateSkill(Skill skill);
	public void deleteSkill(Skill skill);
	public Skill addCategory(Skill skill , Category category);
	public List<Utilisateur> listUsers(Skill skill);
	public List<Quiz> listQuizzes(Skill skill);
	public List<Skill> getSkillsByCategoryId(long categoryId);
	public UserSkill getOrCreateUserSkill(long userId, long skillId);
	public void updateUserSkill(UserSkill userSkill);
	public Skill getSkillByName(String skillName);
	public Skill getSkillById(long skillId);
	public List<Quiz> getQuizBySkillId(long skillId);

}
