public class MyHashMap<K, V> {
    public static final int INITIAL_CAPACITY = 16;
    private K key;
    private V value;
    Node<K, V>[] table;
    protected int size = 0;

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public MyHashMap() {
    }

    public MyHashMap(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void put(K key, V value) {
        Node<K, V> start, temp;
        int hash = hash(key) ;
        int index = hash % INITIAL_CAPACITY;
//        System.out.println(index +  " index");

        if (table == null) {
            table = new Node[INITIAL_CAPACITY];
        }

        if (table[index] == null) {
            start = new Node<>(hash, key, value, null);
            table[index] = start;
            size++;
        } else if (key == null) {
            table[0] = new Node<>(0, null, value, null);
            size++;
        } else {
            temp = new Node<>(hash, key, value, null);
            start = table[index];
            while (start != null) {
                if (start.hash == temp.hash &&
                        (start.key == temp.key || start.key.equals(temp.key))) {
                    start.value = temp.value;
                    return;

                } else if (start.next == null){
                    temp.next = start;
                    table[index] = temp;
                    size++;
                    return;
                }
                start = start.next;
            }
        }
    }

    public void remove(K key) {
        Node<K, V> temp;
        Node<K, V> start = null;
        int hash = hash(key);
        int index = hash % INITIAL_CAPACITY;

        if (table == null || table[index] == null) {
            return;
        } else {
            temp = table[index];
            do {
                if (temp.hash == hash &&
                        (temp.key == key || temp.key.equals(key))) {
                    if (start == null) {
                        table[index] = temp.next;
                        --size;
                        break;
                    } else {
                        start.next = temp.next;
                        table[index] = start;
                        temp = null;
                        --size;
                    }
                } else {
                    start = temp;
                    temp = temp.next;
                }
            } while (temp != null);
        }
    }

    public void clear() {
        table = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        Node<K, V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }

    final Node<K,V> getNode(int hash, Object key) {
        Node<K, V>[] tab;
        Node<K, V> first, e;
        int n;
        K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
                (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && // always check first node
                    ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                do {
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }

    final int hash(K key) {
        int h;
        int temp = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        if (temp < 0) {
            temp = temp * -1;
        }
        return temp;
    }

    @Override
    public String toString() {
        String text = "{";
        if (table == null || table.length == 0) {
            return "{}";
        }
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                continue;
            } else if (table[i].next != null) {
                Node<K, V> start = table[i];

                while (start.next != null) {
                    start = start.next;
                    text += start + " ";
                }
            }
            text += table[i] + " ";
        }
        return text.strip() + "}";
    }

    static class Node<K, V> {
        int hash;
        K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final int hashCode() {
            return key != null ? key.hashCode() : 0;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
        @Override
        public boolean equals(Object key) {
            if (key.hashCode() == this.hashCode() && key == this.key) {
                return true;
            }
            if (getClass() != key.getClass()) {
                return false;
            }
            Node node = (Node) key;
            return node.key == key;
        }

        @Override
        public final String toString() {
            String nodes = "";
                return key + "=" + value;
        }
    }
}
