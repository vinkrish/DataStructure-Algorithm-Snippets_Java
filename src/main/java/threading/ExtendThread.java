package threading;

public class ExtendThread extends Thread {

	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("Hello..." + i);
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		ExtendThread t = new ExtendThread();
		t.start();
		
		ExtendThread t2 = new ExtendThread();
		t2.start();
	}

}
