package synchronization;

public class MethodSynchronization {

	public static void main(String[] args) {
		TableM obj = new TableM();// only one object
		MyThread1M t1 = new MyThread1M(obj);
		MyThread2M t2 = new MyThread2M(obj);
		t1.start();
		t2.start();
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
