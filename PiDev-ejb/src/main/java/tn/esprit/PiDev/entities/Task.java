package tn.esprit.PiDev.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Task implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTask ;
    private String title;
    private String description;
    private static final long serialVersionUID = 1L;
    
	//@OneToMany(mappedBy="employe")
	//private List<WorkedOn> workedOn = new ArrayList<>() ;

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

	/*public List<WorkedOn> getWorkedOn() {
		return workedOn;
	}

	public void setWorkedOn(List<WorkedOn> workedOn) {
		this.workedOn = workedOn;
	}
*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Task(int idTask, String title, String description) {
		super();
		this.idTask = idTask;
		this.title = title;
		this.description = description;
	
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
