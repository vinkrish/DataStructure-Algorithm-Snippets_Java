- A producer is a user application that sends messages
- A queue is a buffer that stores messages
- A consumer is a user application that receives messages

### Exchange

The producer can only send messages to an exchange.

An exchange is a very simple thing. On one side it receives messages from producers and the other side it pushes them to queues. The exchange must know exactly what to do with a message it receives.

Types of exchange:
- direct:  A message goes to the queues whose binding key exactly matches the routing key of the message
- topic: Messages sent to a topic exchange can't have an arbitrary routing_key - it must be a list of words, delimited by dots
- headers: Route a message based on the message headers matching
- fanout: Broadcasts all the messages it receives to all the queues it knows

#### Bindings

A binding is a relationship between an exchange and a queue. This can be simply read as: the queue is interested in messages from this exchange.

Bindings can take an extra `routingKey` parameter. To avoid the confusion with a basic_publish parameter we're going to call it a binding key, in the following example "black" parameter is a binding key.

`channel.queueBind(queueName, EXCHANGE_NAME, "black");`

It is perfectly legal to bind multiple queues with the same binding key. In that case, the direct exchange will behave like fanout and will broadcast the message to all the matching queues.

### Publisher Confirms

Publisher confirms are a RabbitMQ extension to implement reliable publishing. When publisher confirms are enabled on a channel, messages the client publishes are confirmed asynchronously by the broker, meaning they have been taken care of on the server side.