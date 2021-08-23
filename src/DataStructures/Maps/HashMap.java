package DataStructures.Maps;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class HashMap<K, V> {

    private final int capacity;
    private int size;
    private final ArrayList<K> keys;
    private final Entry<K, V>[] array;

    public HashMap(){
        capacity = 128;
        size = 0;
        array = new Entry[capacity];
        keys = new ArrayList<>();
    }

    public V get(K key){
        Entry<K, V> entry = array[getIndex(key)];

        while (entry != null){
            if (entry.key.equals(key)){
                return entry.value;
            }
            entry = entry.next;
        }

        throw new NoSuchElementException("Key does not exist");
    }

    public void put(K key, V value){
        int index = getIndex(key);
        Entry<K, V> entry = array[index];
        Entry<K, V> newEntry = new Entry<>(key, value);

        if (entry == null){
            array[index] = newEntry;
            size++;

        }
        else if (keys.contains(key)){
            while (entry != null){
                if (entry.key.equals(newEntry.key)) break;

                entry = entry.next;
            }
            entry.value = newEntry.value;
        }
        else {
            Entry<K, V> prev = entry;
            while (entry != null) {

                prev = entry;
                entry = entry.next;
            }
            prev.next = newEntry;
            size++;
        }
        keys.add(key);
    }

    public boolean containsKey(K key){ return keys.contains(key); }

    public int size() { return size; }

    public void remove(K key){
        int index = getIndex(key);
        Entry<K, V> entry = array[index];
        if (entry == null) return;

        if (entry.key.equals(key)) array[index] = null;

        else {
            Entry<K, V> prev = entry;

            while (entry != null) {
                if (entry.key.equals(key)) {
                    if (entry.next == null) prev.next = null;

                    else prev.next = entry.next;

                }
                prev = entry;
                entry = entry.next;
            }
        }
        size--;
        keys.remove(key);
    }

    public void print(){
        for (Entry<K, V> entry : array){
            if (entry != null) {
                System.out.printf("%s : %s", entry.key(), entry.value());

                while (entry.next != null){
                    System.out.printf(" -> %s : %s", entry.next.key, entry.next.value);
                    entry = entry.next;
                }
                System.out.println();
            }
        }
    }

    public ArrayList<K> keys() { return keys; }

    private int getIndex(K key) { return key.hashCode() & 0xfffffff % capacity; }

    public boolean isEmpty(){ return size() == 0; }

    private static class Entry<K, V> {
        private final K key;
        private V value;
        public Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K key() { return key; }
        public V value() { return value; }
    }
}