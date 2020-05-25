package com.tcooper.utils;

import java.util.ArrayList;
import java.util.List;

public class BasicStack<T> {

    private List<T> items = new ArrayList<>();
    private int end = -1;

    public BasicStack(){}

    public BasicStack(T firstItem) {
        items.add(firstItem);
        end++;
    }

    //O(1)
    public void push(T data) {
        items.add(data);
        end++;
    }

    //O(1)
    public T pop() {
        if(!hasItems())
            throw new IllegalStateException("No more items on the stack");

        return items.remove(end--);
    }

    // O(n)
    public boolean contains(T item) {

        if(!hasItems()) return false;

        for(int i = 0; i <= end; i++){
            if(items.get(i).equals(item))
                return true;
        }

        return false;
    }

    // O(n)
    public T access(T item) {

        var err = new IllegalStateException("No items on the stack");

        if(!hasItems())
            throw err;

        for(int i = 0; i <= end; i++){

            var currentItem = items.get(i);
            if(currentItem.equals(item)){
                return currentItem;
            }
        }

        throw err;
    }

    //O(1)
    public int size() {
        return end  + 1;
    }

    private boolean hasItems() {
        return size() > 0;
    }

}
