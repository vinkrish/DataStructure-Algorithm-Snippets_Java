package threading;

public class RunnableImpl implements Runnable {

	public static void main(String[] args) {
		System.out.println("thread is running...");  
	}

	@Override
	public void run() {
		RunnableImpl R = new RunnableImpl();  
		Thread t = new Thread(R);  
		t.start();  
	}

}
