package tn.esprit.PiDev.Remotes;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PiDev.entities.Timesheet;
import tn.esprit.PiDev.entities.User;


@Remote
public interface TimesheetServicesRRemote {
	
	//public List<Timesheet> getShiftsByOwner(User owner);
	public List<Timesheet> getShiftsByOwner(User owner);

}