package tn.esprit.PiDev.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Settings
 *
 */
@Entity

public class Settings implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private double regularRate=0.0;
	private double overtimeRate=0.0;
	private double doubleOvertimeRate=0.0;
	
	private int dailyLimit_minutes;
	private int dailyLimit_hours;
	
	private int weeklyLimit_minutes;
	private int weeklyLimit_hours;
	
	private int breakTime_minutes;
	private int breakTime_hours;
	
	
	
	public Settings() {
		super();
	}








	public Settings(int id, double regularRate, double overtimeRate, double doubleOvertimeRate, int dailyLimit_minutes,
			int dailyLimit_hours, int weeklyLimit_minutes, int weeklyLimit_hours, int breakTime_minutes,
			int breakTime_hours) {
		super();
		this.id = id;
		this.regularRate = regularRate;
		this.overtimeRate = overtimeRate;
		this.doubleOvertimeRate = doubleOvertimeRate;
		this.dailyLimit_minutes = dailyLimit_minutes;
		this.dailyLimit_hours = dailyLimit_hours;
		this.weeklyLimit_minutes = weeklyLimit_minutes;
		this.weeklyLimit_hours = weeklyLimit_hours;
		this.breakTime_minutes = breakTime_minutes;
		this.breakTime_hours = breakTime_hours;
	}








	public Settings(double regularRate, double overtimeRate, double doubleOvertimeRate, int dailyLimit_minutes,
			int dailyLimit_hours, int weeklyLimit_minutes, int weeklyLimit_hours, int breakTime_minutes,
			int breakTime_hours) {
		super();
		this.regularRate = regularRate;
		this.overtimeRate = overtimeRate;
		this.doubleOvertimeRate = doubleOvertimeRate;
		this.dailyLimit_minutes = dailyLimit_minutes;
		this.dailyLimit_hours = dailyLimit_hours;
		this.weeklyLimit_minutes = weeklyLimit_minutes;
		this.weeklyLimit_hours = weeklyLimit_hours;
		this.breakTime_minutes = breakTime_minutes;
		this.breakTime_hours = breakTime_hours;
	}








	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public int getBreakTime_minutes() {
		return breakTime_minutes;
	}







	public int getBreakTime_hours() {
		return breakTime_hours;
	}







	public void setBreakTime_minutes(int breakTime_minutes) {
		this.breakTime_minutes = breakTime_minutes;
	}







	public void setBreakTime_hours(int breakTime_hours) {
		this.breakTime_hours = breakTime_hours;
	}







	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public double getRegularRate() {
		return regularRate;
	}



	public void setRegularRate(double regularRate) {
		this.regularRate = regularRate;
	}



	public double getOvertimeRate() {
		return overtimeRate;
	}



	public void setOvertimeRate(double overtimeRate) {
		this.overtimeRate = overtimeRate;
	}



	public double getDoubleOvertimeRate() {
		return doubleOvertimeRate;
	}



	public void setDoubleOvertimeRate(double doubleOvertimeRate) {
		this.doubleOvertimeRate = doubleOvertimeRate;
	}








	public int getDailyLimit_minutes() {
		return dailyLimit_minutes;
	}








	public int getDailyLimit_hours() {
		return dailyLimit_hours;
	}








	public int getWeeklyLimit_minutes() {
		return weeklyLimit_minutes;
	}








	public int getWeeklyLimit_hours() {
		return weeklyLimit_hours;
	}








	public void setDailyLimit_minutes(int dailyLimit_minutes) {
		this.dailyLimit_minutes = dailyLimit_minutes;
	}








	public void setDailyLimit_hours(int dailyLimit_hours) {
		this.dailyLimit_hours = dailyLimit_hours;
	}








	public void setWeeklyLimit_minutes(int weeklyLimit_minutes) {
		this.weeklyLimit_minutes = weeklyLimit_minutes;
	}








	public void setWeeklyLimit_hours(int weeklyLimit_hours) {
		this.weeklyLimit_hours = weeklyLimit_hours;
	}



	
	
}
