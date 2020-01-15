package tn.esprit.PiDev.Beans;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import tn.esprit.PiDev.Services.SettingsServicesR;
import tn.esprit.PiDev.Services.TimesheetServicesR;
import tn.esprit.PiDev.Services.UserServices;
import tn.esprit.PiDev.entities.EmployeeTimeSheet;
import tn.esprit.PiDev.entities.Settings;
import tn.esprit.PiDev.entities.Timesheet;
import tn.esprit.PiDev.entities.User;

@ManagedBean
@ViewScoped
public class TimesheetManager {

	@EJB
	private UserServices userServices;
	@EJB
	private TimesheetServicesR timesheetServicesR;
	
	@EJB
	private SettingsServicesR settingsServicesR;

	private List<EmployeeTimeSheet> list = new ArrayList<>();

	@PostConstruct
	public void init() {

		List<User> liUsers = userServices.getAllEmploye();

		for (User user : liUsers) {
			System.out.println(user.getCin());
			Calendar calendar = Calendar.getInstance();
			int month = calendar.get(Calendar.MONTH);
			System.out.println(month);
			EmployeeTimeSheet empSheet = new EmployeeTimeSheet();
			empSheet.setEmployee(user);

			List<Timesheet> timesheets = timesheetServicesR.getShiftsByOwner(user, month + 1);
			long diff = 0;
			for (Timesheet timesheet : timesheets) {
				if (timesheet.getClock_out() != null)
					diff += timesheet.getClock_out().getTime() - timesheet.getClock_in().getTime();

			}

			// long hours = TimeUnit.MILLISECONDS.toHours(diff);
			long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);

			long hours = minutes / 60;

			minutes = minutes % 60;

			empSheet.setTotalHours(hours + ":" + minutes);

			
			Settings settings = settingsServicesR.getSettings();
			double result = 0;
			if(hours<=60) {
				
				result = hours * settings.getRegularRate();
				double priceMin = settings.getRegularRate()/60;
				result+= priceMin* minutes;
			}else if (hours>60 && hours<=100) {
				int overTime =(int) hours - 60;
				result  = 60  * settings.getRegularRate();
				result += overTime * settings.getOvertimeRate(); 
				double priceMin = settings.getOvertimeRate()/60;
				result+= priceMin* minutes;
			}else if (hours>100) {
				result  = 60  * settings.getRegularRate();
				result += 40 * settings.getOvertimeRate(); 
				int doubleOverTime = (int) hours - 100;
				result += doubleOverTime * settings.getDoubleOvertimeRate();
				
				double priceMin = settings.getDoubleOvertimeRate()/60;
				result+= priceMin* minutes;
			}
		
			
			
			
			empSheet.setSalary(result);
			list.add(empSheet);
		}

	}

	public List<EmployeeTimeSheet> getList() {
		return list;
	}

	public void setList(List<EmployeeTimeSheet> list) {
		this.list = list;
	}

}
