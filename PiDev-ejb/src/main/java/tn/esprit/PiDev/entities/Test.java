package tn.esprit.PiDev.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Test implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	
	private Integer idTest;
	@Enumerated(EnumType.STRING)
	private Score score ;
	private String titeTest;
	private String Speciality;
	
	
	@ManyToOne
	@JoinColumn(name="cin",referencedColumnName="cin",insertable=false,updatable=false)
	private Employe employe;
	
	@ManyToOne
	@JoinColumn(name="idFormation",referencedColumnName="idFormation",insertable=false,updatable=false)
	private Formation formation;
	
	@EmbeddedId
	private TestID testId;
	
	public Test() {
		
	}

	public Integer getIdTest() {
		return idTest;
	}

	public void setIdTest(Integer idTest) {
		this.idTest = idTest;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public String getTiteTest() {
		return titeTest;
	}

	public void setTiteTest(String titeTest) {
		this.titeTest = titeTest;
	}

	public String getSpeciality() {
		return Speciality;
	}

	public void setSpeciality(String speciality) {
		Speciality = speciality;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public TestID getTestId() {
		return testId;
	}

	public void setTestId(TestID testId) {
		this.testId = testId;
	}
	
	
	
	
}
