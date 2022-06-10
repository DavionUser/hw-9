public class Main {
    public static void main(String[] args) {

        MyArrayList arrayList = new MyArrayList();
        MyLinkedList linkedList = new MyLinkedList();

//        arrayList.add(3);
//        arrayList.add(7);
//        arrayList.add(11);
//        arrayList.add(52);
//        System.out.println(arrayList);
//
//        arrayList.remove(1);
//        System.out.println(arrayList);
//
//        System.out.println(arrayList.size());
//
//        System.out.println(arrayList.get(1));
//
//        arrayList.clear();
//        System.out.println(arrayList);

        System.out.println(linkedList.size());

        linkedList.add("Hello");
        linkedList.add("Hello");
        linkedList.add("Hello");
        System.out.println("Added Hello to list");
        System.out.println(linkedList.size());
        System.out.println(linkedList);

        System.out.println(linkedList.get(0) + " index 0");
        System.out.println(linkedList.get(1) + " index 1");
        System.out.println(linkedList.get(2) + " index 2");

        linkedList.remove(1);
        System.out.println("Removed index 1");
        System.out.println(linkedList);

        linkedList.clear();
        System.out.println("Clearing");
        System.out.println(linkedList.size());
    }
}
