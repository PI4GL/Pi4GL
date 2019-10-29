package tn.esprit.PiDev.Remotes;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PiDev.entities.Employe;



@Remote
public interface EmployeServiceRemote {

	public void deleteEmployeById(int idEmp);

	public void ajouterEmploye(Employe e);
	public void updateEmploye(Employe e);

	public void supprimerEmploye(int idEnt);

	public Employe getEmployeById(int idEnt);


	List<Employe> getListEmployes();

	Employe getEmployeByName(String name);

	public Employe getEmployeByLoginAndPwd(String login, String password);
	public Employe getEmployeByEmailAndPassword(String login, String password); 

}
