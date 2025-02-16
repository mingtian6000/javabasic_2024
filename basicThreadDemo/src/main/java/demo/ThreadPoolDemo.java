package demo;

public class ThreadPoolDemo {
    // threadpoolexecutor
    // 1. corePoolSize: 核心线程数，线程池中一直存活的线程数
    // 2. maximumPoolSize: 最大线程数，线程池中最大的线程数
    // 3. keepAliveTime: 线程存活时间，超过核心线程数的线程在空闲时的存活时间
    // 4. unit: 时间单位
    // 5. workQueue: 阻塞队列，存放任务的队列
    // 6. threadFactory: 线程工厂，用于创建线程
    // 7. handler: 拒绝策略，当任务太多来不及处理时，如何拒绝任务
    // 8. 线程池的状态：RUNNING、SHUTDOWN、STOP、TERMINATED
    // 9. 线程池的执行流程：线程池创建 -> 线程池初始化 -> 线程池运行 -> 线程池关闭
    // 10. 线程池的关闭流程：线程池状态设置 -> 中断所有线程 -> 释放资源
    // 11. 线程池的拒绝策略：AbortPolicy、CallerRunsPolicy、DiscardOldestPolicy、DiscardPolicy
    // 12. 线程池的工作队列：SynchronousQueue、LinkedBlockingQueue、ArrayBlockingQueue、PriorityBlockingQueue
    // 13. 线程池的工作队列的选择：SynchronousQueue、LinkedBlockingQueue、ArrayBlockingQueue、PriorityBlockingQueue
    // 14. 线程池的工作队列的拒绝策略：AbortPolicy、CallerRunsPolicy、DiscardOldestPolicy、DiscardPolicy


}
