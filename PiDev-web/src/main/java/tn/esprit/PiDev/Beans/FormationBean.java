package tn.esprit.PiDev.Beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import tn.esprit.PiDev.Services.FormationService;
import tn.esprit.PiDev.Services.FormerService;
import tn.esprit.PiDev.entities.Avis;
import tn.esprit.PiDev.entities.Formation;
import tn.esprit.PiDev.entities.Former;
import tn.esprit.PiDev.entities.Specialty;
import tn.esprit.PiDev.entities.Test;


@ManagedBean
@SessionScoped
public class FormationBean {
	
	private String titleFormation;
	private String domaineFormation;
	private Date dateDebut;
	private Date dateFin;
	List<Formation> listFormation;
	private Formation formation;
	List<Former> listFormer;
	//@ManagedProperty("#{Formation}")
	private Former former;
	
	private Avis aviss;
	private Test testt;
	
	@EJB
	FormationService formationService;
	
	@EJB
	FormerService formerService;
	
	public String ajouter() {
			
			Formation frt= new Formation();
			formationService.addFormation(new Formation(titleFormation, domaineFormation, dateDebut, dateFin));
			return "/";
		}
	

	public List<Formation> formations;
	
	@PostConstruct
	void init()
	{
		listFormer =  formerService.getAllFormer();
	}
	
	
	
	public List<Formation> getFormations()
	{
		listFormation = formationService.getAllFormation();
		return listFormation;
		
	}

	
	public void supprimerFomation(Integer idFormation) {


		formationService.deleteFormation(idFormation);
	}
	
	
	
	public void mettreAjourFormation(Formation formation)
	{

		formationService.updateFormation(new Formation(titleFormation, domaineFormation, dateDebut, dateFin));
	}
	
	
	public String getTitleFormation() {
		return titleFormation;
	}

	public void setTitleFormation(String titleFormation) {
		this.titleFormation = titleFormation;
	}

	public String getDomaineFormation() {
		return domaineFormation;
	}

	public void setDomaineFormation(String domaineFormation) {
		this.domaineFormation = domaineFormation;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	
	
	
	public Date getDateFin() {
		return dateFin;
	}

/*	public SimpleDateFormat getDateDebut() {
		return dateDebut;
	}



	public void setDateDebut(SimpleDateFormat dateDebut) {
		this.dateDebut = dateDebut;
	}
*/


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public List<Formation> getListFormation() {
		return listFormation;
	}

	public void setListFormation(List<Formation> listFormation) {
		this.listFormation = listFormation;
	}

	public FormationService getFormationService() {
		return formationService;
	}

	public void setFormationService(FormationService formationService) {
		this.formationService = formationService;
	}

	public Former getFormer() {
		return former;
	}

	public void setFormer(Former former) {
		this.former = former;
	}
	
	
	public List<Former> getListFormer() {
		return listFormer;
	}

	public void setListFormer(List<Former> listFormer) {
		this.listFormer = listFormer;
	}

	/*public List<Formation> getFormations() {
		return formations;
	}
*/
	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	//zyede
	public Formation getFormation() {
		return formation;
	}


	public void setFormation(Formation formation) {
		this.formation = formation;
	}



	public Avis getAviss() {
		return aviss;
	}



	public void setAviss(Avis aviss) {
		this.aviss = aviss;
	}



	public Test getTestt() {
		return testt;
	}



	public void setTestt(Test testt) {
		this.testt = testt;
	}



	public FormerService getFormerService() {
		return formerService;
	}



	public void setFormerService(FormerService formerService) {
		this.formerService = formerService;
	}
	
	//zyede
	
	
}	