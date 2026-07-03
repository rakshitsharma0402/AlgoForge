package org.algoforge.datastructures.list;

public class DoublyLinkedList {
    private static class Node {
        Object data;
        Node next;
        Node prev;

        public Node (Object data) {
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

    }

    public void insertAtEnd(Object val) {

    }

    public void insertAtIndex(int index, Object val) {

    }

    public void deleteAtBeginning() {

    }

    public void deleteAtEnd() {

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