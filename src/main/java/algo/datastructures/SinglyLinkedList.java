package algo.datastructures;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedList<T> {

    private Node<T> head;
    private int size;

    public void add(T element) {
        if (size == 0) {
            head = new Node<>(element);
        } else {
            Node<T> temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            //now temp points to last element in list
            Node<T> last = new Node<>(element);
            temp.setNext(last);
        }
        size++;
    }

    public void reverse() {
        Node<T> prev = null;
        Node<T> curr = head;
        Node<T> next = null;

        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public List<T> traverse() {
        List<T> elements = new ArrayList<>();
        Node<T> temp = head;
        while (temp != null) {
            elements.add(temp.getData());
            temp = temp.getNext();
        }
        return elements;
    }

}


class Node<T> {

    private T data;
    private Node<T> next;

    Node(T element) {
        this.data = element;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
