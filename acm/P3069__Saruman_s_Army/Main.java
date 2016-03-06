package P3069__Saruman_s_Army;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-8
 * Time: 1:05:31
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int R;
    static int n;
    static int positions[];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            R = in.nextInt();
            n = in.nextInt();
            if (R == -1 && n == -1) {
                break;
            }
            positions = new int[n];
            for (int i = 0; i < n; i++) {
                positions[i] = in.nextInt();
            }
            Arrays.sort(positions);
            int count = 0;
            int index = 0;
            while (true) {
                index = search(index);
                count++;
                if (index == n) {
                    break;
                }
            }
            System.out.println(count);
        }
    }

    static int search(int start) {
        int palantir = -1;
        for (int i = start + 1; i < n; i++) {
            if (positions[i] - positions[start] > R) {
                palantir = i - 1;
                break;
            }
        }
        if (palantir == -1) {
            return n;
        }
        for (int i = palantir + 1; i < n; i++) {
            if (positions[i] - positions[palantir] > R) {
                return i;
            }
        }
        return n;
    }
}
