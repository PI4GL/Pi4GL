package tn.esprit.PiDev.Remotes;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PiDev.entities.DevTeam;
import tn.esprit.PiDev.entities.Employe;

@Remote
public interface DevTeamRemote {
	public void addDevTeam(DevTeam DT);
	public void deleteDevTeam(DevTeam DT);
	public void updateDevTeam(DevTeam DT);
	List<DevTeam> getDevTeamList();
	List<Employe> getEmployeDevTeamByTeaM(int idDevT);
	public void addEmployeToDevTeam(Employe emp);

}
