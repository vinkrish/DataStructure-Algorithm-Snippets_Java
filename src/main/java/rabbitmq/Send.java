package rabbitmq;

import java.nio.charset.StandardCharsets;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/*
 * https://www.rabbitmq.com/tutorials/tutorial-one-java.html
 * The connection abstracts the socket connection, and takes care of protocol version negotiation and authentication and so on for us.
 * Declaring a queue is idempotent - it will only be created if it doesn't exist already. 
 * The message content is a byte array, so you can encode whatever you like there.
 */
public class Send {
	
	private final static String QUEUE_NAME = "hello";

	public static void main(String[] args) throws Exception {
		
		ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello nobody!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + message + "'");
        }
        
	}

}
