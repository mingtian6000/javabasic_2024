package demo.immutable;

import java.util.ArrayList;
import java.util.List;
// require JDK9+
public class JdkInternalImmutableListExample {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("apple");
        arrayList.add("banana");
        arrayList.add("orange");

        List<String> immutableList = List.of(arrayList.toArray(new String[0]));
        System.out.println(immutableList);
        immutableList.add("pear"); //UnsupportedOperationException
        List<String> immutableList2 = List.of("apple", "banana", "orange");//same.
        System.out.println(immutableList2.equals(immutableList));
    }
}
