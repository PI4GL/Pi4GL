package tn.esprit.PiDev.Remotes;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PiDev.entities.Formation;

@Remote
public interface FormationInterface {
	
	void addFormation(Formation formation);
	void deleteFormation(int idFormation);
	void updateFormation(Formation formation);
	List<Formation> getAllFormation();
	Formation getFormationById(int idFormation);
	Formation getFormationByTitle(String title);

}
