package demo.jmm;

public class Singleton {
    //没啥问题，但提前创建好了，不管用不用都放在那里 占空间。。
    private static final Singleton INSTANCE = new Singleton();
    private Singleton(){}

    public static Singleton getInstance(){return INSTANCE;}
    public void f(){
        System.out.println("just test fucntion, print anything");
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1==s2);
    }
}
