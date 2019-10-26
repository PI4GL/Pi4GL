package tn.esprit.PiDev.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Formation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFormation;
	private String titleFormation;
	private String domaineFormation;
	private Date dateDebut;
	private Date dateFin;
	
	@OneToMany(mappedBy="formation")
	private List<Test> test;
	
	/*@ManyToMany
	private List<Employe> employe;*/
	
	@ManyToOne
	private Former former;
	
	public Formation() {
		
	}
	

	public Integer getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Integer idFormation) {
		this.idFormation = idFormation;
	}

	public String getTitleFormation() {
		return titleFormation;
	}

	public void setTitleFormation(String titleFormation) {
		this.titleFormation = titleFormation;
	}

	public String getDomaineFormation() {
		return domaineFormation;
	}

	public void setDomaineFormation(String domaineFormation) {
		this.domaineFormation = domaineFormation;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/*public List<Employe> getEmploye() {
		return employe;
	}


	public void setEmploye(List<Employe> employe) {
		this.employe = employe;
	}*/


	public Former getFormer() {
		return former;
	}


	public void setFormer(Former former) {
		this.former = former;
	}


	public List<Test> getTest() {
		return test;
	}


	public void setTest(List<Test> test) {
		this.test = test;
	}
	
		
	

}