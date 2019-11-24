package tn.esprit.PiDev.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class JobSheet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id ;
	private String name;
	private String description;
	private float basicSalary;
	
	@OneToMany
	private List<Skill> Skills=new ArrayList<Skill>();
	private Integer requiredExp;
	
	@Override
	public String toString() {
		return "JobSheet [Id=" + Id + ", name=" + name + ", description=" + description + ", basicSalary=" + basicSalary
				+ ", skills=" + Skills + ", requiredExp=" + requiredExp +  "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + Float.floatToIntBits(basicSalary);
	
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((requiredExp == null) ? 0 : requiredExp.hashCode());
		result = prime * result + ((Skills == null) ? 0 : Skills.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobSheet other = (JobSheet) obj;
		if (Id != other.Id)
			return false;
		if (Float.floatToIntBits(basicSalary) != Float.floatToIntBits(other.basicSalary))
			return false;
		
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (requiredExp == null) {
			if (other.requiredExp != null)
				return false;
		} else if (!requiredExp.equals(other.requiredExp))
			return false;
		if (Skills == null) {
			if (other.Skills != null)
				return false;
		} else if (!Skills.equals(other.Skills))
			return false;
		return true;
	}
	public JobSheet(int id, String name, String description, float basicSalary, List<Skill> _Skills, Integer requiredExp) {
		super();
		Id = id;
		this.name = name;
		this.description = description;
		this.basicSalary = basicSalary;
		this.Skills = Skills;
		this.requiredExp = requiredExp;
		
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	public float getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	public List<Skill> getSkills() {
		return Skills;
	}
	public void setSkills(List<Skill> _Skills) {
		this.Skills = _Skills;
	}
	public Integer getRequiredExp() {
		return requiredExp;
	}
	public void setRequiredExp(Integer requiredExp) {
		this.requiredExp = requiredExp;
	}
	
	public JobSheet() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
