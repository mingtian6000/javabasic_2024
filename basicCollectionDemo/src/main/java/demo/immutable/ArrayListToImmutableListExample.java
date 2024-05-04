package demo.immutable;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListToImmutableListExample {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("apple");
        arrayList.add("banana");
        arrayList.add("orange");

        ImmutableList<String> immutableList = ImmutableList.copyOf(arrayList);
        System.out.println(immutableList);
        //there is no add, remove,set method in ImmutableList

    }
}
