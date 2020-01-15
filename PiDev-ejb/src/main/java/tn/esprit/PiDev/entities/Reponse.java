package tn.esprit.PiDev.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Reponse implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRep;
	private Boolean isValide;
	private String description;
	
	@ManyToOne
	private Question quest;
	
	public Reponse() {
		super();
	}

	
	
	public Reponse(Integer idRep, Boolean isValide, String description, Question quest) {
		super();
		this.idRep = idRep;
		this.isValide = isValide;
		this.description = description;
		this.quest = quest;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIdRep() {
		return idRep;
	}

	public void setIdRep(Integer idRep) {
		this.idRep = idRep;
	}

	public Boolean getIsValide() {
		return isValide;
	}

	public void setIsValide(Boolean isValide) {
		this.isValide = isValide;
	}

	public Question getQuest() {
		return quest;
	}

	public void setQuest(Question quest) {
		this.quest = quest;
	}

	
	
	

}
