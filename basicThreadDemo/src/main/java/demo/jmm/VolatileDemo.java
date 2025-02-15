package demo.jmm;

public class VolatileDemo {

    private volatile int value;

    public void setValue(int newValue) {
        value = newValue; // 写volatile变量，类似有一个mfence效果，确保写操作对其他线程可见
    }

    public int getValue() {
        return value; // 读volatile变量，类似有一个mfence效果，保证读到最新值
    }

    public static void main(String[] args) {
        VolatileDemo example = new VolatileDemo();

        Thread writer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                example.setValue(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread reader = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                int val = example.getValue();
                System.out.println("Read value: " + val);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        writer.start();
        reader.start();

        try {
            writer.join();
            reader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
