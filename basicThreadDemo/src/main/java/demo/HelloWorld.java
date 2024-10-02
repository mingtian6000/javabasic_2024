package demo;

import com.sun.source.doctree.SeeTree;

import java.util.Set;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(Thread.activeCount());
        Set<Thread> ts = Thread.getAllStackTraces().keySet();//不同JDK打印会有区别
        for (Thread t : ts) {
            System.out.println(t.getId() + " " + t.getName());
        }

    }


}




