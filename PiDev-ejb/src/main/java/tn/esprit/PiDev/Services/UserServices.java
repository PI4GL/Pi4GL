package tn.esprit.PiDev.Services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.PiDev.Remotes.UserServicesRemote;
import tn.esprit.PiDev.entities.Role;
import tn.esprit.PiDev.entities.User;

@Stateless
@LocalBean
public class UserServices implements UserServicesRemote {
	
    @PersistenceContext
	EntityManager em;

	@Override
	public List<User> getallUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String login, String passwd) {
	  	User u =new User();
    	u= em.createQuery("select c from User c where c.login=:l and c.password=:p",User.class)
    			.setParameter("l", login).setParameter("p", passwd).getSingleResult();
    	
    	return u;
	}
	
	public User findUserByID(int id) {
	   	User u =new User();
    	u= em.createQuery("select c from User c where c.id=:id",User.class)
    			.setParameter("id", id).getSingleResult();
    	
    	return u;
	}

	
	public List<User> getAllEmploye(){
		List<User> list = new ArrayList<User>();
		list = em.createQuery("select u from User u where u.role=:role ").setParameter("role", Role.Employee).getResultList();
		return list ;
	}
    public UserServices() {
        // TODO Auto-generated constructor stub
    }


}
