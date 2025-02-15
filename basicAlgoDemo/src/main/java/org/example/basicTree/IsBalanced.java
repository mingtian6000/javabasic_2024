package org.example.basicTree;

public class IsBalanced {

    public static void main(String[] args) {
        Node head = new Node();
        head.value = 1;
        head.left = new Node();
        head.left.value = 2;
        head.right = new Node();
        head.right.value = 3;
        head.left.left = new Node();
        head.left.left.value = 4;
        head.left.right = new Node();
        head.left.right.value = 5;
        head.right.left = new Node();
        head.right.left.value = 6;
        head.right.right = new Node();
        head.right.right.value = 7;
        head.left.left.left = new Node();
        head.left.left.left.value = 8;
        head.left.left.right = new Node();
        head.left.left.right.value = 9;
        head.left.right.left = new Node();
        head.left.right.left.value = 10;
        head.left.right.right = new Node();
        head.left.right.right.value = 11;
        head.right.left.left = new Node();
        head.right.left.left.value = 12;
        head.right.left.right = new Node();
        head.right.left.right.value = 13;
        head.right.right.left = new Node();
        head.right.right.left.value = 14;
        head.right.right.right = new Node();
        head.right.right.right.value = 15;
        System.out.println(isBalanced(head));
    }
    public static class Node {
        public int value;
        public Node left;
        public Node right;
    }

    public static boolean isBalanced(Node head) {
        return process(head).isBalanced;
    }

    public static ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced, height);
    }

    public static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}

