public class MyQueue<T> extends MyArrayList<T> {

    public T peek() {
        if (elements == null) {
            return null;
        }
        return (T) elements[0];
    }

    public T poll() {
        if (elements.length == 0) {
            return null;
        }
        Object[] temporary = new Object[elements.length - 1];
        T first = (T) elements[0];

        for (int i = 0; i < elements.length - 1; i++) {
            temporary[i] = elements[i + 1];
        }
        elements = temporary;
        return first;
    }
}
