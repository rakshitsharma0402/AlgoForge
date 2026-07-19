package org.algoforge.datastructures.list;

import java.util.NoSuchElementException;

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
        Node newNode = new Node(val);

        if (isEmpty()) {
            insertAtBeginning(val);
            return;
        }

        newNode.prev = tail;
        tail.next = newNode;
        newNode.next = head;
        head.prev = newNode;
        tail = newNode;

        size++;
    }

    public void insertAtIndex(Object val, int index) {
        if (index < 0 || size() < index) {
            throw new IndexOutOfBoundsException("Invalid position: " + index);
        }

        if (index == 0) {
            insertAtBeginning(val);
            return;
        }
        if (index == size()) {
            insertAtEnd(val);
            return;
        }

        Node newNode = new Node(val);

        if (index <= size() / 2) {
            Node curr = head;

            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }

            newNode.next = curr.next;
            newNode.prev = curr;
            curr.next = newNode;
            newNode.next.prev = newNode;
        } else {
            Node curr = tail;

            for (int i = size() - 1; i > index; i--) {
                curr = curr.prev;
            }

            newNode.prev = curr.prev;
            newNode.next = curr;
            curr.prev = newNode;
            newNode.prev.next = newNode;
        }

        size++;
    }

    public void deleteAtBeginning() {
        if (isEmpty()) {
            throw new NoSuchElementException("Linked List is Empty");
        }

        if (head == tail) {
            head = tail = null;
        } else {
            Node curr = head;

            head = curr.next;
            head.prev = tail;
            tail.next = head;
            curr.next = null;
            curr.prev = null;
        }

        size--;
    }

    public void deleteAtEnd() {
        if (isEmpty()) {
            throw new NoSuchElementException("Linked List is Empty");
        }

        if (head == tail) {
            head = tail = null;
        } else {
            Node curr = tail;

            tail = curr.prev;
            tail.next = head;
            head.prev = tail;
            curr.prev = null;
            curr.next = null;
        }

        size--;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || size() <= index) {
            throw new IndexOutOfBoundsException("Invalid position: " + index);
        }

        if (index == 0) {
            deleteAtBeginning();
            return;
        }
        if (index == size() - 1) {
            deleteAtEnd();
            return;
        }

        if (index <= size() / 2) {
            Node curr = head;

            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }

            curr.next = curr.next.next;
            curr.next.prev = curr;
        } else {
            Node curr = tail;

            for (int i = size() - 1; i > index; i--) {
                curr = curr.prev;
            }

            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }

        size--;
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
