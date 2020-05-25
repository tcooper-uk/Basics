package com.tcooper.utils;

public class BasicLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public BasicLinkedList() { }

    public BasicLinkedList(T data) {
        var n = new Node<T>(data);
        head = tail = n;
        size++;
    }

    // O(1)
    public void add(T data) {
        var newNode = new Node<T>(data);

        // first item
        if (head == null){
            head = tail = newNode;
        }
        else {
            tail.setNext(newNode);
            tail = newNode;
        }

        size++;
    }

    // O(n)
    public void insert(T item, int position) {

        // add first
        if(position == 0 && size == 0){
            add(item);
            return;
        }

        if(position > size - 1){
            throw new IllegalStateException("Position out of bounds");
        }

        // check not empty
        guardEmptyList();

        // find node before position
        int startAt = 0;
        int target = position == 0 ? position : position - 1;
        var node = new Node<T>(item);
        Node n = head;

        // check for head update
        if(position == startAt) {
            node.setNext(n);
            head = node;
        }
        else {
            // insert new node
            while (startAt != target) {
                n = n.getNext();
                startAt++;
            }
            if(n.hasNext()) node.setNext(n.getNext());
            n.setNext(node);
        }

        size++;
    }

    // O(1)
    public T getFirst() {
        guardEmptyList();
        return head.getData();
    }

    // O(1)
    public T getLast() {
        guardEmptyList();
        return tail.getData();
    }

    // O(1)
    public T removeFirst() {
        guardEmptyList();

        T item = head.getData();
        head = head.getNext();
        size--;

        return item;
    }

    // O(n) because not doubly linked
    public T removeLast() {

        guardEmptyList();
        T item = null;

        if(size == 1) {
            item = tail.getData();
            head = tail = null;
        } else {

            int stopAt = size - 1;
            int statAt = 1;
            Node<T> n = head;

            if(statAt == stopAt) {
                item = n.getNext().getData();
                n.setNext(null);
            }
            else {

                do {
                    n = n.getNext();
                    statAt++;
                } while(statAt != stopAt);

                item = n.getNext().getData();
                n.setNext(null);
            }
        }


        size --;
        return item;
    }

    // O(n)
    public T removeAt(int position) {
        guardEmptyList();
        if (position > size - 1) {
            throw new IllegalStateException("Position out of bounds");
        }

        // if we only have one item
        if(size == 0 && position == 0){
            size--;
            T item = head.getData();
            head = tail = null;
            return item;
        }

        int startAt = 0;
        Node<T> n = head;
        T item = null;

        if(position == 0){
            item = head.getData();
            head = head.getNext();
        }
        else {

            while (startAt != (position - 1)) {
                n = n.getNext();
                startAt++;
            }

            item = n.getNext().getData();
            n.setNext(
                    n.getNext().hasNext() ? n.getNext() : null
            );
        }

        size--;
        return item;
    }

    // O(n)
    public T get(int position) {
        guardEmptyList();

        if(position >= size) {
            throw new IllegalStateException("Position out of bounds");
        }
        int startAt = 0;
        Node<T> n = head;

        while (startAt != position){
            n = n.getNext();
            startAt++;
        }

        return n.getData();
    }

    // O(n)
    public int find(T item) {
        guardEmptyList();

        int counter = 0;
        Node<T> n = head;

        do {
            if (n.getData().equals(item)) return counter;

            counter++;
            n = n.getNext();

        } while(n != null);

        return -1;
    }

    // O(1)
    public int size() {
        return size;
    }

    private void guardEmptyList() throws IllegalStateException {
        if(size == 0){
            throw new IllegalStateException("List is empty");
        }
    }
}

class Node<T> {

    private T data;
    private Node next;

    Node(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }
}

