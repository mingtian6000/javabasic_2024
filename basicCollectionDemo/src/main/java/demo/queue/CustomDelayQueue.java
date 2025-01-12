package demo.queue;

import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class CustomDelayQueue {
    private static DelayQueue delayQueue = new DelayQueue();
    public static void main(String[] args) throws InterruptedException {
        //System.out.println(delayQueue.remainingCapacity()); INT_MAX
        producer();
        consumer();
    }

    private static void consumer() {
        System.out.println(DateFormat.getDateInstance().format(new Date())+" : comsumer start");
        while (!delayQueue.isEmpty()) {
            try {
                MyDelay myDelay = (MyDelay) delayQueue.take();
                System.out.println(DateFormat.getDateInstance().format(new Date())+" : "+ myDelay.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(DateFormat.getDateInstance().format(new Date())+" : comsumer end");
    }

    private static void producer() {
        delayQueue.put(new MyDelay(1000, "message1"));
        delayQueue.put(new MyDelay(6000, "message2"));

        delayQueue.put(new MyDelay(3000, "message3"));
        delayQueue.put(new MyDelay(12000, "message4"));
    }

}
class MyDelay implements Delayed {
    long delayTime = System.currentTimeMillis();

    public String getMsg() {
        return msg;
    }

    private String msg;

    //Returns the remaining delay associated with this object, in the given time unit.
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(delayTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }
    public MyDelay(long delayTime, String msg) {
        this.delayTime = (this.delayTime + delayTime);
        this.msg = msg;
    }
    @Override
    public int compareTo(Delayed o) { //剩余时间越少越先出去
        if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
            return 1;
        } else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
            return -1;
        } else {
            return 0;
        }
    }
}