package P2346__Lucky_tickets;

import java.util.Scanner;
import java.util.Hashtable;
import java.util.Map;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-23
 * Time: 0:15:16
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        for (int i = 0; i < 10; i++) {
            table.put(i, 1);
        }
        for (int i = 0; i < N / 2 - 1; i++) {
            Hashtable<Integer, Integer> temp = new Hashtable<Integer, Integer>();
            Iterator<Map.Entry<Integer, Integer>> iterator = table.entrySet().iterator();
            while (iterator.hasNext() == true) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                for (int j = 0; j < 10; j++) {
                    int value = entry.getKey() + j;
                    if (temp.containsKey(value) == false) {
                        temp.put(value, entry.getValue());
                    } else {
                        temp.put(value, entry.getValue() + temp.get(value));
                    }
                }
            }
            table = temp;
        }
        int lucky = 0;
        Iterator<Integer> iterator1 = table.values().iterator();
        while (iterator1.hasNext() == true) {
            int number = iterator1.next();
            lucky += number * number;
        }
        System.out.println(lucky);
    }
}
