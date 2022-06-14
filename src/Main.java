import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        MyArrayList<String> arrayList = new MyArrayList<>();
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        MyQueue<String> q = new MyQueue<>();
        MyStack<String> stack = new MyStack<>();
        MyHashMap<String, Integer> hashMap = new MyHashMap<String, Integer>();

        System.out.println(hashMap);

        hashMap.put("first node", " node1");
        hashMap.put("second node", " node2");
        hashMap.put("third node", " node3");
        System.out.println(hashMap);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Ukraine", 1);
        map.put("England", 2);
        map.put("GOGOGO", 3);
        System.out.println(map);


    }
}
