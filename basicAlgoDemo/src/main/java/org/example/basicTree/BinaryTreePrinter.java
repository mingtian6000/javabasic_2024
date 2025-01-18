package org.example.basicTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreePrinter {
    public static void printTree(TreeNode root) {
        int maxLevel = maxLevel(root);
        System.out.println("maxLevel: " + maxLevel);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node!= null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= edgeLines; i++) {
            for (TreeNode node : nodes) {
                printWhitespaces(firstSpaces - i);
                if (node == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }
                if (node.left!= null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (node.right!= null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(edgeLines + edgeLines - i);
            }
            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static boolean isAllElementsNull(List<TreeNode> list) {
        for (TreeNode node : list) {
            if (node!= null)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(9);
        root.right.right.right = new TreeNode(2);
        printTree(root);
    }
}
