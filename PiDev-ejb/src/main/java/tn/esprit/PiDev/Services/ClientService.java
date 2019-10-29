package tn.esprit.PiDev.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.PiDev.Remotes.ClientRemote;
import tn.esprit.PiDev.entities.Client;

@Stateless
@LocalBean
public class ClientService implements ClientRemote{
	

	@PersistenceContext(unitName = "PiDev-ejb")
	EntityManager em;


	@Override
	public void addClient(Client c) {
		// TODO Auto-generated method stub
		em.persist(c);
		
	}

	@Override
	public void updateCl(Client c) {
		// TODO Auto-generated method stub
		em.merge(c);
		
	}

	@Override
	public void deletCl(int idCl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Client> getListCl() {
		// TODO Auto-generated method stub
		TypedQuery<Client> query = em.createQuery("Select e from Client e", Client.class);
		List<Client> result = query.getResultList();
		return result;
	
	}

}
