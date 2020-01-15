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
public class Question implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idQues;
	private String quesText;
	
	@ManyToOne
	private Test testt;
	
	public Question() {
		super();
	}



	public Question(Integer idQues, String quesText) {
		super();
		this.idQues = idQues;
		this.quesText = quesText;
	}



	public Integer getIdQues() {
		return idQues;
	}



	public void setIdQues(Integer idQues) {
		this.idQues = idQues;
	}



	public String getQuesText() {
		return quesText;
	}



	public void setQuesText(String quesText) {
		this.quesText = quesText;
	}



	public Test getTestt() {
		return testt;
	}



	public void setTestt(Test testt) {
		this.testt = testt;
	}



	
	
	
	
	
}
