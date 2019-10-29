package tn.esprit.PiDev.Remotes;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.PiDev.entities.Client;

@Stateless
@LocalBean
public interface ClientRemote {
	
	public void addClient(Client c);
	public void updateCl(Client c);
	public void deletCl(int idCl);
	List<Client> getListCl();
	

}
