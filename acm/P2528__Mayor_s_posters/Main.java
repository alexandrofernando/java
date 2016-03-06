package P2528__Mayor_s_posters;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-4
 * Time: 7:18:38
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static boolean used[];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = in.nextInt();
            int lefts[] = new int[n];
            int rights[] = new int[n];
            TreeSet<Integer> set = new TreeSet();
            for (int i = 0; i < n; i++) {
                lefts[i] = in.nextInt();
                rights[i] = in.nextInt();
                set.add(lefts[i]);
                set.add(rights[i]);
            }
            int points[] = new int[set.size()];
            Iterator<Integer> iterator = set.iterator();
            int pos = 0;
            while (iterator.hasNext() == true) {
                points[pos] = iterator.next();
                pos++;
            }
            used = new boolean[65536];
            int visible = 0;
            for (int i = n - 1; i >= 0; i--) {
                int posL = Arrays.binarySearch(points, lefts[i]) + 1;
                int posR = Arrays.binarySearch(points, rights[i]) + 1;
                if (fill(posL, posR, 1, 32768, 1) == true) {
                    visible++;
                }
            }
            System.out.println(visible);
        }
    }

    static boolean fill(int left, int right, int segL, int segR, int index) {
        if (left >= segL && right <= segR && used[index] == true) {
            return false;
        }
        if (left == segL && right == segR) {
            used[index] = true;
            return true;
        }
        int middle = (segL + segR) / 2;
        if (right <= middle) {
            boolean temp = fill(left, right, segL, middle, index * 2);
            if (used[index * 2] == true && used[index * 2 + 1] == true) {
                used[index] = true;
            }
            return temp;
        } else if (middle + 1 <= left) {
            boolean temp = fill(left, right, middle + 1, segR, index * 2 + 1);
            if (used[index * 2] == true && used[index * 2 + 1] == true) {
                used[index] = true;
            }
            return temp;
        } else {
            boolean tempL = fill(left, middle, segL, middle, index * 2);
            boolean tempR = fill(middle + 1, right, middle + 1, segR, index * 2 + 1);
            if (used[index * 2] == true && used[index * 2 + 1] == true) {
                used[index] = true;
            }
            return tempL || tempR;
        }
    }
}
