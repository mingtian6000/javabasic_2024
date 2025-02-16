package demo.jmm;

import java.util.HashSet;

public class Singleton1 {
    //没啥问题，但提前创建好了，不管用不用都放在那里 占空间。。
    private static Singleton1 INSTANCE;
    private Singleton1(){}

    public static Singleton1 getInstance(){
        if(INSTANCE==null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            INSTANCE=new Singleton1();
        }
        return INSTANCE;
    }
    public void f(){
        System.out.println("just test fucntion, print anything");
    }

    public static void main(String[] args) {
        var set = new HashSet<String>(); //set也不是线程安全
        for(int i=0; i<10000;i++){
            new Thread(()->{
                set.add(String.valueOf(Singleton.getInstance().hashCode()));
            }).start();
        }
        System.out.println(set.size());
    }
}
