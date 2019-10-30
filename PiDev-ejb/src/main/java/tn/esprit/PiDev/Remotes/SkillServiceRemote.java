package tn.esprit.PiDev.Remotes;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PiDev.entities.Skill;
import tn.esprit.PiDev.entities.Employe;
import tn.esprit.PiDev.entities.Category;
import tn.esprit.PiDev.entities.Quiz;
import tn.esprit.PiDev.entities.UserSkill;

@Remote
public interface SkillServiceRemote {

	public Skill addSkill(Skill skill);
	public Skill updateSkill(Skill skill);
	public void deleteSkill(Skill skill);
	public Skill addCategory(Skill skill , Category category);
	public List<Employe> listUsers(Skill skill);
	public List<Quiz> listQuizzes(Skill skill);
	public List<Skill> getSkillsByCategoryId(long categoryId);
	public UserSkill getOrCreateUserSkill(long userId, long skillId);
	public void updateUserSkill(UserSkill userSkill);
}
