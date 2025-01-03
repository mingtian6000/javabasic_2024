package newfeatures;

import java.util.ArrayList;
import java.util.List;

public class SequencedCollection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");

        //added since jdk21, but why added?? whats the logic behind this?
        list.addFirst("zero");
        list.addLast("fourth");

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.reversed());
    }
}
