package P3427__Ecology_tax;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-28
 * Time: 19:21:33
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int L = in.nextInt();
        int heights[] = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = in.nextInt();
        }
        int min = Integer.MAX_VALUE;
        int year = -1;
        for (int i = 0; i < L; i++) {
            int total = 0;
            for (int j = 0; j < N; j++) {
                total += (heights[j] + i) % L;
            }
            if (total < min) {
                min = total;
                year = i;
            }
        }
        System.out.println(year);
    }
}
