package threading;

public class ThreadSleep extends Thread {

	public static void main(String[] args) {
		ThreadSleep t1 = new ThreadSleep();
		ThreadSleep t2 = new ThreadSleep();

		t1.start();
		t2.start();
	}

	public void run() {
		for (int i = 1; i < 5; i++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println(i);
		}
	}

}
