package tn.esprit.PiDev.Remotes;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PiDev.entities.User;

@Remote
public interface UserServicesRemote {
	
	public List<User>getallUser();

	public User login(String login, String passwd);

}
