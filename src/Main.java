import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        MyArrayList arrayList = new MyArrayList();
        arrayList.add(3);
        arrayList.add(7);
        arrayList.add(11);
        arrayList.add(52);
        System.out.println(Arrays.toString(arrayList.elements));

        arrayList.remove(1);
        System.out.println(Arrays.toString(arrayList.elements));

        System.out.println(arrayList.size());

        System.out.println(arrayList.get(1));

        arrayList.clear();
        System.out.println(Arrays.toString(arrayList.elements));
    }
}
