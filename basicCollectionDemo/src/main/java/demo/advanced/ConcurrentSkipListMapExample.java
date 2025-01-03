package demo.advanced;
import java.util.concurrent.ConcurrentSkipListMap;
public class ConcurrentSkipListMapExample {
    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();

        map.put(3, "Three");
        map.put(1, "One");
        map.put(2, "Two");

        System.out.println(map.get(2));

        map.remove(1);

        for (Integer key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }

        System.out.println(map.ceilingKey(2));
        System.out.println(map.floorKey(2));
        System.out.println(map.higherKey(2));
        System.out.println(map.lowerKey(2));
    }
}