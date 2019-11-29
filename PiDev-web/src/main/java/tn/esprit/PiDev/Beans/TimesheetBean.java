package tn.esprit.PiDev.Beans;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import tn.esprit.PiDev.Services.TimesheetServicesR;
import tn.esprit.PiDev.entities.Settings;
import tn.esprit.PiDev.entities.Timesheet;
import tn.esprit.PiDev.entities.User;

@ManagedBean
public class TimesheetBean {

	@EJB
	TimesheetServicesR timesheetServices;

	// user connecté
	// private User employe;

	private Date clock_in;
	private Date clock_out;
	private String day;
	private Settings settings;

	private List<Timesheet> les_shifts;

	private int totalHoursDay;
	private int totalHoursWeek;
	private int totalHoursMonth;
	private double salary;
	private boolean pointage;

	@PostConstruct
	public void getShiftsByEmployee() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		User emp = (User) sessionMap.get("emp");
		les_shifts = timesheetServices.getShiftsByOwner(emp);

	}

	public String totalHoursDay(Timesheet timesheet) {
		// totalHoursDay= ((timesheet.getClock_out()-timesheet.h) % 1)*24 -
		// settings.getBreakTime_hours();
		if (timesheet.getClock_out() == null) {
			return "";
		} else {
			long diff = timesheet.getClock_out().getTime() - timesheet.getClock_in().getTime();// as given

			// long hours = TimeUnit.MILLISECONDS.toHours(diff);
			long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);

			long hours = minutes / 60;

			minutes = minutes % 60;

			return hours + ":" + minutes;
		}
	}
	public String redirectToWorkSapace()
	{
	
		return  "/pages/workspace?faces-redirect=true";
	}


	public void TotalHoursWeek() {

	}

	public void TotalHoursMonth() {

	}

	public void detectedRecords() {

	}

	public void ClockInAction() {

	}

	public void ClockOutAction() {

	}

	public void calculateSalary() {

	}

	public void generatePdf() {

	}

	// ** getter and setters

	public TimesheetServicesR getTimesheetServices() {
		return timesheetServices;
	}

	public List<Timesheet> getLes_shifts() {
		return les_shifts;
	}

	public void setTimesheetServices(TimesheetServicesR timesheetServices) {
		this.timesheetServices = timesheetServices;
	}

	public void setLes_shifts(List<Timesheet> les_shifts) {
		this.les_shifts = les_shifts;
	}

	public Date getClock_in() {
		return clock_in;
	}

	public Date getClock_out() {
		return clock_out;
	}

	public String getDay() {
		return day;
	}

	public Settings getSettings() {
		return settings;
	}

	public void setClock_in(Date clock_in) {
		this.clock_in = clock_in;
	}

	public void setClock_out(Date clock_out) {
		this.clock_out = clock_out;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	public boolean isPointage() {
		return pointage;
	}

	public void setPointage(boolean pointage) {
		this.pointage = pointage;
	}

	public int getTotalHoursDay() {
		return totalHoursDay;
	}

	public int getTotalHoursWeek() {
		return totalHoursWeek;
	}

	public int getTotalHoursMonth() {
		return totalHoursMonth;
	}

	public void setTotalHoursDay(int totalHoursDay) {
		this.totalHoursDay = totalHoursDay;
	}

	public void setTotalHoursWeek(int totalHoursWeek) {
		this.totalHoursWeek = totalHoursWeek;
	}

	public void setTotalHoursMonth(int totalHoursMonth) {
		this.totalHoursMonth = totalHoursMonth;
	}

}
