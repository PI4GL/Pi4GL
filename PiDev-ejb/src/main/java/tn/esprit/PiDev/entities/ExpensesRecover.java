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

public class ExpensesRecover implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEx ;

	private float recoveredExpenses ;
	@Enumerated(EnumType.STRING)
    private Approve approve;
	private float amountCeiling;
	private String feedBacks ;
	private Date meetingDate ;
	
	
	public int getIdEx() {
		return idEx;
	}
	public void setIdEx(int idEx) {
		this.idEx = idEx;
	}
	public Date getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}
	public String getFeedBacks() {
		return feedBacks;
	}
	public void setFeedBacks(String feedBacks) {
		this.feedBacks = feedBacks;
	}
	public float getRecoveredExpenses() {
		return recoveredExpenses;
	}
	public void setRecoveredExpenses(float recoveredExpenses) {
		this.recoveredExpenses = recoveredExpenses;
	}
	public Approve getApprove() {
		return approve;
	}
	public void setApprove(Approve approve) {
		this.approve = approve;
	}
	public float getAmountCeiling() {
		return amountCeiling;
	}
	public void setAmountCeiling(float amountCeiling) {
		this.amountCeiling = amountCeiling;
	}


	public ExpensesRecover(int idEx, float recoveredExpenses, Approve approve, float amountCeiling, String feedBacks,
			Date meetingDate) {
		super();
		this.idEx = idEx;
		this.recoveredExpenses = recoveredExpenses;
		this.approve = approve;
		this.amountCeiling = amountCeiling;
		this.feedBacks = feedBacks;
		this.meetingDate = meetingDate;
	}
	public ExpensesRecover() {
		super();
	}
	

	

}
