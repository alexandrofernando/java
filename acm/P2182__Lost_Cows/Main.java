package P2182__Lost_Cows;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-7
 * Time: 7:25:03
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int precedings[] = new int[N];
        for (int i = 1; i < N; i++) {
            precedings[i] = in.nextInt();
        }
        int brands[] = new int[N];
        for (int i = 1; i <= N; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if (precedings[j] == 0) {
                    brands[j] = i;
                    for (int k = j + 1; k < N; k++) {
                        if (precedings[k] > 0) {
                            precedings[k]--;
                        }
                    }
                    precedings[j] = -1;
                    break;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(brands[i]);
        }
    }
}
