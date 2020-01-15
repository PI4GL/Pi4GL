package tn.esprit.PiDev.Beans;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import tn.esprit.PiDev.Services.TimesheetServicesR;
import tn.esprit.PiDev.Services.UserServices;
import tn.esprit.PiDev.entities.Role;
import tn.esprit.PiDev.entities.Timesheet;
import tn.esprit.PiDev.entities.User;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	private User employe;
	private Boolean loggedIn;

	@EJB
	UserServices employeService;

	@EJB
	TimesheetServicesR timesheetServices;

	public String doLogin() {
		String navigateTo = "null";
		try {
			employe = employeService.login(login, password);
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			sessionMap.put("emp", employe);

			if (employe != null) {
				if (employe.getRole() == Role.Employee) {

					Timesheet timesheet = new Timesheet();
					timesheet.setClock_in(new Date());
					timesheet.setDay(new Date());
					timesheet.setOwner(employe);
					timesheetServices.save(timesheet);

					System.out.println("id user connecté = " + employe.getId());
					
					navigateTo = "/pages/timesheetEmployee?faces-redirect=true";
					loggedIn = true;

				} else if (employe.getRole() == Role.Manager) {
					System.out.println("id user connecté = " + employe.getId());
					navigateTo = "/pages/ticket?faces-redirect=true";
					loggedIn = true;
				}
				else if (employe.getRole() == Role.Former) {
					System.out.println("id user connecté = " + employe.getId());
					navigateTo = "/Formation?faces-redirect=true";
					loggedIn = true;
				}

			}

			else {
				System.out.println("non!");
				FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
			e.printStackTrace();
		}

		return navigateTo;

	}

	public String doLogout() {

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		User owner = (User) sessionMap.get("emp");
		
		if(owner!=null) {
			
			Timesheet timesheet = timesheetServices.getLastShiftsByOwner(owner);
			if(timesheet !=null) {
				timesheet.setClock_out(new Date());
				timesheetServices.update(timesheet);
				
			}
			
			
		}
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";

	}

	// getters +setters + constructeur
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getEmploye() {
		return employe;
	}

	public void setEmploye(User employe) {
		this.employe = employe;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}

}
