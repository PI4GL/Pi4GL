package tn.esprit.PiDev.Beans;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PiDev.Services.FormerService;
import tn.esprit.PiDev.entities.Former;
import tn.esprit.PiDev.entities.Specialty;


@ManagedBean
@SessionScoped
public class FormerBean {
	
	//zyede
	private int idFormer;
	//---
	private Specialty specialty;
	private String nameFormer;
	private String lastNameFormer;
	List<Former> listFormer;
	private Former former;
	
	@EJB
	FormerService formerService;
	
	public String ajouter() {
		
		Former fr = new Former();
		fr.setNameFormer(nameFormer);
		fr.setLastNameFormer(lastNameFormer);
		fr.setSpecialty(specialty);
		formerService.addFormer(fr);
		
		return "/";
	}

	public List<Former> formers;
	
	public List<Former> getFormers()
	{
		listFormer = formerService.getAllFormer();
		return listFormer;	
		
	}
	
	
	
	public void supprimerFormer(Integer idFormer) {

		formerService.deleteFormer(idFormer);

	}
	
	public void mettreAjourFormer(Former former)
	{
		formerService.updateFormer(new Former(specialty, nameFormer, lastNameFormer));
	}
	
	public FormerBean() {
		
	}

	
	
	public int getIdFormer() {
		return idFormer;
	}


	public void setIdFormer(int idFormer) {
		this.idFormer = idFormer;
	}


	public void setFormers(List<Former> formers) {
		this.formers = formers;
	}

	

	public Specialty getSpecialty() {
		return specialty;
	}



	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}



	public String getNameFormer() {
		return nameFormer;
	}

	public void setNameFormer(String nameFormer) {
		this.nameFormer = nameFormer;
	}

	public String getLastNameFormer() {
		return lastNameFormer;
	}

	public void setLastNameFormer(String lastNameFormer) {
		this.lastNameFormer = lastNameFormer;
	}

	public FormerService getFormerService() {
		return formerService;
	}

	public void setFormerService(FormerService formerService) {
		this.formerService = formerService;
	}

	public List<Former> getListFormer() {
		return listFormer;
	}

	public void setListFormer(List<Former> listFormer) {
		this.listFormer = listFormer;
	}

	public Former getFormer() {
		return former;
	}

	public void setFormer(Former former) {
		this.former = former;
	}
	
	
	
	//zyedz
	public void initialisation() {
		nameFormer = null;
		lastNameFormer = null;
		specialty = null;
	}
	
	
	public void recupererFormer(Former f) {
		initialisation();

		nameFormer = f.getNameFormer();
		lastNameFormer=f.getLastNameFormer();
		specialty=f.getSpecialty();
		this.setIdFormer(f.getIdFormer());
	}

	//zyede
}
