package tn.esprit.PiDev.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Avis implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String commentaire;
	
	@ManyToOne
	@JoinColumn(name="cin",referencedColumnName="cin",insertable=false,updatable=false)
	private Employe employe;
	
	@ManyToOne
	@JoinColumn(name="idFormation",referencedColumnName="idFormation",insertable=false,updatable=false)
	private Formation formation;
	
	@EmbeddedId
	private AvisID avidId;

	public Avis() {
		
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public AvisID getAvidId() {
		return avidId;
	}

	public void setAvidId(AvisID avidId) {
		this.avidId = avidId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
