package tn.esprit.PiDev.Remotes;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PiDev.entities.Project;


@Remote
public interface ProjectRemote {
	public void deleteProjet(int idProject);
	public void addProject(Project p);
	public void updateProject(Project p);
	Project findbyId(int i);
	List<Project> getListProjects();
    

}
