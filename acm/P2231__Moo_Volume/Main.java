package P2231__Moo_Volume;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-28
 * Time: 7:30:16
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int locations[] = new int[N];
        for (int i = 0; i < N; i++) {
            locations[i] = in.nextInt();
        }
        Arrays.sort(locations);
        long previous = 0;
        for (int i = 1; i < N; i++) {
            previous += (locations[i] - locations[0]);
        }
        long total = previous;
        for (int i = 1; i < N; i++) {
            long distance = locations[i] - locations[i - 1];
            long current = previous + distance * (i * 2 - N);
            total += current;
            previous = current;
        }
        System.out.println(total);
    }
}
