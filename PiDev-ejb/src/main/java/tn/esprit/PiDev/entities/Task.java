package tn.esprit.PiDev.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Task implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTask ;
    private String title;
    private String description;
	@Enumerated(EnumType.STRING)
    private Status status;
    private static final long serialVersionUID = 1L;
    
    @OneToMany(mappedBy="task")
    private List<WorkedOn> workedOn;
    
    
    
	public List<WorkedOn> getWorkedOn() {
		return workedOn;
	}
	public void setWorkedOn(List<WorkedOn> workedOn) {
		this.workedOn = workedOn;
	}
	@ManyToOne
	private Project project;
	
	
    
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task(int idTask, String title, String description, Status status) {
		super();
		this.idTask = idTask;
		this.title = title;
		this.description = description;
		this.status = status;
	}
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
	//@OneToMany(mappedBy="employe")
	//private List<WorkedOn> workedOn = new ArrayList<>() ;


    
    
}
