package tn.esprit.PiDev.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import tn.esprit.PiDev.entities.Employe;

@Entity
public class UserQuiz implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "cin", insertable = true, updatable = true)
	private Employe user;
	@ManyToOne
	@JoinColumn(name = "quiz_id", referencedColumnName = "id", insertable = true, updatable = true)
	private Quiz quiz;
	private int score;

	@Column(name = "curr_question_index")
	private int currentQuestionIndex;
	
	public UserQuiz()
	{
		
	}

	public UserQuiz(long id, Employe user, Quiz quiz, int score) {
		super();
		this.id = id;
		this.user = user;
		this.quiz = quiz;
		this.score = score;
	}

	public UserQuiz(Employe user, Quiz quiz, int score) {
		super();
		this.user = user;
		this.quiz = quiz;
		this.score = score;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Employe getUser() {
		return user;
	}

	public void setUser(Employe user) {
		this.user = user;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public int getCurrentQuestionIndex() {
		return currentQuestionIndex;
	}

	public void setCurrentQuestionIndex(int currentQuestionIndex) {
		this.currentQuestionIndex = currentQuestionIndex;
	}
}
