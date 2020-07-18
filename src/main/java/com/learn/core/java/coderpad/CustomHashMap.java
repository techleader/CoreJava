package com.learn.core.java.coderpad;

import java.util.ArrayList;
import java.util.Optional;

public class CustomHashMap<K, V> {

    private int size;
    private Object[] buckets;

    public CustomHashMap(int size) {
        this.size = size;
        buckets = new Object[size];
    }

    public void put(K k, V v) {

        int index = k.hashCode() % size;
        ArrayList<Node> items;

        if (buckets[index] == null ) {
            items = new ArrayList<>();
            Node node = new Node(k, v);
            items.add(node);
            buckets[index] = items;
        }else{
            items = (ArrayList<Node>) buckets[index];
            for (Node n:items) {
               if(n.key.equals(k)){
                    n.val =v;
                    return;
               }
            }
                Node node = new Node(k, v);
                items.add(node);
        }
    }

    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i<buckets.length ; i++) {
            stringBuffer.append(String.format("%d:[ %s ]\n",i, buckets[i]));
        }
        return stringBuffer.toString();
    }

    public V get(K k) {

        int index = k.hashCode() % size;
        if (buckets[index] != null) {
            ArrayList<Node<K, V>> items = (ArrayList) buckets[index];
            Optional<Node<K, V>> itemToReturn = items.stream().filter(item -> item.key.equals(k)).findFirst();
            if (itemToReturn.isPresent()) {
                return (V) itemToReturn.get().val;
            } else {
                return null;
            }
        }
        return null;
    }
    class Node<K, V> {
        K key;
        V val;

        Node(K k, V v) {
            key = k;
            val = v;
        }

        @Override
        public String toString() {
            return key.toString() + "-" + val.toString() ;
        }
    }

    public static void main(String[] args) {


    }

}
