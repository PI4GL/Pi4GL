package tn.esprit.PiDev.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import tn.esprit.PiDev.entities.Employe;

@Entity
public class UserSkill implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;/*
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "cin", insertable = true, updatable = true)
	private Employe user;
	@ManyToOne
	@JoinColumn(name = "skill_id", referencedColumnName = "id", insertable = true, updatable = true)
	private _Skill _Skill;
	private int level;

	public UserSkill() {

	}

	public UserSkill(int id, Employe user, _Skill _Skill, int level) {
		super();
		this.id = id;
		this.user = user;
		this._Skill = _Skill;
		this.level = level;
	}

	public UserSkill(Employe user, _Skill _Skill, int level) {
		super();
		this.user = user;
		this._Skill = _Skill;
		this.level = level;
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

	public _Skill getSkill() {
		return _Skill;
	}

	public void setSkill(_Skill _Skill) {
		this._Skill = _Skill;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
*/
}