package tn.esprit.PiDev.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Demande implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDe;
	
	private float expenses ;
	
	@Enumerated(EnumType.STRING)
    private Status status;
	private Date reservationDate ; 
	private String ticketImg ;
	private String description;
	private String missionAdress;
	private float otherExpenses;
	
	
	
	public int getIdDe() {
		return idDe;
	}
	public void setIdDe(int idDe) {
		this.idDe = idDe;
	}
	public float getExpenses() {
		return expenses;
	}
	public void setExpenses(float expenses) {
		this.expenses = expenses;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public String getTicketImg() {
		return ticketImg;
	}
	public void setTicketImg(String ticketImg) {
		this.ticketImg = ticketImg;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMissionAdress() {
		return missionAdress;
	}
	public void setMissionAdress(String missionAdress) {
		this.missionAdress = missionAdress;
	}
	public float getOtherExpenses() {
		return otherExpenses;
	}
	public void setOtherExpenses(float otherExpenses) {
		this.otherExpenses = otherExpenses;
	}
	

	public Demande(int idDe, float expenses, Status status, Date reservationDate, String ticketImg, String description,
			String missionAdress, float otherExpenses) {
		super();
		this.idDe = idDe;
		this.expenses = expenses;
		this.status = status;
		this.reservationDate = reservationDate;
		this.ticketImg = ticketImg;
		this.description = description;
		this.missionAdress = missionAdress;
		this.otherExpenses = otherExpenses;
	}
	public Demande() {
		super();
	}
	
	
	
	

	
	
}
