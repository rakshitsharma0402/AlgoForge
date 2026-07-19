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
        Node newNode = new Node(val);

        if (isEmpty()) {
            head = tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            newNode.prev = tail;
            tail.next = newNode;
            head = newNode;
        }

        size++;
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
        return "";
    }

    public String toStringReversed() {
        return "";
    }

    public Object get(int index) {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }
}
