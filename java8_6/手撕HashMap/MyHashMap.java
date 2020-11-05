package com.cheng.手撕HashMap;

public class MyHashMap {
    private Node[] array = new Node[11];
    private int size;

    public Integer get(Integer key) {
        int hashValue = key.hashCode();
        int index = hashValue % array.length;

        Node current = array[index];
        while (current != null) {
            if (key.equals(current.key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    public Integer put(Integer key, Integer value) {
        int hashValue = key.hashCode();
        int index = hashValue % array.length;

        Node current = array[index];
        while (current != null) {
            if (key.equals(current.key)) {
                Integer oldValue = current.value;
                current.value = value;
                return oldValue;
            }
            current = current.next;
        }

        Node node = new Node(key, value);
        node.next = array[index];
        array[index] = node;

        size++;

        // 判断负载因子，看是否需要扩容

        return null;
    }
}
