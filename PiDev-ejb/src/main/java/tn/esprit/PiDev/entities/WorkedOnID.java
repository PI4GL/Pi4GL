package tn.esprit.PiDev.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class WorkedOnID implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idEmp;
	private int idTask;
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEmp;
		result = prime * result + idTask;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkedOnID other = (WorkedOnID) obj;
		if (idEmp != other.idEmp)
			return false;
		if (idTask != other.idTask)
			return false;
		return true;
	}
	public WorkedOnID(int idEmp, int idTask) {
		super();
		this.idEmp = idEmp;
		this.idTask = idTask;
	}
	public int getIdEmp() {
		return idEmp;
	}
	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}
	public int getIdTask() {
		return idTask;
	}
	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public WorkedOnID() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
