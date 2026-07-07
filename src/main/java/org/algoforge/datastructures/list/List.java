package org.algoforge.datastructures.list;

public interface List {
    void insertAtBeginning(Object val);
    void insertAtEnd(Object val);
    void insertAtIndex(Object val, int index);
    void deleteAtBeginning();
    void deleteAtEnd();
    void deleteAtIndex(int index);
    Object get(int index);
    boolean isEmpty();
    int size();
}

