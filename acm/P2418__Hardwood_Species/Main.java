package P2418__Hardwood_Species;

import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-30
 * Time: 8:31:32
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        int total = 0;
        while (true) {
            String name = stdin.readLine();
            if (name == null) {
                break;
            }
            total++;
            if (map.containsKey(name) == false) {
                map.put(name, 1);
            } else {
                map.put(name, map.get(name) + 1);
            }
        }
        Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext() == true) {
            Entry<String, Integer> entry = iterator.next();
            System.out.printf("%s %.4f\n", entry.getKey(), entry.getValue() * 100.0 / total);
        }
    }
}
