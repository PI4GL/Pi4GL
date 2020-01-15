package tn.esprit.PiDev.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Timesheet
 *
 */
@Entity

public class Timesheet implements Serializable {

	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private User owner;
	

	@Temporal(TemporalType.TIME)
	private Date clock_in;
	@Temporal(TemporalType.TIME)
	private Date clock_out;
	
	@Temporal(TemporalType.DATE)
	private Date day;
		
	
		
	
	@ManyToOne
	private Settings settings;

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public User getEmployee() {
		return owner;
	}


	public void setEmployee(User employee) {
		this.owner = employee;
	}
	
	public Settings getSettings() {
		return settings;
	}


	public void setSettings(Settings settings) {
		this.settings = settings;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Timesheet() {
		super();
	}


	public User getOwner() {
		return owner;
	}


	public Date getClock_in() {
		return clock_in;
	}


	public Date getClock_out() {
		return clock_out;
	}


	public Date getDay() {
		return day;
	}


	public void setOwner(User owner) {
		this.owner = owner;
	}


	public void setClock_in(Date clock_in) {
		this.clock_in = clock_in;
	}


	public void setClock_out(Date clock_out) {
		this.clock_out = clock_out;
	}


	public void setDay(Date day) {
		this.day = day;
	}
	
	
   
}
