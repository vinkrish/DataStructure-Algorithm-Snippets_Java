package threading;

public class ThreadName extends Thread {

	public static void main(String args[]) {
		System.out.println(Thread.currentThread().getName());
		
		ThreadName t1 = new ThreadName();
		ThreadName t2 = new ThreadName();

		t1.setName("Vinay");
		t1.start();
		
		t2.setName("Krishna");
		t2.start();
	}

	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

}
