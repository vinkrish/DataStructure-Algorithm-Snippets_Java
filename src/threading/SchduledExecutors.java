package threading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchduledExecutors {

	public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable task1 = () -> {
          System.out.println("Executing Task1 At " + System.nanoTime());
        };

        System.out.println("Submitting task at " + System.nanoTime() + " to be executed after 5 seconds.");
        scheduledExecutorService.schedule(task1, 5, TimeUnit.SECONDS);
        
        Runnable task2 = () -> {
        	System.out.println("Executing Task2 At " + System.nanoTime());
	    };
	      
	    System.out.println("scheduling task to be executed every 2 seconds with an initial delay of 0 seconds");
	    scheduledExecutorService.scheduleAtFixedRate(task2, 0,2, TimeUnit.SECONDS);
	      
	    // scheduledExecutorService.shutdown();
    }

}
