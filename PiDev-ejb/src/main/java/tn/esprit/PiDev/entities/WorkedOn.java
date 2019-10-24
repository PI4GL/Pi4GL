package tn.esprit.PiDev.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class WorkedOn implements Serializable {
	private Date beginingOn;
	private Date endingOn;
	
	
	@ManyToOne
	@JoinColumn(name="cin",referencedColumnName="cin",insertable=false, updatable=false)
	private Employe employe;
	
	
	@ManyToOne
	@JoinColumn(name="idTask",referencedColumnName="idTask",insertable=false, updatable=false)
	private Task task;
	
	
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private WorkedOnID workedOnId;
	
	
	
	
	
	
	public WorkedOnID getWorkedOnId() {
		return workedOnId;
	}
	public void setWorkedOnId(WorkedOnID workedOnId) {
		this.workedOnId = workedOnId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Date getBeginingOn() {
		return beginingOn;
	}
	public void setBeginingOn(Date beginingOn) {
		this.beginingOn = beginingOn;
	}
	public Date getEndingOn() {
		return endingOn;
	}
	public void setEndingOn(Date endingOn) {
		this.endingOn = endingOn;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}


}
