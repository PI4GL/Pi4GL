package tn.esprit.PiDev.Beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import tn.esprit.PiDev.Services.FormationService;
import tn.esprit.PiDev.Services.FormerService;
import tn.esprit.PiDev.entities.Avis;
import tn.esprit.PiDev.entities.Formation;
import tn.esprit.PiDev.entities.Former;
import tn.esprit.PiDev.entities.Specialty;
import tn.esprit.PiDev.entities.Test;

@ManagedBean
@RequestScoped
public class FormationBean {

	private String idFormation;
	private String titleFormation;
	private String domaineFormation;
	private String dateDebut;
	private String dateFin;
	private String dateDebut1;
	private String dateFin1;
	List<Formation> listFormation;
	private Formation formation;
	List<Former> listFormer;

	private int former;

	private Avis aviss;

	@EJB
	FormationService formationService;

	@EJB
	FormerService formerService;

	public String ajouter() throws ParseException {

		Formation frt = new Formation();
		frt.setTitleFormation(titleFormation);
		frt.setDomaineFormation(domaineFormation);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		frt.setDateDebut((Date) formatter.parse(dateDebut));
		frt.setDateFin((Date) formatter.parse(dateFin));
		// frt.setAviss(aviss);
		frt.setFormer(formerService.getFormerById(former));

		formationService.addFormation(frt);
		return "/";
	}

	public List<Formation> formations;

	@PostConstruct
	void init() {
		listFormer = formerService.getAllFormer();
	}

	public List<Formation> getFormations() {
		listFormation = formationService.getAllFormation();
		return listFormation;

	}

	public String supprimerFomation(Integer idFormation) {

		formationService.deleteFormation(idFormation);
		return "Formation?faces-redirect=true";
	}

	public void mettreAjourFormation(Formation formation) {
		idFormation = String.valueOf(formation.getIdFormation());
		titleFormation = formation.getTitleFormation();
		domaineFormation = formation.getDomaineFormation();
		dateDebut1 = formation.getDateDebut().toString();
		dateFin1 = formation.getDateFin().toString();
		former=formation.getFormer().getIdFormer();
		
	}

	public String updateFormation() throws ParseException {

		Formation frt = formationService.getFormationById(Integer.parseInt(idFormation));
		frt.setTitleFormation(titleFormation);
		frt.setDomaineFormation(domaineFormation);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if(!dateDebut.equals(""))
		{
			frt.setDateDebut((Date) formatter.parse(dateDebut));

		}
		if(!dateFin.equals(""))
		{
			frt.setDateFin((Date) formatter.parse(dateFin));
			
		}
		
		Former f = formerService.getFormerById(former);

		frt.setFormer(f);
		formationService.updateFormation(frt);
		return "Formation?faces-redirect=true";
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

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
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

	public int getFormer() {
		return former;
	}

	public void setFormer(int former) {
		this.former = former;
	}

	public List<Former> getListFormer() {
		return listFormer;
	}

	public void setListFormer(List<Former> listFormer) {
		this.listFormer = listFormer;
	}

	/*
	 * public List<Formation> getFormations() { return formations; }
	 */
	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	// zyede
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

	public FormerService getFormerService() {
		return formerService;
	}

	public void setFormerService(FormerService formerService) {
		this.formerService = formerService;
	}

	public String getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(String idFormation) {
		this.idFormation = idFormation;
	}

	public String getDateDebut1() {
		return dateDebut1;
	}

	public void setDateDebut1(String dateDebut1) {
		this.dateDebut1 = dateDebut1;
	}

	public String getDateFin1() {
		return dateFin1;
	}

	public void setDateFin1(String dateFin1) {
		this.dateFin1 = dateFin1;
	}

	// zyede4

}