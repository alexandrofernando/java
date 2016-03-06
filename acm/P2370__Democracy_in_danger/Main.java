package P2370__Democracy_in_danger;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-8
 * Time: 7:35:21
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        int voters[] = new int[K];
        for (int i = 0; i < K; i++) {
            voters[i] = in.nextInt();
        }
        Arrays.sort(voters);
        int result = 0;
        for (int i = 0; i < (K + 1) / 2; i++) {
            result += (voters[i] + 1) / 2;
        }
        System.out.println(result);
    }
}
