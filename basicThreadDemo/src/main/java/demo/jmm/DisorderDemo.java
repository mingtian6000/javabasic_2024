package demo.jmm;

import java.util.concurrent.CountDownLatch;

public class DisorderDemo {
    private static int x=0, y=0;
    private static int a=0, b=0;

    public static void main(String[] args) {
        for(long i=0; i<Long.MAX_VALUE; i++){
            x=0;
            y=0;
            a=0;
            b=0;
            CountDownLatch latch = new CountDownLatch(2);
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    a=1;
                    x=b;
                    latch.countDown();
                }
            });

            Thread other = new Thread(new Runnable() {
                @Override
                public void run() {
                    b=1;
                    y=a;
                    latch.countDown();
                }
            });

            one.start();
            other.start();
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("第"+i+"次("+x+","+y+")");
            if(x==0 && y==0){ //发生乱序 为啥能出来？ 因为x=0,y=0是乱序的结果
                // 为什么会出现这种情况呢？因为线程one和线程other之间没有数据依赖关系，所以可能会出现指令重排
                System.out.println("第"+i+"次("+x+","+y+")");
                break;
            }

        }
    }

}
