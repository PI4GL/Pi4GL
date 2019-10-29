package tn.esprit.PiDev.Remotes;

import javax.ejb.Remote;

import tn.esprit.PiDev.entities.Task;

@Remote
public interface TasksRemote {
	public void addTask(Task t);
	public void updateTask(Task t);
	public void deleteTask(int idT);

}
