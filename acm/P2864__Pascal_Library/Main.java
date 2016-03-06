package P2864__Pascal_Library;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-30
 * Time: 3:54:49
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int N = in.nextInt();
            int D = in.nextInt();
            if (N == 0 && D == 0) {
                break;
            }
            boolean all[] = new boolean[N];
            for (int i = 0; i < N; i++) {
                all[i] = true;
            }
            for (int i = 0; i < D; i++) {
                for (int j = 0; j < N; j++) {
                    if (in.nextInt() == 0) {
                        all[j] = false;
                    }
                }
            }
            boolean exist = false;
            for (int i = 0; i < N; i++) {
                if (all[i] == true) {
                    exist = true;
                    break;
                }
            }
            if (exist == true) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
