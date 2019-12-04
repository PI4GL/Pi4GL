package tn.esprit.PiDev.Remotes;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import tn.esprit.PiDev.entities.*;
@Local
public interface RessourceServiceLocal {
	public void persistRessource(Ressource res);
	public Ressource findRessource(int id);
	public void removeRessource(Ressource res);
	public Ressource mergeRessource(Ressource res);
	public boolean contains(Ressource res);
	public int removeResourceById(String id);
	public List<Ressource> listAll();
	
	public Resume getResourceResume(String id);
	public List<Competence> getResourceSkills(String id);
	public Map<String, Long> rankResourcesBySkillNumber();

	

}
