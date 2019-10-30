package tn.esprit.PiDev.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.PiDev.entities.*;
import tn.esprit.PiDev.Remotes.*;

@Stateless
@LocalBean
public class ResponseService  implements ResponseServiceRemote{
	@PersistenceContext
    EntityManager em;

	@Override
	public void addResponse(QuestionResponse response) {
			em.persist(response);
	}


}
