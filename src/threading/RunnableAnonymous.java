package threading;

public class RunnableAnonymous {
	
	public static void main(String[] args) {
		System.out.println("Inside : " + Thread.currentThread().getName());
		
		new Thread(new Runnable() {
			@Override
            public void run() {
                System.out.println("Inside : " + Thread.currentThread().getName());
            }
		}).start();
		
	}

}
