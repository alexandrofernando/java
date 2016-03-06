package P2153__Rank_List;

import java.util.Scanner;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-19
 * Time: 7:30:13
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        Hashtable<String, Integer> students = new Hashtable<String, Integer>();
        for (int i = 0; i < N; i++) {
            students.put(in.nextLine().trim(), 0);
        }
        int M = in.nextInt();
        for (int i = 0; i < M; i++) {
            int standard = -1;
            for (int j = 0; j < N; j++) {
                int score = in.nextInt();
                String name = in.nextLine().trim();
                int old = students.get(name);
                if (name.equals("Li Ming") == true) {
                    standard = old + score;
                }
                students.put(name, old + score);
            }
            int rank = 1;
            Iterator<Integer> iterator = students.values().iterator();
            while (iterator.hasNext() == true) {
                int score = iterator.next();
                if (score > standard) {
                    rank++;
                }
            }
            System.out.println(rank);
        }
    }
}
