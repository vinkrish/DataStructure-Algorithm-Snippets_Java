Example RPC will work like this:

- For an RPC request, the Client sends a message with two properties: replyTo, which is set to an anonymous exclusive queue created just for the request, and correlationId, which is set to a unique value for every request.
- The request is sent to an rpc_queue queue.
- The RPC worker (aka: server) is waiting for requests on that queue. When a request appears, it does the job and sends a message with the result back to the Client, using the queue from the replyTo field.
- The client waits for data on the reply queue. When a message appears, it checks the correlationId property. If it matches the value from the request it returns the response to the application.

Server:

- As usual we start by establishing the connection, channel and declaring the queue.
- We might want to run more than one server process. In order to spread the load equally over multiple servers we need to set the prefetchCount setting in channel.basicQos.
- We use basicConsume to access the queue, where we provide a callback in the form of an object (DeliverCallback) that will do the work and send the response back.

Client:

- We establish a connection and channel.
- Our call method makes the actual RPC request.
- Here, we first generate a unique correlationId number and save it - our consumer callback will use this value to match the appropriate response.
- Then, we create a dedicated exclusive queue for the reply and subscribe to it.
- Next, we publish the request message, with two properties: replyTo and correlationId.
- At this point we can sit back and wait until the proper response arrives.
- Since our consumer delivery handling is happening in a separate thread, we're going to need something to suspend the main thread before the response arrives. Usage of BlockingQueue is one possible solutions to do so. Here we are creating ArrayBlockingQueue with capacity set to 1 as we need to wait for only one response.
- The consumer is doing a very simple job, for every consumed response message it checks if the correlationId is the one we're looking for. If so, it puts the response to BlockingQueue.
- At the same time main thread is waiting for response to take it from BlockingQueue.
- Finally we return the response back to the user.