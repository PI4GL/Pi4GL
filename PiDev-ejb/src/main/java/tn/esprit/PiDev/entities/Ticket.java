package tn.esprit.PiDev.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 
 * Entity implementation class for Entity: Ticket
 *
 */
@Entity

public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private String description;
	private boolean assignement;
	// int a verifier
	private int estimatedHours;
	private Status status; // lors de la creation  status=to_do
	@Temporal(TemporalType.DATE)
	private Date date; // now()
	
	/*@Temporal(TemporalType.DATE)
	private Date date_fin_estimated;*/
	
	@ManyToOne
	private User employee; // null lors de la creation

	public Ticket() {
		super();
	}

	public Ticket(int id, String title, String description, int estimatedHours, Status status, Date date,
			User employee) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.estimatedHours = estimatedHours;
		this.status = status;
		this.date = date;
		this.employee = employee;
	}

	public Ticket(String title, String description, int estimatedHours, Status status, Date date, Boolean assignement) {
		super();
		this.title = title;
		this.description = description;
		this.estimatedHours = estimatedHours;
		this.status = status;
		this.date = date;
		this.assignement = assignement;
	}

	public int getId() {
		return id;
	}

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

	public User getEmployee() {
		return employee;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setEmployee(User employee) {
		this.employee = employee;
	}

	public boolean isAssignement() {
		return assignement;
	}

	public void setAssignement(boolean assignement) {
		this.assignement = assignement;
	}
	
	
   
}
