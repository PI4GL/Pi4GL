package tn.esprit.PiDev.Beans;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import tn.esprit.PiDev.Remotes.TicketServicesRRemote;
import tn.esprit.PiDev.Services.TicketServicesR;
import tn.esprit.PiDev.entities.Status;
import tn.esprit.PiDev.entities.Ticket;

@ManagedBean
public class TicketBean {
	private String title;
	private String description;
	private int estimatedHours;
	private Status status; // lors de la creation  status=to_do
	private Date date ; // system date + time 
	private List<Ticket> les_tickets;
	private boolean assignement;
	private int id; // récupérer id du ticket selectionné
	
	@EJB
	TicketServicesR ticketService;
	
	public void addTicket()
	{
		status= Status.to_do;
		date = new Date();
		assignement=false;
		ticketService.addTicket(new Ticket(title, description, estimatedHours, status, date,assignement));
		
		
	}
	
	@PostConstruct
	public void  getAllTickets()
	{
		les_tickets=ticketService.getAllTickets();

		
	}
	

	public void getTicketsByStatus()
	{
		
		les_tickets=ticketService.getTicketsByStatus(status);
	}
	
	public void getTicketsByAssignement()
	{
		
		les_tickets=ticketService.getTicketByAssignement(assignement);
	}
	
	public void deletTicketByID(int id)
	{
		ticketService.deleteTicketByID(id);
	}
	
	public void ValidateTicketByID(int id)
	{
		ticketService.ValidateTicket(id);
	}
	
	
	public  String redirectToAssign()
	{
		
		return "/web_pages/assign?faces-redirect=true";
	}
	
// getter + setters
	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getEstimatedHours() {
		return estimatedHours;
	}

	public Status getStatus() {
		return status;
	}

	public Date getDate() {
		return date;
	}

	public TicketServicesR getTicketService() {
		return ticketService;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEstimatedHours(int estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setTicketService(TicketServicesR ticketService) {
		this.ticketService = ticketService;
	}

	public List<Ticket> getLes_tickets() {
		return les_tickets;
	}

	public void setLes_tickets(List<Ticket> les_tickets) {
		this.les_tickets = les_tickets;
	}

	public boolean isAssignement() {
		return assignement;
	}

	public void setAssignement(boolean assignement) {
		this.assignement = assignement;
	}

	public int getIdTicket() {
		return id;
	}

	public void setIdTicket(int idTicket) {
		this.id = idTicket;
	}
	
	

}
