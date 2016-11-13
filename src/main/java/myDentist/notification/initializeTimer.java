package myDentist.notification;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;

public class initializeTimer {

	 public void init() throws SchedulerException {
	     System.out.println("I am running first here---!");
	     
	     SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

	     Scheduler sched = schedFact.getScheduler();

	     sched.start();
	     
	  }
}
