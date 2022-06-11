public class MyQueue extends MyArrayList {

    public Object peek() {
        if (elements.length == 0) {
            return null;
        }
        return elements[0];
    }

    public Object poll() {
        if (elements.length == 0) {
            return null;
        }
        Object[] temporary = new Object[elements.length - 1];
        Object first = elements[0];

        for (int i = 0; i < elements.length - 1; i++) {
            temporary[i] = elements[i + 1];
        }
        elements = temporary;
        return first;
    }
}
