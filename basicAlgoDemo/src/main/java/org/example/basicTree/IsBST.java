package org.example.basicTree;

public class IsBST {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
    }

    public static class Info{
        public int height;
        public int nodes;
        public Info(int h, int n){
            this.height = h;
            this.nodes = n;
        }
    }

    public static boolean isF(Node head){
        return f(head).nodes == (1<<f(head).height)-1;
        //这里用位移运算效率会更高
    }
    public static Info f(Node head){
        if(head ==null){
            return new Info(0,0);
        }
        Info leftInfo = f(head.left);
        Info rightInfo = f(head.right);
        int height = Math.max(leftInfo.height,rightInfo.height)+1;
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        return new Info(height,nodes);
    }
}
