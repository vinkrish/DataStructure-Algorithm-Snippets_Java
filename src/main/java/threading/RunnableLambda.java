package threading;

public class RunnableLambda {

	public static void main(String[] args) {
		System.out.println("Inside : " + Thread.currentThread().getName());
		
		System.out.println("Creating Runnable...");
        Runnable runnable = () -> System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating Thread...");
        Thread thread = new Thread(runnable);

        System.out.println("Starting Thread...");
        thread.start();
        
        System.out.println("Creating Another Thread...");
        Thread thread2 = new Thread(() -> System.out.println("Inside : " + Thread.currentThread().getName()));
        
        System.out.println("Starting Another Thread...");
        thread2.start();
	}

}
