package synchronization;

public class SynchronizedBlock {

	public static void main(String[] args) {
		TableB obj = new TableB();// only one object
		MyThread1B t1 = new MyThread1B(obj);
		MyThread2B t2 = new MyThread2B(obj);
		t1.start();
		t2.start();
	}

}

class TableB {

	void printTable(int n) {
		synchronized (this) {// synchronized block
			for (int i = 1; i <= 5; i++) {
				System.out.println(n * i);
				try {
					Thread.sleep(400);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}// end of the method
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
