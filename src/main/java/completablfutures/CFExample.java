package completablfutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CFExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException{
		// runAsync() ---------------------------------------------------------------------
		// Run a task specified by a Runnable Object asynchronously.
		CompletableFuture<Void> future1 = CompletableFuture.runAsync(new Runnable() {
		    @Override
		    public void run() {
		        // Simulate a long-running Job
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        System.out.println("I'll run in a separate thread than the main thread.");
		    }
		});

		// Block and wait for the future to complete
		future1.get();
		
		// Using Lambda Expression
		CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
		    // Simulate a long-running Job   
		    try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		        throw new IllegalStateException(e);
		    }
		    System.out.println("I'll run in a separate thread than the main thread.");
		});
		// --------------------------------------------------------------------------------
		
		// supplyAsync() ------------------------------------------------------------------
		// Run a task specified by a Supplier object asynchronously
		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(new Supplier<String>() {
		    @Override
		    public String get() {
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        return "Result of the asynchronous computation";
		    }
		});

		// Block and get the result of the Future
		String result = future3.get();
		System.out.println(result);
		
		// Using Lambda Expression
		CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		        throw new IllegalStateException(e);
		    }
		    return "Result of the asynchronous computation";
		});
		// --------------------------------------------------------------------------------
		
		// thenApply() --------------------------------------------------------------------
		// Create a CompletableFuture
		CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
		   try {
		       TimeUnit.SECONDS.sleep(1);
		   } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		   }
		   return "Vinay";
		});

		// Attach a callback to the Future using thenApply()
		CompletableFuture<String> greetingFuture = whatsYourNameFuture.thenApply(name -> {
		   return "Hello " + name;
		});
		
		// Block and get the result of the future.
		System.out.println(greetingFuture.get()); // Hello Vinay
		// ---------------------------------------------------------------------------------
		
		// series of thenApply() -----------------------------------------------------------
		CompletableFuture<String> welcomeText = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		    }
		    return "Vinay";
		}).thenApply(name -> {
		    return "Hello " + name;
		}).thenApply(greeting -> {
		    return greeting + ", Welcome to my Blog";
		});

		System.out.println(welcomeText.get());
		// Prints - Hello Vinay, Welcome to my Blog
		// -----------------------------------------------------------------------------------
	}

}
