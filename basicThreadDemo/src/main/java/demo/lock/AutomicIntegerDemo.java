package demo.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AutomicIntegerDemo {

    AtomicInteger cnt= new AtomicInteger(0);
    AtomicMarkableReference ref= new AtomicMarkableReference(1, true); // boolean
    AtomicStampedReference ref1= new AtomicStampedReference(1, 1); // 数值版本号
    void test(){
        for(int i=0; i<1000; i++){
            cnt.incrementAndGet();
            //看源码 并没有synchornized 实现，而是用了cas compare and swap
            //乐观锁，不会阻塞，失败了再试
            //为什么再这种情况下乐观锁可以保证一致性呢？
        }
    }

    public static void main(String[] args) {

    }
}
