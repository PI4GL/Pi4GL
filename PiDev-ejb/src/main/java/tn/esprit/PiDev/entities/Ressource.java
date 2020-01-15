package tn.esprit.PiDev.entities;

import java.io.Serializable;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import javax.persistence.ManyToOne;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ressource extends Employe implements Serializable{
	
	@OneToOne
	@JoinColumn(name="resumeId")
	private Resume resume;
	

	
	public Ressource() {
		super();
	}

	public Ressource(int cin) {
		super(cin);
	}
	


	

	public Resume getResume() {
		return resume;
	}


	public void setResume(Resume resume) {
		this.resume = resume;
	}



	


	public Ressource(Resume resume
		) {
		super();
		
		this.resume = resume;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((resume == null) ? 0 : resume.hashCode());
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
		Ressource other = (Ressource) obj;
		if (resume == null) {
			if (other.resume != null)
				return false;
		} else if (!resume.equals(other.resume))
			return false;
		return true;
	}


	




	
	
	
	
	
	
	
}