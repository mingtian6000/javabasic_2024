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



# advanced
到JVM JMM，操作系统的层面，
## 并发和并行
## atomic operation
## cacheline and false sharing
![img.png](src%2Fmain%2Fresources%2Fimg.png)
一个缓存行可以存储多个变量（存满当前缓存行的字节数）；而CPU对缓存的修改又是以缓存行为最小单位的，
在多线程情况下，如果需要修改“共享同一个缓存行的变量”，就会无意中影响彼此的性能，这就是伪共享（False Sharing）。
false sharing不好因为会降低性能，那怎么办能把X，y分开存储呢？
![img_1.png](src%2Fmain%2Fresources%2Fimg_1.png)

solution：
1.可以使用数据填充的方式来避免伪共享，即单个数据填充满一个CacheLine。这本质是一种空间换时间的做法。
  使得数据能够完整地存储在一个或多个缓存行中，避免数据跨越多个缓存行
2.@sun.misc.Contented  不知道为啥这个注解不好用，总之就推荐padding line

java -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly VolatileDemo --> 汇编，第一个选项干啥的？
--Error: VM option 'PrintAssembly' is diagnostic and must be enabled via -XX:+UnlockDiagnosticVMOptions.
--Error: The unlock option must precede 'PrintAssembly'.

先用javac编译然后再用java生成汇编代码
javac VolatileDemo.java
java -cp . -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly demo.jmm.VolatileDemo >> temp.txt
要装个hsids 不然还是看不到

`volatile` 关键字可以禁止指令进行重排序优化，强制刷回主存 对所有线程可见。但不会保证原子性

查看对象布局：JOL

show bytecode 可以查看到一点东西
javap -v VolatileDemo.class （哪个版本的jdk都有，底层一个工具）

## 关于加锁
最简单的程序：一个整数n，100个线程，每个线程对加1000次，最终结果=100*1000=100000.
