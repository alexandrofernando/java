package P3061__Subsequence;

import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int N = cin.nextInt();
            int S = cin.nextInt();
            LinkedList<Integer> queue = new LinkedList<Integer>();
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int temp = cin.nextInt();
                sum += temp;
                queue.offer(temp);
                while (sum >= S) {
                    if (queue.size() < min) {
                        min = queue.size();
                    }
                    sum -= queue.poll();
                }
            }
            if (min == Integer.MAX_VALUE) {
                System.out.println(0);
            } else {
                System.out.println(min);
            }
        }
    }
}
