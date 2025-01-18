package org.example.basicTree;

public class TestBinarySearchTree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
    }

    public static int preVal = Integer.MIN_VALUE;
    public static boolean isBST(Node head){
        if(head == null){
            return true;
        }
        boolean isLeftBst = isBST(head.left);
        if(!isLeftBst){
            return false;
        }
        //System.out.println(head.value);
        if(head.value<=preVal){
            return false;
        }else {
            preVal = head.value;
        }
        return isBST(head.right);

    }
}
