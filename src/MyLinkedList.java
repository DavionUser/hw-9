public class MyLinkedList<T> {

    private T t;
    protected Node<T> first;
    protected Node<T> last;
    protected int size = 0;

    public void set(T t) {
        this.t = t;
    }
    public T get() {
        return t;
    }

    public MyLinkedList() {
    }

    public void add(T value) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<T>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public void remove(int index) {
        Node<T> x = first;

        for (int i = 0; i < index; i++) {
            x = x.next;
        }

        Node<T> prev = x.prev;
        Node<T> next = x.next;

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
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.next;
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
        return node(index).item;
    }

    Node<T> node(int index) {
        Node<T> x = first;
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

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T value, Node<T> next) {
            this.item = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
