package org.algoforge.datastructures.list;

public class CircularLinkedList implements List {

    private static class Node {
        Object data;
        Node next;
        Node prev;

        public Node(Object data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertAtBeginning(Object val) {

    }

    public void insertAtEnd(Object val) {

    }

    public void insertAtIndex(Object val, int index) {

    }

    public void deleteAtBeginning() {

    }

    public void deleteAtEnd() {

    }

    public void deleteAtIndex(int index) {

    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "empty";
        }

        StringBuilder sb = new StringBuilder();
        Node curr = head;

        for (int i = 0; i < size; i++) {
            sb.append(curr.data);
            if (i < size - 1) {
                sb.append(" -> ");
            }
            curr = curr.next;
        }

        sb.append(" -> (head)");
        return sb.toString();
    }

    public String toStringReversed() {
        if (isEmpty()) {
            return "empty";
        }

        StringBuilder sb = new StringBuilder();
        Node curr = tail;

        for (int i = 0; i < size; i++) {
            sb.append(curr.data);
            if (i < size - 1) {
                sb.append(" -> ");
            }
            curr = curr.prev;
        }

        sb.append(" -> (tail)");
        return sb.toString();
    }

    public Object get(int index) {
        if (index < 0 || size() <= index) {
            throw new IndexOutOfBoundsException("Invalid position: " + index);
        }

        Node curr;

        if (index <= size() / 2) {
            curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i = size() - 1; i > index; i--) {
                curr = curr.prev;
            }
        }

        return curr.data;
    }


    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }
}
