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

    public void insertAtIndex(int index, Object val) {
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

        Node curr = head;
        head = curr.next;
        curr.next = null;

        if (head == null) {
            tail = null;
        }

        size--;
    }

    public void deleteAtEnd() {
        if (isEmpty()) {
            throw new NoSuchElementException("Linked List is Empty");
        }

        if (head.next == null) {
            head = null;
            tail = null;
            size--;
            return;
        }

        Node curr = head;

        for (int i = 0; i < size - 1; i++) {
            curr = curr.next;
        }

        curr.next = null;
        tail = curr;
        size--;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + index);
        }

        if (index == 0) {
            deleteAtBeginning();
            return;
        }

        if (index == size-1) {
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

    }

    public boolean isEmpty() {

    }

    public int size() {

    }

    @Override
    public String toString() {

    }
}

