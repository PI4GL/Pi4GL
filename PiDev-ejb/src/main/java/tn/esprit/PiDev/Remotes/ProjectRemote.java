package tn.esprit.PiDev.Remotes;

import java.util.List;

import javax.ejb.Remote;
import javax.persistence.TypedQuery;

import tn.esprit.PiDev.entities.DevTeam;
import tn.esprit.PiDev.entities.Project;


@Remote
public interface ProjectRemote {
	public void deleteProjet(int idProject);
	public void addProject(Project p);
	public void updateProject(Project p);
	Project findbyId(int i);
	List<Project> getListProjects();
	List<DevTeam> getdevTeam();
	
    

}
