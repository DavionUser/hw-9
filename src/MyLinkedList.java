public class MyLinkedList<T> {

    private T t;
    protected Node first;
    protected Node last;
    protected int size = 0;

    public void set(T t) {
        this.t = t;
    }
    public T get() {
        return t;
    }

    public MyLinkedList() {
    }

    public void add(Object value) {
        final Node l = last;
        final Node newNode = new Node(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public void remove(int index) {
        Node x = first;

        for (int i = 0; i < index; i++) {
            x = x.next;
        }

        Node prev = x.prev;
        Node next = x.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;

        size--;
    }

    public void clear() {
        for (Node x = first; x != null; ) {
            Node next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return (T) node(index).item;
    }

    Node node(int index) {
        Node x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    @Override
    public String toString() {
        String text = "[";
        for (int i = 0; i < this.size(); i++) {
            text += this.get(i);
            if ((i + 1) == this.size()) {
                return text.strip() + "]";
            }
            text += ", ";
        }
        return null;
    }

    private static class Node {
        Object item;
        Node next;
        Node prev;

        Node(Node prev, Object value, Node next) {
            this.item = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
