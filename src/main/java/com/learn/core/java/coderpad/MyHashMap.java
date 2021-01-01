package com.learn.core.java.coderpad;

public class MyHashMap<K,V> {

    private static final int SIZE = 16;

    private Entry table[] = new Entry[SIZE];

    /**
     * To store the Map data in key and value pair.
     * Used linked list approach to avoid the collisions
     */
    static class Entry<K,V> {
        K key;
        V value;
        Entry next;

        Entry(K k, V v) {
            key = k;
            value = v;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }
    }


    public Entry get(K k) {
        int hash =  k.hashCode()% SIZE;
        Entry e = table[hash];

        while(e != null) {
            if(e.key.equals(k)) {
                return e;
            }
            e = e.next;
        }
        return null;
    }


    public void put(K k, V v) {
        int hash = k.hashCode() % SIZE;
        Entry e = table[hash];

        if(e != null) {

            if(e.key.equals(k)) {
                e.value = v;
            } else {
                while(e.next != null) {
                    e = e.next;
                }
                Entry entryInOldBucket = new Entry(k, v);
                e.next = entryInOldBucket;
            }
        } else {

            Entry entryInNewBucket = new Entry(k, v);
            table[hash] = entryInNewBucket;
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();

        myHashMap.put(1, "SSE");
        myHashMap.put(2, "rajesh");
        myHashMap.put(3, "SE");
        myHashMap.put(1, "SE");


        Entry e = myHashMap.get(1);

        System.out.println(""+e.getValue());
    }
}
