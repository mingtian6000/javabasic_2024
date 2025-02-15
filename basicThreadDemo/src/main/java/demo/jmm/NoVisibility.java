package demo.jmm;

public class NoVisibility {
    private static /*volatile*/ boolean ready;
    private static /*volatile*/ int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new ReaderThread();
        t.start();
        //有两个隐藏的bug，一个是ready没有用volatile修饰，一个是number没有用volatile修饰
        number = 42;
        ready = true;//这里可能会出现指令重排，导致number=42先执行，ready=true后执行
        // ready有可能不可见，导致ReaderThread线程一直在循环
        t.join();
    }
}
