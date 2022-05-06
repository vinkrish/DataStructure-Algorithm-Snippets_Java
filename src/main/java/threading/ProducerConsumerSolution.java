package threading;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * https://www.java67.com/2012/12/producer-Consumer-problem-with-wait-and-notify-example.html
 */
public class ProducerConsumerSolution {

	public static void main(String[] args) {
		Vector<Integer> sharedQueue = new Vector<>();
        int size = 4;
        Thread prodThread = new Thread(new Producer2(sharedQueue, size), "Producer");
        Thread consThread = new Thread(new Consumer2(sharedQueue, size), "Consumer");
        prodThread.start();
        consThread.start();
	}

}

class Producer2 implements Runnable {

    private final Vector<Integer> sharedQueue;
    private final int SIZE;

    public Producer2(Vector<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            System.out.println("Produced: " + i);
            try {
                produce(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer2.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void produce(int i) throws InterruptedException {

        //wait if the queue is full
        while (sharedQueue.size() == SIZE) {
            synchronized (sharedQueue) {
                System.out.println("The queue is full " + Thread.currentThread().getName()
                                    + " is waiting , size: " + sharedQueue.size());

                sharedQueue.wait();
            }
        }

        //producing element and notify consumers
        synchronized (sharedQueue) {
            sharedQueue.add(i);
            sharedQueue.notifyAll();
        }
    }
}

class Consumer2 implements Runnable {

    private final Vector<Integer> sharedQueue;
    private final int SIZE;

    public Consumer2(Vector<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + consume());
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer2.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private int consume() throws InterruptedException {
        //wait if the queue is empty
        while (sharedQueue.isEmpty()) {
            synchronized (sharedQueue) {
                System.out.println("The queue is empty " + Thread.currentThread().getName()
                                    + " is waiting , size: " + sharedQueue.size());

                sharedQueue.wait();
            }
        }

        //Otherwise consume element and notify the waiting producer
        synchronized (sharedQueue) {
            sharedQueue.notifyAll();
            return (Integer) sharedQueue.remove(0);
        }
    }
}
