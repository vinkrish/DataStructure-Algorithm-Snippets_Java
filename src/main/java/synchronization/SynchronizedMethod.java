package synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedMethod {

	public static void main(String[] args) throws InterruptedException {
		TableM obj = new TableM();// only one object
		MyThread1M t1 = new MyThread1M(obj);
		MyThread2M t2 = new MyThread2M(obj);
		t1.start();
		t2.start();
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

        for(int i = 0; i < 1000; i++) {
            executorService.submit(() -> synchronizedCounter.increment());
        }

        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println("Final count is : " + synchronizedCounter.getCount());
	}

}

class TableM {
	synchronized void printTable(int n) {// synchronized method
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

class SynchronizedCounter {
    private int count = 0;

    // Synchronized Method 
    public synchronized void increment() {
        count = count + 1;
    }

    public int getCount() {
        return count;
    }
}

class MyThread1M extends Thread {
	TableM t;

	MyThread1M(TableM t) {
		this.t = t;
	}

	public void run() {
		t.printTable(5);
	}

}

class MyThread2M extends Thread {
	TableM t;

	MyThread2M(TableM t) {
		this.t = t;
	}

	public void run() {
		t.printTable(100);
	}
}
