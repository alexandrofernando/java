package P2299__Ultra_Quicksort;

import java.util.Scanner;
import java.io.File;

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
    static int numbers[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        while (true) {
            int n = cin.nextInt();
            if (n == 0) {
                break;
            }
            numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = cin.nextInt();
            }
            long result = mergesort(numbers);
            System.out.println(result);
        }
    }

    static long mergesort(int array[]) {
        if (array.length < 2) {
            return 0;
        }
        int middle = array.length / 2;
        long count = 0;
        int left[] = new int[middle];
        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }
        int right[] = new int[array.length - middle];
        for (int i = middle; i < array.length; i++) {
            right[i - middle] = array[i];
        }
        count += mergesort(left);
        count += mergesort(right);
        int pos1 = 0;
        int pos2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (pos1 < left.length &&
                (pos2 == right.length || left[pos1] < right[pos2])) {
                array[i] = left[pos1];
                pos1++;
            } else {
                array[i] = right[pos2];
                pos2++;
                count += left.length - pos1;
            }
        }
        return count;
    }
}
