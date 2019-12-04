package tn.esprit.PiDev.Remotes;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.PiDev.entities.Competence;
@Local
public interface SkillServiceLocal {
	public void persistSkill(Competence competence);
	public Competence findSkill(int id);
	public void removeSkill(Competence competence);
	public Competence mergeSkill(Competence competence);
	public boolean contains(Competence competence);
	public int removeSkillById(String id);
	public long getCountByCategory(String category);
	public long getCountByName(int id);
	public List<Competence> searchByName(String name);
	public List<Competence> searchByCategory(String category);
	public List<Competence> listAll();
	public List<String> getCategories();

}
