package com.tcooper.utils;

public class BasicHashTable<K, V> {
    private HashEntry<K, V>[] data;
    private int capacity;
    private int size;

    public BasicHashTable(int tableSize) {
        this.capacity = tableSize;
        this.data = new HashEntry[this.capacity];
    }


    //O(1) - O(n) worst case
    public V get(K key) {
        int hash = calculateHashCode(key);
        if (data[hash] == null) {
            throw new IllegalStateException("Item with key not present");
        }
        return data[hash].getValue();
    }

    //O(1) - O(n) worst case
    public void put(K key, V value) {
        int hash = calculateHashCode(key);
        var entry = new HashEntry<K, V>(key, value);
        this.data[hash] = entry;
        size++;
    }

    //O(1) - O(n) worst case
    public V delete(K key) {
        int hash = calculateHashCode(key);

        if(data[hash] == null){
            throw new IllegalStateException("Key not present in table");
        }

        V val = data[hash].getValue();
        data[hash] = null;
        size--;

        // At this point we could re-hash to keep our table clean
        // if they key we are removing previously cause collisions forcing other items to increment to the next position
        // these other items should be re-hashed and moved.
        hash = (hash + 1) % this.capacity;

        while (data[hash] != null) {
            HashEntry<K, V> entry = data[hash];
            data[hash] = null;
            put(entry.getKey(), entry.getValue());
            size--;
            hash = (hash + 1) % this.capacity;
        }

        return val;
    }

    //O(1) - O(n) worst case
    public boolean containsKey(K key) {
        int hash = calculateHashCode(key);
        return data[hash] == null ? false : true;
    }

    //O(n)
    public boolean containsValue(V value) {
        if(size > 0) {
            for (int i = 0; i < this.capacity; i++) {
                if (data[i] != null && data[i].getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    /**
     * Calculate the index for our key within our data array
     * @param key
     * @return index for key
     */
    private int calculateHashCode(K key) {
        int hashSlot = (key.hashCode() % this.capacity);

        // check for collisions
        while (data[hashSlot] != null && !data[hashSlot].getKey().equals(key)) {
            hashSlot = (hashSlot + 1) % this.capacity;
        }
        return hashSlot;
    }
}

class HashEntry<K, V> {
    private K key;
    private V value;

    public HashEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
