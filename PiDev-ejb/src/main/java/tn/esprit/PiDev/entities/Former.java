package tn.esprit.PiDev.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Former implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFormer;
	private String specialty;
	private String nameFormer;
	private String lastNameFormer;
	
	
	public Former() {
		
	}


	public Integer getIdFormer() {
		return idFormer;
	}


	public void setIdFormer(Integer idFormer) {
		this.idFormer = idFormer;
	}


	public String getSpecialty() {
		return specialty;
	}


	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}


	public String getNameFormer() {
		return nameFormer;
	}


	public void setNameFormer(String nameFormer) {
		this.nameFormer = nameFormer;
	}


	public String getLastNameFormer() {
		return lastNameFormer;
	}


	public void setLastNameFormer(String lastNameFormer) {
		this.lastNameFormer = lastNameFormer;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		

	
}
