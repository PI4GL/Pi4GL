package tn.esprit.PiDev.Beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import tn.esprit.PiDev.entities.*;
import tn.esprit.PiDev.Services.*;



@ManagedBean(name = "skillBean", eager = true)
@SessionScoped
public class SkillBean {

	@EJB
	SkillService skillService;


	private String name;
	private String category;
	
	boolean canAddSkill = false;
	List<Skill> skills;


	int toUpdateSkillId;

	@PostConstruct
	public void init() {
		System.out.println("init called.");
		skills = skillService.listAll();
		
	}

	public SkillService getSkillService() {
		return skillService;
	}

	public void setSkillService(SkillService skillService) {
		this.skillService = skillService;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public int getToUpdateSkillId() {
		return toUpdateSkillId;
	}

	public void setToUpdateSkillId(int toUpdateSkillId) {
		this.toUpdateSkillId = toUpdateSkillId;
	}

	public String addSkill() {
		System.out.println("addSkill called.");

		if (name == null || name.isEmpty())
			return "";

		
		skillService.persistSkill(new Skill(name, category) );

		name = null;
		category = null;

		return "skill_crud.xhtml?faces-redirect=true";
	}

	public void verifyExistance(AjaxBehaviorEvent abe) {
		System.out.println("Skill: " + name + ".");

		if (name == null || name.isEmpty()) {
			canAddSkill = false;
			return;
		}

		Skill selectedSkill = skillService.getSkillByName(name);

	

		canAddSkill = selectedSkill == null;
	}



	public String goToEditSkill(int skillId) {
		Skill skill = skillService.findSkill(skillId);

		if (skill == null)
			return "";

		toUpdateSkillId = skillId;
		name = skill.getName();
		category = skill.getCategory();
		canAddSkill = true;

		return "skill_update.xhtml?faces-redirect=true";
	}

	public String updateSkill() {
		Skill skill = skillService.findSkill(toUpdateSkillId);

		if (skill == null)
			return "";

		skill.setName(name);
		skill.setCategory(category);

		skillService.mergeSkill(skill);

		return "skill_crud.xhtml?faces-redirect=true";
	}

	public String deleteSkill(int skillId) {
		Skill skill = skillService.findSkill(skillId);

		if (skill == null)
			return "";

		skillService.removeSkill(skill);

		return "skill_crud.xhtml?faces-redirect=true";
	}

	/*
	 * Getters and Setters
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public boolean isCanAddSkill() {
		return canAddSkill;
	}

	public void setCanAddSkill(boolean canAddSkill) {
		this.canAddSkill = canAddSkill;
	}



	

}
