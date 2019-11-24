package tn.esprit.PiDev.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	@OneToMany(mappedBy="category")
	private List<_Skill> _Skills;
	
	
	public Category() {}
	public Category(String name,String description)
	{
		this.name = name;
		this.description = description;
	}
	public Category(long id, String name, String description, List<_Skill> _Skills) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this._Skills = _Skills;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<_Skill> getSkills() {
		return _Skills;
	}
	public void setSkills(List<_Skill> _Skills) {
		this._Skills = _Skills;
	}
		
	
	
}
