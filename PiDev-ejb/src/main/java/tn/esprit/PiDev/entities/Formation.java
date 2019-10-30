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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Formation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFormation;
	private String titleFormation;
	private String domaineFormation;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	
	private Avis aviss;

	
	@OneToMany(mappedBy="formation")
	private List<Test> test;
	
	@OneToMany(mappedBy="formation")
	private List<Avis> avis;
	/*@ManyToMany
	private List<Employe> employe;*/
	
	@ManyToOne
	private Former former;
	
	public Formation() {
		
	}
	
	

	public Formation(String titleFormation, String domaineFormation, Date dateDebut,Date dateFin) {
		super();
		this.titleFormation = titleFormation;
		this.domaineFormation = domaineFormation;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}


	

	public Formation(String titleFormation, String domaineFormation, Date dateDebut, Date dateFin, List<Test> test,List<Avis> avis, Former former) {
		super();
		this.titleFormation = titleFormation;
		this.domaineFormation = domaineFormation;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.test = test;
		this.avis = avis;
		this.former = former;
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


	public List<Avis> getAvis() {
		return avis;
	}


	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}



	public Avis getAviss() {
		return aviss;
	}



	public void setAviss(Avis aviss) {
		this.aviss = aviss;
	}

	
		
	

}
