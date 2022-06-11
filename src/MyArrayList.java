public class MyArrayList {

    private static final int DEFAULT_CAPACITY = 1;
    public Object[] elements;

    public void add(Object value) {
        Object[] temporary;

        if (elements == null) {
            elements = new Object[DEFAULT_CAPACITY];
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

    public void remove(int index) {
        Object[] temporary = new Object[elements.length - 1];
        int removedElement = 0;

        if (index < 0 || index >= elements.length -1) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range");
        } else {
            for (int i = 0; i < elements.length - 1; i++) {
                if (i == index) {
                    elements[i] = "";
                    removedElement += 1;
                }
                temporary[i] = elements[i + removedElement];
            }
            elements = temporary;
        }
    }

    public void clear() {
        elements = new Object[]{};
    }

    public int size() {
        return elements.length;
    }

    public Object get(int index) {

            if (index < 0 || index >= elements.length) {
                throw new IndexOutOfBoundsException("Index " + index + " is out of range");
            }
        return elements[index];
    }

    @Override
    public String toString() {
        String text = "[";
        for (int i = 0; i < elements.length; i++) {
            text += elements[i];
            if ((i + 1) == elements.length) {
                return text + "]";
            }
            text += ", ";
        }
        return null;
    }
}
