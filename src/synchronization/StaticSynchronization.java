package synchronization;

public class StaticSynchronization {

	public static void main(String[] args) {
		MyThread1S t1=new MyThread1S();  
		MyThread2S t2=new MyThread2S();  
		MyThread3S t3=new MyThread3S();  
		MyThread4S t4=new MyThread4S();  
		t1.start();  
		t2.start();  
		t3.start();  
		t4.start();  
	}

}

class TableS {

	synchronized static void printTable(int n) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
			}
		}
	}
}

class MyThread1S extends Thread {
	public void run() {
		TableS.printTable(1);
	}
}

class MyThread2S extends Thread {
	public void run() {
		TableS.printTable(10);
	}
}

class MyThread3S extends Thread {
	public void run() {
		TableS.printTable(100);
	}
}

class MyThread4S extends Thread {
	public void run() {
		TableS.printTable(1000);
	}
}