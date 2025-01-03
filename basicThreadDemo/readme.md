# java concurrent programming 
## process/ thread / co-routines
process是重量级别，操作系统中一个进程，它可以有n多个线程 thread，
进程之间是相互隔离的，每个进程有自己的内存空间和资源。
线程是单独的，每个进程中的线程共享进程的内存空间和资源，thread lightweighted。
co-routine最近出的新概念，类似于thread，但可以看作更轻量级的thread，是受用户调度的，不是操作系统的调度？
go-goroutine
java/python  co-routine？/
感觉这个co-routine理解的不好

## how to create thread in java 
继承yhread，实现runnable，callable
exutor service/future

## thread lifecycle
start（） run（） join(), sleep(), wait(), notify(),terminated()

## how to communicate each other thread?
1. wait
2. notify
3. yield
4. join

## Lock interface and advanced usage:
synchronized 关键字: 直接上锁，对象上锁，代码块上锁，可重入，内允许嵌套
ReentrantLock
1. ReentrantReadWriteLock： 这种锁维护了一对相关的锁，有点像之前的COW容器，适合读多写少，比如缓存
2. StampedLock :新型的读写锁，它在功能上类似于ReentrantReadWriteLock，但提供了更灵活的锁控制机制，能够进一步优化读 - 写场景下的并发性能

## condition interface?
Lock是个接口，condition也是个接口，Condition 接口通常是与 Lock 接口一起使用的，因为它是通过 Lock 对象的 newCondition() 方法来创建的。



## no lock programing and CAS
1. no lock
2. CAS
3. Atomic family 

## Fork/join framework
1.XXX
2. handle concurrent tasks

## completable Futures and async programming
1. chain programming 
2. whats the scenario


## thread pool, executor 







