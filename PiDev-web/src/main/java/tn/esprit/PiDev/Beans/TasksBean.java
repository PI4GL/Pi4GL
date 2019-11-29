package tn.esprit.PiDev.Beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import tn.esprit.PiDev.entities.Project;
import tn.esprit.PiDev.entities.Status;
import tn.esprit.PiDev.entities.WorkedOn;

@javax.faces.bean.ManagedBean(name = "tasksBean")
@SessionScoped
public class TasksBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idTask ;
    private String title;
    private String description;
	
    private Status status;
    private List<WorkedOn> workedOn;
    private Project project;
	public int getIdTask() {
		return idTask;
	}
	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<WorkedOn> getWorkedOn() {
		return workedOn;
	}
	public void setWorkedOn(List<WorkedOn> workedOn) {
		this.workedOn = workedOn;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
    

}
