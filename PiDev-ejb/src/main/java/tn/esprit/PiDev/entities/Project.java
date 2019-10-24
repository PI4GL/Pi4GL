package tn.esprit.PiDev.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Project implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProject ;
	
	private String projectName;
	private Date LaunchedOn;
	private Date DeadLine;
	
	
	
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(mappedBy="project" )
	private List<DevTeam> devTeam = new ArrayList<>(); ;
	
	@OneToMany(mappedBy = "project", cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	private List<Task> task = new ArrayList<>();
	
	
	
	
	
	
	public List<Task> getTask() {
		return task;
	}
	public void setTask(List<Task> task) {
		this.task = task;
	}
	public List<DevTeam> getDevTeam() {
		return devTeam;
	}
	public void setDevTeam(List<DevTeam> devTeam) {
		this.devTeam = devTeam;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
		return LaunchedOn;
	}
	public void setLaunchedOn(Date launchedOn) {
		LaunchedOn = launchedOn;
	}
	public Date getDeadLine() {
		return DeadLine;
	}
	public void setDeadLine(Date deadLine) {
		DeadLine = deadLine;
	}
	public Project(int idProject, String projectName, Date launchedOn, Date deadLine) {
		super();
		this.idProject = idProject;
		this.projectName = projectName;
		LaunchedOn = launchedOn;
		DeadLine = deadLine;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	
}
