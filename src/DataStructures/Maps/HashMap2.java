package DataStructures.Maps;

// The following code is a series of SortingAlgos.test that were written in the order you'll read them. After
// each SortingAlgos.test was written it was run against the DataStructures.DataStructures.HashMap and the implementation was updated if it
// failed. The DataStructures.DataStructures.HashMap code is the final implementation that was built naively to pass each SortingAlgos.test.

// The Tests:

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashMap2 {
    private int size;
    private ArrayList<LinkedList<Element>> array;

    public HashMap2() {
        this.size = 0;
        this.array = new ArrayList<LinkedList<Element>>(128);

        for (int i = 0; i < 128; i++) {
            this.array.add(new LinkedList<Element>());
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(String key, Object value) {
        this.remove(key);

        array.get(hash(key)).add(new Element(key, value));
        size++;
    }

    public boolean containsKey(String key) {
        for (Element ele : this.array.get(hash(key))) {
            if (ele.key.equals(key)) {
                return true;
            }
        }

        return false;
    }

    public int size() {
        return size;
    }

    public Object get(String key) {
        for (Element ele : this.array.get(hash(key))) {
            if (ele.key.equals(key)) {
                return ele.value;
            }
        }

        throw new NoSuchElementException();
    }

    private int hash(String key) {
        return key.hashCode() % 128;
    }

    public void remove(String key) {
        for (Element ele : this.array.get(hash(key))) {
            if (ele.key.equals(key)) {
                this.array.get(hash(key)).remove(ele);
                size--;
                break;
            }
        }
    }

    private class Element {
        public final String key;
        public final Object value;

        public Element(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}