package tn.esprit.PiDev.Remotes;



import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PiDev.entities.Status;
import tn.esprit.PiDev.entities.Ticket;
import tn.esprit.PiDev.entities.User;



@Remote
public interface TicketServicesRRemote {

	
	public void addTicket(Ticket ticket);
	public List<Ticket> getAllTickets();
	public List<Ticket> getTicketsByStatus(Status s);
	public List<Ticket> getTicketByAssignement(boolean a);
	public void deleteTicketByID(int id);
	public void assignTicketToEmployee(int idEmploye);
public void AssignTicket(int id,User emp);
	
	public List<Ticket> getTicketByEmployeeAndStatus(User employee , Status s);
	
	public void UnderReviewTicket(int id);
	public void InProgressTicket(int id);
	public void ValidateTicket(int id);

}

