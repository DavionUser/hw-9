import java.util.LinkedList;
import java.util.List;

public class MyHashMap<K, V> {

    public static final int INITIAL_CAPACITY = 16;
    private K key;
    private V value;
    private Node[] hashTable;
    private int size = 0;

//    public void setKey(K key) {
//        this.key = key;
//    }

    public K getKey() {
        return key;
    }

//    public void setValue(V value) {
//        this.value = value;
//    }

    public V getValue() {
        return value;
    }

    public MyHashMap(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public MyHashMap() {
        hashTable = new Node[INITIAL_CAPACITY];
    }

    public boolean put(Object key, Object value) {
        Node<K, V> newNode = new Node<>((K) key, (V) value);
        int index = newNode.hash();
        if (index < 0) {
            index = index * -1;
        }

        if (hashTable[index] == null) {
            hashTable[index] = new Node<>(null, null);
            hashTable[index].getNodes().add(newNode);
            size++;
            return true;
        }

        List<Node<K, V>> nodeList = (List<Node<K, V>>) hashTable[index].getNodes();
        for (Node<K, V> node: nodeList) {
            if (newNode.getKey().equals(node.getKey())) {
                node.value = newNode.value;
                return true;
            }
        }
        return false;
    }

    public void remove(Object key) {

    }

    public void clear() {

    }

    public int size() {
        return size;
    }

    public V get(Object key) {
       int index = hash((K) key);
       if (index < hashTable.length &&
            hashTable[index] != null) {
           List<Node<K, V>> list = (List<Node<K, V>>) hashTable[index].getNodes();
           for (Node<K, V> node: list) {
               if (key.equals(node.getKey())) {
                   return node.getValue();
               }
           }
       }
       return null;
    }

    private int hash(final K key) {
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash % INITIAL_CAPACITY;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String text = "";
        for (Node<K, V> node: hashTable) {
            text += node.toString();
        }
        return "{" + text + "}";
    }

    static class Node<K, V> {
        private List<Node<K, V>> nodes;
        private int hash;
        K key;
        V value;
        Node<K, V> next;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            nodes = new LinkedList<Node<K, V>>();
        }

        private List<Node<K, V>> getNodes() {
            return nodes;
        }

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

        private int hash() {
            return hashCode() % INITIAL_CAPACITY;
        }

        public int hashCode(K key) {
            hash = 31;
            hash = hash * 17 + key.hashCode();
            return hash;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return this.key == node.key && this.key.equals(node.key);
        }

        @Override
        public final String toString() {
            return key + "=" + value;
        }
    }

}
