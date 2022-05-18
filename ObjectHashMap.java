
/**
 * Part 1 of HW1 where ObjectHashMap extends AbstractHashMap class
 */

import java.util.LinkedList;

public class ObjectHashMap extends AbstractHashMap {
    private LinkedList<Entry>[] entries;
    int tempIndex;

    public ObjectHashMap(double maxLoad) {
        super(maxLoad);
        entries = new LinkedList[capacity];
    }

    public ObjectHashMap() {
        super(0.75);
        entries = new LinkedList[capacity];
    }

    @Override
    public void put(Object key, Object value) {
        int hashV = hash(key);
        double ratio = ((double) numKeys / (double) capacity);
        if (ratio < maxLoad) {
            if (!containsKey(key)) {
                Entry temp = new Entry(key, value);
                if (entries[hashV] == null) {
                    entries[hashV] = new LinkedList<Entry>();
                }
                entries[hashV].add(temp);
                numKeys++;
            } else {
                for (Entry e : entries[hash(key)]) {
                    if (e.key.equals(key)) {
                        e.value = value;
                    }
                }

            }
        } else {
            resize();
            put(key, value);
        }

    }

    @Override
    public Object find(Object key) {
        if (containsKey(key)) {
            for (Entry e : entries[hash(key)]) {
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
        }
        throw new NullPointerException();
    }

    @Override
    protected void resize() {
        Entry[] savedEntries = getEntries();
        numKeys = 0;
        capacity = capacity * 2;

        entries = new LinkedList[capacity];
        for (Entry e : savedEntries) {

            this.put(e.key, e.value);

        }

    }

    @Override
    public Entry[] getEntries() {
        Entry[] allEntries = new Entry[numKeys];
        int index = 0;
        for (int i = 0; i < this.entries.length; i++) {
            if ((entries[i] != null)) {
                for (Entry e : this.entries[i]) {
                    allEntries[index] = e;
                    index++;
                }
            }

        }

        return allEntries;

    }

    @Override
    public boolean containsKey(Object key) {
        if (isEmpty() || entries[hash(key)] == null) {
            return false;
        }
        for (Entry e : entries[hash(key)]) {
            if (e.key.equals(key)) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        ObjectHashMap map = new ObjectHashMap(0.75);

        map.put(22, "ee");
        map.put(21, "ee");
        map.put(20, "ee");
        map.put(19, "ee");
        map.put(18, "ee");
        map.put(17, "ee");
        map.put(16, "ee");
        map.put(15, "ee");
        map.put(14, "ee");
        map.put(13, "ee");
        map.put(12, "ee");
        map.put(11, "ee");
        map.put(10, "ee");
        map.put(9, "ee");
        map.put(8, "ee");
        map.put(7, "ee");
        map.put(6, "ee");
        map.put(5, "ee");
        map.put(4, "ee");
        map.put(3, "ee");
        map.put(2, "ee");
        map.put(1, "ee");

        for (Entry e : map.getEntries()) {
            System.out.println(e.toString());
        }

    }

}
