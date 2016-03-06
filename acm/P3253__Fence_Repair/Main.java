package P3253__Fence_Repair;

import java.util.Scanner;
import java.util.PriorityQueue;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-6-13
 * Time: 16:31:37
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Long> order = new PriorityQueue<Long>();
        long money = 0;
        for (int i = 0; i < n; i++) {
            long length = in.nextLong();
            order.offer(length);
        }
        for (int i = 0; i < n - 1; i++) {
            long length1 = order.poll();
            long length2 = order.poll();
            money += length1 + length2;
            order.offer(length1 + length2);
        }
        System.out.println(money);
    }
}
