package com.tcooper.utils;

import java.util.ArrayList;
import java.util.List;

public class BasicQueue<T> {

    private List<T> data;

    private int front;
    private int end;

    {
        setPointerState();
    }

    public BasicQueue() {
        data = new ArrayList<>();
    }

    public BasicQueue(int size) {
        data = new ArrayList<>(size);
    }

    // O(1)
    public void enQueue(T item) {
        if(size() == 0){
            front++;
        }
        end++;
        data.add(item);
    }

    // O(1)
    public T deQueue() {
        T item = null;

         if(size() == 0) {
             throw new IllegalStateException("Queue is empty");
         }
         else if(front == end) {
             item = data.get(front);
             data = new ArrayList<>();
             setPointerState();
         }
         else {
            item = data.get(front);
            data.set(front, null);
            front++;
         }


         return item;
    }

    // O(n)
    public boolean contains(T item){
        if(size() == 0) return false;

        for(int i = front; i <= end; i++) {
            if(data.get(i).equals(item)) return true;
        }
        return false;
    }

    // O(n)
    public T access(int position) {
        if(size() == 0 || position > size()) {
            throw new IllegalStateException("Position is off");
        }

        int realIndex = 0;
        for(int i = front; i <= end; i++) {

            if(realIndex == position)
                return data.get(i);

            realIndex++;
        }

        throw new IllegalStateException("No items at position");
    }


    // O(1)
    public int size(){
        if(front == -1 && end == -1)
            return 0;

        return end - front + 1;
    }


    private void setPointerState(){
        end = -1;
        front = -1;
    }
}
