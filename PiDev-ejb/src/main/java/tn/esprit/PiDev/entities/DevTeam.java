package tn.esprit.PiDev.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class DevTeam implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTeam ;
	
	@OneToMany(mappedBy = "devTeam", cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	private List<Employe> employe = new ArrayList<>();
	
	@ManyToMany
	private List<Project> project;
	
	

	
	
	public List<Employe> getEmploye() {
		return employe;
	}

	public void setEmploye(List<Employe> employe) {
		this.employe = employe;
	}

	

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}



	private String technologie;
	
	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Enumerated(EnumType.STRING)
	private Technologie Tech;

	public int getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}

	public String getTechnologie() {
		return technologie;
	}

	public void setTechnologie(String technologie) {
		this.technologie = technologie;
	}

	public Technologie getTech() {
		return Tech;
	}

	public void setTech(Technologie tech) {
		Tech = tech;
	}

	public DevTeam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DevTeam(int idTeam, String technologie, Technologie tech) {
		super();
		this.idTeam = idTeam;
		this.technologie = technologie;
		Tech = tech;
	}
	
	
}
