package tn.esprit.PiDev.Remotes;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PiDev.entities.CompetenceMatrix;

@Remote
public interface CompetenceMatrixRemote {
	public void addCompetenceMatrix(CompetenceMatrix e);
	public void updateCompetenceMatrix(CompetenceMatrix e);
	List<CompetenceMatrix> getListCompetenceMatrixs();
	void deleteCompetenceMatrix(CompetenceMatrix e);
}
