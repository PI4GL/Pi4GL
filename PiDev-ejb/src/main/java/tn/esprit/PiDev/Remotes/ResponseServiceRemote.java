package tn.esprit.PiDev.Remotes;

import javax.ejb.Remote;

import tn.esprit.PiDev.entities.QuestionResponse;

@Remote
public interface ResponseServiceRemote {

	public void addResponse(QuestionResponse response);
	
	
}
