package algo.datastructures;

import java.util.EmptyStackException;

public class SimpleStackDemo {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("stack contents:");
        stack.traverse();

        System.out.println();
        System.out.println("stack peek() results: ");

        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());

        System.out.println();
        System.out.println("stack pop() results: ");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    static class Stack {
        Node top;

        void push(int value) {
            Node node = new Node(value);
            if (isEmpty()) {
                top = node;
            } else {
                node.next = top;
                top = node;
            }
        }

        int pop() {
            int data = top.val;
            top = top.next;
            return data;
        }

        void traverse() {
            Node tmp = top;
            while (tmp != null) {
                System.out.println(tmp.val);
                tmp = tmp.next;
            }
        }

        int peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }

            return top.val;
        }

        boolean isEmpty() {
            return top == null;
        }
    }


    private static class Node {
        int val;
        Node next;

        Node(int x) {
            this.val = x;
            this.next = null;
        }
    }
}
