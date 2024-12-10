package java8;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackExample {
    public static void main(String[] args) {
        AsyncTask asyncTask = new AsyncTask();

        // Execute the task with a custom callback
        asyncTask.executeTask("MyInputData", (result, exception) -> {
            if (exception == null) {
                // Handle success
                System.out.println("Task completed successfully: " + result);
            } else {
                // Handle failure
                System.err.println("Task failed with exception: " + exception.getMessage());
                exception.printStackTrace();
            }
        });

        // Optional: Shutdown the executor
        asyncTask.shutdown();
    }
}

class AsyncTask {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public void executeTask(String input, Callback<String> callback) {
        executor.submit(() -> {
            try {
                // Simulate a time-consuming task
                System.out.println("Task started on thread: " + Thread.currentThread().getName());
                Thread.sleep(2000);

                // Simulate success result
                String result = "Processed: " + input;
                callback.onComplete(result, null);
            } catch (Exception e) {
                // Handle failure
                callback.onComplete(null, e);
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}

@FunctionalInterface
interface Callback<T> {
    void onComplete(T result, Exception exception);
}

