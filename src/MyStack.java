public class MyStack extends MyArrayList {

    public void push(Object value) {
        Object[] temporary;

        if (elements == null) {
            elements = new Object[1];
            elements[0] = value;
        } else {
            temporary = new Object[elements.length + 1];

            for (int i = 0; i < elements.length; i++) {
                temporary[i] = elements[i];
            }
            temporary[temporary.length - 1] = value;
            elements = temporary;
        }
    }

    public Object peek() {
        if (elements.length == 0) {
            return null;
        }
        return elements[elements.length - 1];
    }

    public Object pop() {
        if (elements.length == 0) {
            return null;
        }
        Object[] temporary = new Object[elements.length - 1];
        Object last = elements[elements.length - 1];

        for (int i = 0; i < elements.length - 1; i++) {
            temporary[i] = elements[i];
        }
        elements = temporary;
        return last;
    }
}
