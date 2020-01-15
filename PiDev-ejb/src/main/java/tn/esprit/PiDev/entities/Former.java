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
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Former implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFormer;
	@Enumerated(EnumType.STRING)
	private Specialty specialty;
	private String nameFormer;
	private String lastNameFormer;
	

	/*
	@OneToMany(mappedBy="former", cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
	private List<Formation> formation = new ArrayList<Formation>();
	*/
	
	public Former() {
		
	}

	

	public Former(Specialty specialty, String nameFormer, String lastNameFormer) {
		super();
		this.specialty = specialty;
		this.nameFormer = nameFormer;
		this.lastNameFormer = lastNameFormer;
	}



	public Integer getIdFormer() {
		return idFormer;
	}


	public void setIdFormer(Integer idFormer) {
		this.idFormer = idFormer;
	}


	

	public Specialty getSpecialty() {
		return specialty;
	}



	public void setSpecialty(Specialty specialty) {
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

/*
	public List<Formation> getFormation() {
		return formation;
	}


	public void setFormation(List<Formation> formation) {
		this.formation = formation;
	}

*/

	@Override
	public String toString() {
		return nameFormer;
	}
	
	
		
	
	
	
}
