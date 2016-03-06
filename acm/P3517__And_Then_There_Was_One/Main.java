package P3517__And_Then_There_Was_One;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-5-2
 * Time: 14:09:33
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            int K = in.nextInt();
            int m = in.nextInt();
            if (n == 0 && K == 0 && m == 0) {
                break;
            }
            ArrayList<Integer> stones = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++) {
                stones.add(i);
            }
            int pos = -1;
            for (int i = 0; i < n - 1; i++) {
                if (i == 0) {
                    pos = (m - 1) % stones.size();
                } else {
                    pos = (pos + K - 1) % stones.size();
                }
                stones.remove(pos);
            }
            System.out.println(stones.get(0));
        }
    }
}
