package hackerRank;

import java.util.Stack;

public class SolutionD5 {
    public static void main(String[] args) {
/*        SinglyLinkedList a1 = new SinglyLinkedList();
        a1.insertNode(1);
        a1.insertNode(2);
        a1.insertNode(3);
        SinglyLinkedList a2 = new SinglyLinkedList();
        a2.insertNode(1);
        a2.insertNode(3);
        a2.insertNode(4);
        SinglyLinkedListNode node = mergeLists(a1.head, a2.head);
        printSinglyLinkedList(node);*/
        System.out.println(isBalanced("[]][{]{(({{)[})(}[[))}{}){[{]}{})()[{}]{{]]]){{}){({(}](({[{[{)]{)}}}({[)}}([{{]]({{"));
        System.out.println(isBalanced("[](){()}"));
        System.out.println(isBalanced("()"));
        System.out.println(isBalanced("({}([][]))[]()"));
        System.out.println(isBalanced("{)[](}]}]}))}(())("));
        System.out.println(isBalanced("([[)"));
    }

    // For each string, return YES or NO.
    // one stack遇到左括号就入栈 右括号出栈，最终栈空为true
    // first char will decide direction?
    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();

        for (int i = 0; i < chs.length; i++) {
            if ('{' == chs[i] || '[' == chs[i] || '(' == chs[i]) {
                stack.push(chs[i]);
            } else {
                if (stack.empty()) { // stack is empty but char seq is not empty
                    if ('}' == chs[i] || ']' == chs[i] || ')' == chs[i]) {
                        stack.push(chs[i]);
                    } else {
                        char c = stack.pop();
                        if (!(c == '{' && chs[i] == '}' || c == '[' && chs[i] == ']' || c == '(' && chs[i] == ')')) {
                            return "NO";
                        }
                    }
                } else {
                    char c = stack.pop();
                    if (!(c == '{' && chs[i] == '}' || c == '[' && chs[i] == ']' || c == '(' && chs[i] == ')')) {
                        return "NO";
                    }
                }
            }
        }

        if (stack.empty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    //  two sorted linked lists merge in to one ordered sort, return new head??
    // too lengthy...
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedList newList = new SinglyLinkedList();
        SinglyLinkedListNode temp1 = head1, temp2 = head2;
        if (temp1 != null && temp2 != null) {
            if (temp1.val > temp2.val) {
                newList.insertNode(temp2.val);
                temp2 = head2.next;
                while (temp1 != null || temp2 != null) {
                    if ((temp1 != null && temp2 != null) && temp1.val >= temp2.val) {
                        newList.insertNode(temp2.val);
                        temp2 = temp2.next;
                    } else {
                        if (temp1 == null) {
                            newList.insertNode(temp2.val);
                            temp2 = temp2.next;
                        } else {
                            newList.insertNode(temp1.val);
                            temp1 = temp1.next;
                        }
                    }
                }
            } else {
                newList.insertNode(temp1.val);
                temp1 = head1.next;
                while (temp1 != null || temp2 != null) {
                    if ((temp1 != null && temp2 != null) && temp1.val >= temp2.val) {
                        newList.insertNode(temp2.val);
                        temp2 = temp2.next;
                    } else {
                        if (temp1 == null) {
                            newList.insertNode(temp2.val);
                            temp2 = temp2.next;
                        } else {
                            newList.insertNode(temp1.val);
                            temp1 = temp1.next;
                        }
                    }
                }
            }
        } else {
            // both null, return null;
        }
        return newList.head;
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

}

class SinglyLinkedListNode {
    int val;
    SinglyLinkedListNode next;

    SinglyLinkedListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
    }

}