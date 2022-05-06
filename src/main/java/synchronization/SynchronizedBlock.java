package synchronization;

public class SynchronizedBlock {
	
	private int count = 0; 

	public static void main(String[] args) {
		
		SynchronizedBlock sb = new SynchronizedBlock();
		sb.dowork();
		
		TableB obj = new TableB();// only one object
		MyThread1B t1 = new MyThread1B(obj);
		MyThread2B t2 = new MyThread2B(obj);
		t1.start();
		t2.start();
	}
	
	public synchronized void increment() {
		count++;
	}
	
	public void dowork() {
		Thread t1 = new Thread(() -> {
			for(int i=0; i< 10000; i++) increment();
		});
		
		Thread t2 = new Thread(() -> {
			for(int i=0; i< 10000; i++) increment();
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(count);
		
	}

}

class TableB {

	void printTable(int n) {
		// Acquire Lock
		synchronized (this) { // synchronized block
			for (int i = 1; i <= 5; i++) {
				System.out.println(n * i);
				try {
					Thread.sleep(400);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}
	// Release Lock
}

class MyThread1B extends Thread {
	TableB t;

	MyThread1B(TableB t) {
		this.t = t;
	}

	public void run() {
		t.printTable(5);
	}

}

class MyThread2B extends Thread {
	TableB t;

	MyThread2B(TableB t) {
		this.t = t;
	}

	public void run() {
		t.printTable(100);
	}
}
