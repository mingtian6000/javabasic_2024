package demo.advanced;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        list.add("A");

/*        for (String element : list) {
            System.out.println(element);
        }*/


        new Thread(() -> {
            list.add("B");
            list.add("C");
            list.remove("A");
        }).start();
        new Thread(() -> {
            for (String element : list) {
                System.out.println(element);
            }
        }).start();

    }
}