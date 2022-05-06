package synchronization;

import java.util.Scanner;

public class VolatileTest {

	public static void main(String[] args) {
		Processor p = new Processor();
		
		p.start();
		
		System.out.println("Press return to stop.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		p.shutdown();
	}

}

class Processor extends Thread {
	
	private volatile boolean running = true;
	
	public void run() {
		while(running) {
			System.out.println("Hello...");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void shutdown() {
		running = false;
	}
	
}
