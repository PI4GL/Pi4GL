package tn.esprit.PiDev.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Test implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTest;
	private Score score ;
	private String titeTest;
	private String Speciality;
	
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
	
	
	
	
}
