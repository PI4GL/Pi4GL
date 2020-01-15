package tn.esprit.PiDev.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class UserQuizResponse implements Serializable {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="id", insertable = true, updatable = true)
	private Utilisateur user;
	@ManyToOne
	@JoinColumn(name="response_id", referencedColumnName="id", insertable = true, updatable = true)
	private QuestionResponse response;
	private boolean isChecked;
	public UserQuizResponse() {}
	public UserQuizResponse(int id, Utilisateur user, QuestionResponse response, boolean isChecked) {
		super();
		this.id = id;
		this.user = user;
		this.response = response;
		this.isChecked = isChecked;
	}
	public UserQuizResponse( Utilisateur user, QuestionResponse response, boolean isChecked) {
		super();
		this.user = user;
		this.response = response;
		this.isChecked = isChecked;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public QuestionResponse getResponse() {
		return response;
	}

	public void setResponse(QuestionResponse response) {
		this.response = response;
	}

	public boolean getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
	
}
