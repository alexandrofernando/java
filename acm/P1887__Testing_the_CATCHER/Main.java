package P1887__Testing_the_CATCHER;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-1
 * Time: 3:06:36
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = 1;
        while (true) {
            ArrayList<Integer> heights = new ArrayList<Integer>();
            while (true) {
                int temp = in.nextInt();
                if (temp == -1) {
                    break;
                }
                heights.add(temp);
            }
            int size = heights.size();
            if (size == 0) {
                break;
            }
            int result = 0;
            int max[] = new int[size];
            for (int i = 0; i < size; i++) {
                int temp = 0;
                for (int j = 0; j < i; j++) {
                    if (heights.get(j) >= heights.get(i) && max[j] > temp) {
                        temp = max[j];
                    }
                }
                max[i] = temp + 1;
                if (max[i] > result) {
                    result = max[i];
                }
            }
            if (test != 1) {
                System.out.println();
            }
            System.out.println("Test #" + test + ":");
            System.out.println("  maximum possible interceptions: " + result);
            test++;
        }
    }
}
