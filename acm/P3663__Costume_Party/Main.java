package P3663__Costume_Party;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-1-10
 * Time: 18:05:21
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int S = in.nextInt();
        int lengths[] = new int[N];
        for (int i = 0; i < N; i++) {
            lengths[i] = in.nextInt();
        }
        Arrays.sort(lengths);
        int total = 0;
        for (int i = 0; i < N; i++) {
            int rest = S - lengths[i];
            if (rest <= 0) {
                break;
            }
            int index = Arrays.binarySearch(lengths, rest);
            if (index >= 0) {
                while (index + 1 < N && lengths[index + 1] == lengths[index]) {
                    index++;
                }
            } else {
                index = -index - 2;
            }
            if (index >= i) {
                total += index;
            } else {
                total += index + 1;
            }
        }
        total /= 2;
        System.out.println(total);
    }
}
