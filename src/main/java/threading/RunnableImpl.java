package threading;

public class RunnableImpl implements Runnable {

	public static void main(String[] args) {
		System.out.println("Inside : " + Thread.currentThread().getName());
		
		System.out.println("Creating Runnable...");
		RunnableImpl R = new RunnableImpl();
		
		System.out.println("Creating Thread...");
		Thread t = new Thread(R);
		
		System.out.println("Starting Thread...");
		t.start();
	}

	@Override
	public void run() {
		System.out.println("Inside : " + Thread.currentThread().getName());
	}

}
