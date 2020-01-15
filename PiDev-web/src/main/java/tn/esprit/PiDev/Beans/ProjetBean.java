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
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private int idProject ;
	
	public static long getSerialversionuid() {
	return serialVersionUID;
}
	private String projectName;
	private Date launchedOn;
	private Date deadLine;
	private List<DevTeam> devTeam = new ArrayList<>(); 
	private List<Task> task = new ArrayList<>();
	
	@EJB ProjectService projectSrvice;
	
	public void addProjet() {
		projectSrvice.addProject(new Project(idProject, projectName, launchedOn, deadLine));
		initialisation();
		goBack();
	}
	public String goBack() {
		return  "/project.jsf";
	}
	

	public void deleteProject(int idProject) {
		
		projectSrvice.deleteProjet(idProject);
	}
	public void initialisation() {
		projectName = null;
	
	launchedOn=new Date();
	deadLine=new Date();
	}
	public List<Project> projets;
	 public List<Project> getProjets(){
		 projets= projectSrvice.getListProjects();
		 return projets;
	 }
	public int getIdProject() {
		return idProject;
	}
	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getLaunchedOn() {
		return launchedOn;
	}
	public void setLaunchedOn(Date launchedOn) {
		this.launchedOn = launchedOn;
	}
	public Date getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	public List<DevTeam> getDevTeam() {
		return devTeam;
	}
	public void setDevTeam(List<DevTeam> devTeam) {
		this.devTeam = devTeam;
	}
	public List<Task> getTask() {
		return task;
	}
	public void setTask(List<Task> task) {
		this.task = task;
	}
	public ProjectService getProjectSrvice() {
		return projectSrvice;
	}
	public void setProjectSrvice(ProjectService projectSrvice) {
		this.projectSrvice = projectSrvice;
	}
	public void setProjets(List<Project> projets) {
		this.projets = projets;
	}
	public ProjetBean(int idProject, String projectName, Date launchedOn, Date deadLine, List<DevTeam> devTeam,
			List<Task> task, ProjectService projectSrvice, List<Project> projets) {
		super();
		this.idProject = idProject;
		this.projectName = projectName;
		this.launchedOn = launchedOn;
		this.deadLine = deadLine;
		this.devTeam = devTeam;
		this.task = task;
		this.projectSrvice = projectSrvice;
		this.projets = projets;
	}
	public ProjetBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 

}
