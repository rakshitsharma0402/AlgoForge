package org.algoforge.datastructures.list;

import java.util.NoSuchElementException;

public class SinglyLinkedList {

    private static class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insertAtBeginning(Object val) {
        Node newNode = new Node(val);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
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
        Node curr = head;

        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;

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
            Node curr = head;

            for (int i = 0; i < size() - 2; i++) {
                curr = curr.next;
            }

            curr.next = null;
            tail = curr;
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

        Node curr = head;

        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;

        size--;
    }

    public Object get(int index) {
        if (index < 0 || size() <= index) {
            throw new IndexOutOfBoundsException("Invalid position: " + index);
        }

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = head;

        while (curr != null) {
            sb.append(curr.data).append(" -> ");
            curr = curr.next;
        }

        sb.append("null");
        return sb.toString();
    }
}

