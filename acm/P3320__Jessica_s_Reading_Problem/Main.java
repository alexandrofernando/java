package P3320__Jessica_s_Reading_Problem;

import java.util.Scanner;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-9
 * Time: 4:04:11
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int P = in.nextInt();
        int ideas[] = new int[P];
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        for (int i = 0; i < P; i++) {
            ideas[i] = in.nextInt();
            table.put(ideas[i], 0);
        }
        int total = table.size();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int result = Integer.MAX_VALUE;
        int current = 0;
        for (int i = 0; i < P; i++) {
            queue.offer(ideas[i]);
            int count = table.get(ideas[i]);
            table.put(ideas[i], count + 1);
            if (count == 0) {
                current++;
            } else {
                while (true) {
                    int temp = table.get(queue.get(0));
                    if (temp == 1) {
                        break;
                    }
                    table.put(queue.get(0), temp - 1);
                    queue.remove(0);
                }
            }
            if (current == total && queue.size() < result) {
                result = queue.size();
            }
        }
        System.out.println(result);
    }
}
