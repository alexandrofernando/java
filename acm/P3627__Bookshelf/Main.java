package P3627__Bookshelf;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-1-11
 * Time: 1:56:54
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int B = in.nextInt();
        int heights[] = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = in.nextInt();
        }
        Arrays.sort(heights);
        int sum = 0;
        int number = 0;
        while (sum < B) {
            sum += heights[N - number - 1];
            number++;
        }
        System.out.println(number);
    }
}
