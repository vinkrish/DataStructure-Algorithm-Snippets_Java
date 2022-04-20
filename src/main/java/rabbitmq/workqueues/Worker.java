package rabbitmq.workqueues;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/*
 * RabbitMQ will send each message to the next consumer, in sequence. 
 * On average every consumer will get the same number of messages. This way of distributing messages is called round-robin.
 * 
 * int prefetchCount = 1;
 * channel.basicQos(prefetchCount);
 * This tells RabbitMQ not to give more than one message to a worker at a time. 
 * Or, in other words, don't dispatch a new message to a worker until it has processed and acknowledged the previous one. 
 * Instead, it will dispatch it to the next worker that is not still busy.
 */
public class Worker {
	
	private static final String TASK_QUEUE_NAME = "task_queue";

	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        channel.basicQos(1); // accept only one unack-ed message at a time

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");

            System.out.println(" [x] Received '" + message + "'");
            try {
                doWork(message);
            } finally {
                System.out.println(" [x] Done");
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }
        };
        channel.basicConsume(TASK_QUEUE_NAME, false, deliverCallback, consumerTag -> { });
	}
	
	private static void doWork(String task) {
        for (char ch : task.toCharArray()) {
            if (ch == '.') {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException _ignored) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

}
