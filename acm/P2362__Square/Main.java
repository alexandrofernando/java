package P2362__Square;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-31
 * Time: 7:51:02
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int M;
    static int lengths[];
    static int size;
    static boolean used[];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            M = in.nextInt();
            lengths = new int[M];
            size = 0;
            for (int i = 0; i < M; i++) {
                lengths[i] = in.nextInt();
                size += lengths[i];
            }
            boolean find = false;
            if (size % 4 == 0) {
                size /= 4;
                if (lengths[M - 1] <= size) {
                    Arrays.sort(lengths);
                    used = new boolean[M];
                    find = search(0, size, M);
                }
            }
            if (find == true) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    static boolean search(int finish, int rest, int index) {
        if (finish == 3) {
            return true;
        }
        if (rest == 0) {
            return search(finish + 1, size, M);
        }
        for (int i = index - 1; i >= 0; i--) {
            if (used[i] == false) {
                if (rest == size) {
                    used[i] = true;
                    boolean temp = search(finish, size - lengths[i], i);
                    used[i] = false;
                    return temp;
                } else {
                    if (search(finish, rest, i) == true) {
                        return true;
                    }
                    used[i] = true;
                    boolean temp = search(finish, rest - lengths[i], i);
                    used[i] = false;
                    return temp;
                }
            }
        }
        return false;
    }
}
