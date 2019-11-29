package tn.esprit.PiDev.Services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.PiDev.Remotes.TimesheetServicesRRemote;
import tn.esprit.PiDev.entities.Timesheet;
import tn.esprit.PiDev.entities.User;

@Stateless
@LocalBean
public class TimesheetServicesR implements TimesheetServicesRRemote {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Timesheet> getShiftsByOwner(User owner) {
		List<Timesheet> shifts = new ArrayList<>();
		List<Timesheet> shifts2 = new ArrayList<>();
		List<Timesheet> finalShift = new ArrayList<>();
		Query query = em.createQuery("select t from Timesheet t where t.owner=:owner Group By t.day order by t.id ASC")
				.setParameter("owner", owner);

		// Query query = em.createNativeQuery("select * from timesheet where
		// owner_id=1");
		// query.setParameter("owner", owner);
		try {
			shifts = query.getResultList();

			for (Timesheet t1 : shifts) {

				Query query2 = em
						.createQuery("select t from Timesheet t where t.owner=:owner and t.day=:day order by t.id DESC")
						.setParameter("owner", owner).setParameter("day", t1.getDay());
				shifts2 = query2.getResultList();

				Timesheet t2 = new Timesheet();
				if (shifts2.size() > 1) {
//					if (shifts2.get(1) == null) {
//						t2 = shifts2.get(1);
//					} else {
//						t2 = shifts2.get(0);
//					}

					for (Timesheet time : shifts2) {
						if (time.getClock_out() != null) {
							t2.setClock_out(time.getClock_out());
							break;
						}
					}

				} else {
					t2 = shifts2.get(0);
				}

				Timesheet timesheet = new Timesheet();
				timesheet.setClock_in(t1.getClock_in());
				timesheet.setClock_out(t2.getClock_out());
				timesheet.setEmployee(t1.getEmployee());
				timesheet.setDay(t1.getDay());
				finalShift.add(timesheet);

			}

			System.out.println("hello from shifts!!!");
			System.out.println(shifts.size());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur : " + e);
		}
		return finalShift;
	}
	public List<Timesheet> getShiftsByOwner(User owner, int month) {
		List<Timesheet> shifts = new ArrayList<>();
	
		Query query = em
				.createQuery(
						"select t from Timesheet t where t.owner=:owner and MONTH(t.day)= :month ")
				.setParameter("owner", owner).setParameter("month", month);

		

		try {
			shifts = query.getResultList();
			
		
			
		
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur : " + e);
		}
		return shifts;
	}

	public Timesheet getLastShiftsByOwner(User owner) {
		List<Timesheet> shifts = new ArrayList<>();
		Query query = em.createQuery("select t from Timesheet t where t.owner=:owner ORDER BY  t.id DESC")
				.setParameter("owner", owner);
		// Query query = em.createNativeQuery("select * from timesheet where
		// owner_id=1");
		// query.setParameter("owner", owner);
		try {
			shifts = query.getResultList();
			Timesheet timesheet = shifts.get(0);
			System.out.println("hello from shifts!!!");
			System.out.println(shifts.size());
			return timesheet;
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return null;
	}

	public void save(Timesheet timesheet) {
		em.persist(timesheet);
	}

	public void update(Timesheet timesheet) {
		em.merge(timesheet);

	}
}



