package tn.esprit.PiDev.Remotes;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PiDev.entities.JobSheet;

@Remote
public interface JobSheetRemote {

	public void updateJobSheet(JobSheet e);
	List<JobSheet> getListJobSheets();
	void deleteJobSheet(JobSheet e);
	void addJobSeet(JobSheet e);
}
