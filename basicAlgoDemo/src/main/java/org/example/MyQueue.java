package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyQueue {
    /**
     * 1: enqueue
     * 2: dequeue
     * 3: print List
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        List<String> list = new ArrayList<>();
        String line;
        for (int i=0; i<= number; i++) {
            line = sc.nextLine();
            //System.out.println(line);
            String[] temp = line.split(" ");
            if("1".equals(temp[0]) ) { //enqueue
                list.add(temp[1]);
            } else if("2".equals(temp[0])) { //dequeue
                list.remove(0);
            } else if("3".equals(temp[0])) { // print list
                System.out.println(list.get(0));
            } else {
                // do nothing
            }
        }
    }
}
