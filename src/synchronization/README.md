### Volatile Keyword

Volatile keyword is used to avoid memory consistency errors in multithreaded programs. It tells the compiler to avoid doing any optimizations to the variable. If you mark a variable as volatile, the compiler won’t optimize or reorder instructions around that variable.

Also, The variable’s value will always be read from the main memory instead of temporary registers.

### Locks

#### 1. ReentrantLock

ReentrantLock is a mutually exclusive lock with the same behavior as the intrinsic/implicit lock accessed via the synchronized keyword.

ReentrantLock, as the name suggests, possesses reentrant characteristics. That means a thread that currently owns the lock can acquire it more than once without any problem.

The tryLock() method tries to acquire the lock without pausing the thread. That is, If the thread couldn’t acquire the lock because it was held by some other thread, then It returns immediately instead of waiting for the lock to be released.

You can also specify a timeout in the tryLock() method to wait for the lock to be available -

`lock.tryLock(1, TimeUnit.SECONDS);`

The thread will now pause for one second and wait for the lock to be available. If the lock couldn’t be acquired within 1 second then the thread returns.

#### 2. ReadWriteLock

ReadWriteLock consists of a pair of locks - one for read access and one for write access. The read lock may be held by multiple threads simultaneously as long as the write lock is not held by any thread.

ReadWriteLock allows for an increased level of concurrency. It performs better compared to other locks in applications where there are fewer writes than reads.

#### 3. Atomic Variables

Java’s concurrency api defines several classes in java.util.concurrent.atomic package that support Atomic operations on single variables.

Atomic classes internally use compare-and-swap instructions supported by modern CPUs to achieve synchronization. These instructions are generally much faster than locks.