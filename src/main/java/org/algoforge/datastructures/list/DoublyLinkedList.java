package org.algoforge.datastructures.list;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
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

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertAtBeginning(Object val) {
        Node newNode = new Node(val);
        Node curr = head;

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = curr;
            curr.prev = newNode;
            head = newNode;
        }

        size++;
    }

    public void insertAtEnd(Object val) {
        Node newNode = new Node(val);

        if (isEmpty()) {
            insertAtBeginning(val);
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;

        size++;
    }

    public void insertAtIndex(Object val, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid position: " + index);
        }

        if (index == 0) {
            insertAtBeginning(val);
            return;
        }
        if (index == size) {
            insertAtEnd(val);
            return;
        }

        Node newNode = new Node(val);

        if (index <= size / 2) {
            Node curr = head;

            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }

            newNode.next = curr.next;
            curr.next.prev = newNode;
            curr.next = newNode;
            newNode.prev = curr;
        } else {
            Node curr = tail;

            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }

            newNode.prev = curr.prev;
            curr.prev.next = newNode;
            curr.prev = newNode;
            newNode.next = curr;
        }

        size++;
    }

    public void deleteAtBeginning() {
        if (isEmpty()) {
            throw new NoSuchElementException("Linked List is Empty");
        }

        if (head.next == null) {
            head = tail = null;
        } else {
            Node curr = head;
            head = curr.next;
            curr.next = null;
            head.prev = null;
        }

        size--;
    }

    public void deleteAtEnd() {
        if (isEmpty()) {
            throw new NoSuchElementException("Linked List is Empty");
        }

        if (head.next == null) {
            head = tail = null;
        } else {
            Node curr = tail;

            tail = curr.prev;
            curr.prev = null;
            tail.next = null;
        }

        size--;
    }

    public void deleteAtIndex(int index) {

    }

    public Object get(int index) {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }

    public String toStringReversed() {
        return null;
    }
}