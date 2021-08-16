package threading;

public class RunnableInner {
	public static void main(String[] args) {
		System.out.println("Inside : " + Thread.currentThread().getName());
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Inside : " + Thread.currentThread().getName());
			}
		};
		
		new Thread(r).start();
	}
}
