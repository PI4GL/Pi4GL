package tn.esprit.PiDev.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DevTeam implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTeam ;
	
	
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
