package tn.esprit.PiDev.Services;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.PiDev.Remotes.TicketServicesRRemote;
import tn.esprit.PiDev.entities.Status;
import tn.esprit.PiDev.entities.Ticket;
import tn.esprit.PiDev.entities.User;

@Stateless
@LocalBean
public class TicketServicesR implements TicketServicesRRemote {

    public TicketServicesR() {
        // TODO Auto-generated constructor stub
    }
       
	@PersistenceContext
    EntityManager em;
	@Override
	public void addTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		em.persist(ticket);
		
	}

	@Override
	public List<Ticket> getAllTickets() {
		List <Ticket>  les_Tickets= new ArrayList<>()  ; //
		Query query = em.createQuery("select t from Ticket t"); 
		try {
			les_Tickets = query.getResultList();
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return les_Tickets;
	}

	@Override
	public List<Ticket> getTicketsByStatus(Status s) {
		List <Ticket>  les_Tickets= new ArrayList<>()  ; //
		Query query = em.createQuery("select t from Ticket t where t.status=:s"); 
		query.setParameter("s", s);
		try {
			les_Tickets = query.getResultList();
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return les_Tickets;
	}

	@Override
	public List<Ticket> getTicketByAssignement(boolean a) {
		List <Ticket>  les_Tickets= new ArrayList<>()  ; //
		Query query = em.createQuery("select t from Ticket t where t.assignement=:a"); 
		query.setParameter("a", a);
		try {
			les_Tickets = query.getResultList();
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return les_Tickets;
	}

	@Override
	public void deleteTicketByID(int id) {
		Ticket t;
		t=em.find(Ticket.class, id);
		em.remove(t);
		
	}

	@Override
	public void assignTicketToEmployee(int idEmploye) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AssignTicket(int id, User emp) {
		// TODO Auto-generated method stub
		Ticket t=em.find(Ticket.class,id);
		t.setEmployee(emp);
		t.setAssignement(true);
		t.setStatus(Status.in_progress);
		em.persist(t);

	}

	@Override
	public List<Ticket> getTicketByEmployeeAndStatus(User employee, Status s) {
		List <Ticket>  les_Tickets= new ArrayList<>()  ; //
		Query query = em.createQuery("select t from Ticket t where t.employee=:employee and  t.status=:s"); 
		query.setParameter("employee", employee);
		query.setParameter("s", s);
		try {
			les_Tickets = query.getResultList();
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return les_Tickets;

	}

	@Override
	public void UnderReviewTicket(int id) {
		// TODO Auto-generated method stub

		Ticket t=em.find(Ticket.class,id);
		t.setStatus(Status.under_review);
		em.persist(t);

		
	}

	@Override
	public void InProgressTicket(int id) {
		// TODO Auto-generated method stub
		Ticket t=em.find(Ticket.class,id);
		t.setStatus(Status.in_progress);
		em.persist(t);


		
	}

	@Override
	public void ValidateTicket(int id) {
		// TODO Auto-generated method stub
		Ticket t=em.find(Ticket.class,id);
		t.setStatus(Status.done);
		em.persist(t);

		
	}

   
	
    

}
