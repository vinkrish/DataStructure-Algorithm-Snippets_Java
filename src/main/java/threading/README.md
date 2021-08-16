### Concurrency

It is the ability to do more than one thing at the same time.

In a single CPU machine, the tasks are executed in interleaved manner - The operating system switches between the tasks so frequently that it appears to the users that they are executed at the same physical instant.

Therefore, Concurrency does not mean Parallelism.

### Unit of Concurrency

- **Multiprocessing** - Multiple Processors/CPUs executing concurrently. The unit of concurrency here is a CPU.
- **Multitasking** - Multiple tasks/processes running concurrently on a single CPU. The operating system executes these tasks by switching between them very frequently. The unit of concurrency, in this case, is a Process.
- **Multithreading** - Multiple parts of the same program running concurrently. In this case, we go a step further and divide the same program into multiple parts/threads and run those threads concurrently.

### Processes and Threads
Let’s talk about the two basic units of concurrency : Processes and Threads.

#### Process
A Process is a program in execution. It has its own address space, a call stack, and link to any resources such as open files.

A computer system normally has multiple processes running at a time. The operating system keeps track of all these processes and facilitates their execution by sharing the processing time of the CPU among them.

#### Thread
A thread is a path of execution within a process. Every process has at least one thread - called the main thread. The main thread can create additional threads within the process.

Threads within a process share the process’s resources including memory and open files. However, every thread has its own call stack.

Since threads share the same address space of the process, creating new threads and communicating between them is more efficient.

### Common Problems associated with Concurrency

Concurrency greatly improves the throughput of computers by increasing CPU utilization. But with great performance comes few issues -

#### 1. Thread interference errors (Race Conditions)
Thread interference errors occur when multiple threads try to read and write a shared variable concurrently, and these read and write operations overlap in execution.

In this case, the final result depends on the order in which the reads and writes take place, which is unpredictable. This makes thread interference errors difficult to detect and fix.

Thread interference errors can be avoided by ensuring that only one thread can access a shared resource at a time. This is usually done by acquiring a mutually exclusive lock before accessing any shared resource.

The concept of acquiring a lock before accessing any shared resource can lead to other problems like **deadlock** and **starvation**.

#### 2. Memory consistency errors
Memory consistency errors occur when different threads have inconsistent views of the same data. This happens when one thread updates some shared data, but this update is not propagated to other threads, and they end up using the old data.

### There are two ways to create a thread in Java

1. By extending Thread class
2. By providing a Runnable object

### Runnable or Thread, Which one to use?

The first method, where you create a thread by extending from Thread class is very limited because once you extend your class from Thread, you cannot extend from any other class since Java doesn’t allow multiple inheritance.

Also, If you follow good design practice, Inheritance is meant for extending the functionality of the parent class, but when you create a thread, you don’t extend the functionality of Thread class, you merely provide the implementation of run() method.

So, In general, You should always use Runnable object to create a thread. This method is more flexible. It allows your class to extend from any other class.

### Executors Framework

It makes sense to separate thread creation and management from the rest of the application.

Enter Executors, A framework for creating and managing threads. Executors framework helps you with -

1. **Thread Creation**: It provides various methods for creating threads, more specifically a pool of threads, that your application can use to run tasks concurrently.

2. **Thread Management**: It manages the life cycle of the threads in the thread pool. You don’t need to worry about whether the threads in the thread pool are active or busy or dead before submitting a task for execution.

3. **Task submission and execution:** Executors framework provides methods for submitting tasks for execution in the thread pool, and also gives you the power to decide when the tasks will be executed. For example, You can submit a task to be executed now or schedule them to be executed later or make them execute periodically.

Java Concurrency API defines the following three executor interfaces that covers everything that is needed for creating and managing threads -

- **Executor** - A simple interface that contains a method called execute() to launch a task specified by a Runnable object.
- **ExecutorService** - A sub-interface of Executor that adds functionality to manage the lifecycle of the tasks. It also provides a submit() method whose overloaded versions can accept a Runnable as well as a Callable object. Callable objects are similar to Runnable except that the task specified by a Callable object can also return a value. We’ll learn about Callable in more detail, in the next blog post.
- **ScheduledExecutorService** - A sub-interface of ExecutorService. It adds functionality to schedule the execution of the tasks.

Apart from the above three interfaces, The API also provides an Executors class that contains factory methods for creating different kinds of executor services.

### Thread Pool

Most of the executor implementations use thread pools to execute tasks. A thread pool is nothing but a bunch of worker threads that exist separately from the `Runnable or Callable` tasks and is managed by the executor.

Creating a thread is an expensive operation and it should be minimized. Having worker threads minimizes the overhead due to thread creation because executor service has to create the thread pool only once and then it can reuse the threads for executing any task.

Tasks are submitted to a thread pool via an internal queue called the **Blocking Queue**. If there are more tasks than the number of active threads, they are inserted into the blocking queue for waiting until any thread becomes available. If the blocking queue is full than new tasks are rejected.

### Callable

**What if you want to return a result from your tasks?**

Well, Java provides a `Callable` interface to define tasks that return a result. A Callable is similar to `Runnable` except that it can return a result and throw a checked exception.

Note that with Callable, you don’t need to surround `Thread.sleep()` by a `try/catch` block, because unlike Runnable, a Callable can throw a checked exception.

#### Executing Callable tasks using ExecutorService and obtaining the result using Future

Just like `Runnable`, you can submit a `Callable` to an executor service for execution. But what about the Callable’s result? How do you access it?

The `submit()` method of executor service submits the task for execution by a thread. However, it doesn’t know when the result of the submitted task will be available. Therefore, it returns a special type of value called a Future which can be used to fetch the result of the task when it is available.

The concept of `Future` is similar to Promise in other languages like Javascript. It represents the result of a computation that will be completed at a later point of time in future.

### invokeAll

> Submit multiple tasks and wait for all of them to complete.

You can execute multiple tasks by passing a collection of Callables to the `invokeAll()` method.

The invokeAll() returns a list of Futures. Any call to future.get() will block until all the Futures are complete.

### invokeAny

> Submit multiple tasks and wait for any one of them to complete

The `invokeAny()` method accepts a collection of Callables and returns the result of the fastest Callable. Note that, it does not return a Future.