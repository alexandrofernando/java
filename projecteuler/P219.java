
import java.util.Map.Entry;
import java.util.TreeMap;

public class P219 {

    public static void main(String args[]) {
        final int LIMIT = 1000000000;
        TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
        long total = 0;
        for (int i = 1; i < LIMIT; i++) {
            long previousCost = 0;
            if (!map.isEmpty()) {
                Entry<Long, Integer> head = map.firstEntry();
                previousCost = head.getKey();
                map.put(head.getKey(), head.getValue() - 1);
                if (map.firstEntry().getValue() == 0) {
                    map.remove(map.firstKey());
                }
            }
            add(map, previousCost + 1);
            add(map, previousCost + 4);
            total += previousCost + 5;
        }
        System.out.println(total);
    }

    static void add(TreeMap<Long, Integer> map, long value) {
        Integer count = map.get(value);
        map.put(value, (count == null ? 0 : count) + 1);
    }
}