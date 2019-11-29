package tn.esprit.PiDev.entities;
public class EmployeeTimeSheet {

	private User employee;
	private String totalHours;
	private double salary;
	public User getEmployee() {
		return employee;
	}
	public String getTotalHours() {
		return totalHours;
	}
	public double getSalary() {
		return salary;
	}
	public void setEmployee(User employee) {
		this.employee = employee;
	}
	public void setTotalHours(String totalHours) {
		this.totalHours = totalHours;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}
