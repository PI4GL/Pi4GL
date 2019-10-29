package tn.esprit.PiDev.Beans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;

import tn.esprit.PiDev.Services.ProjectService;
import tn.esprit.PiDev.entities.DevTeam;
import tn.esprit.PiDev.entities.Project;
import tn.esprit.PiDev.entities.Task;

@javax.faces.bean.ManagedBean(name = "projectBean")
@SessionScoped

public class ProjetBean implements Serializable  {
private int idProject ;
	
	private String projectName;
	private Date launchedOn;
	private Date deadLine;
	private List<DevTeam> devTeam = new ArrayList<>(); 
	private List<Task> task = new ArrayList<>();
	
	@EJB ProjectService projectSrvice;
	
	public void addProjet() {
		projectSrvice.addProject(new Project(idProject, projectName, launchedOn, deadLine));
	}
	public List<Project> projets;
	 public List<Project> getProjets(){
		 projets= projectSrvice.getListProjects();
		 return projets;
	 }

}
