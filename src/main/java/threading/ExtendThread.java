package threading;

public class ExtendThread extends Thread {

	public void run() {
		System.out.println("thread is running...");
	}

	public static void main(String args[]) {
		ExtendThread t = new ExtendThread();
		t.start();
	}

}
