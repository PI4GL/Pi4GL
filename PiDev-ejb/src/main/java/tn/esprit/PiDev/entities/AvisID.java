package tn.esprit.PiDev.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AvisID implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idEmp;
	private int idFor;
	
	public AvisID() {
		
	}

	public int getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}

	public int getIdFor() {
		return idFor;
	}

	public void setIdFor(int idFor) {
		this.idFor = idFor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEmp;
		result = prime * result + idFor;
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
		AvisID other = (AvisID) obj;
		if (idEmp != other.idEmp)
			return false;
		if (idFor != other.idFor)
			return false;
		return true;
	}
	
	
	
	
}
