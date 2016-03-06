package P3125__Printer_Queue;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-20
 * Time: 22:14:52
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int queue[] = new int[n];
            for (int i = 0; i < n; i++) {
                queue[i] = in.nextInt();
            }
            boolean used[] = new boolean[n];
            int pos = 0;
            int time = 1;
            while (true) {
                int index = pos;
                for (int i = 0; i < n; i++) {
                    if (used[index] == false && (used[pos] == true || queue[index] > queue[pos])) {
                        pos = index;
                    }
                    index = (index + 1) % n;
                }
                if (pos == m) {
                    break;
                }
                time++;
                used[pos] = true;
            }
            System.out.println(time);
        }
    }
}
