package P2081__Recaman_s_Sequence;

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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        boolean used[] = new boolean[4000000];
        int a[] = new int[500001];
        a[0] = 0;
        used[0] = true;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] - i > 0 && used[a[i - 1] - i] == false) {
                a[i] = a[i - 1] - i;
            } else {
                a[i] = a[i - 1] + i;
            }
            used[a[i]] = true;
        } while (true) {
            int K = cin.nextInt();
            if (K == -1) {
                break;
            }
            System.out.println(a[K]);
        }
    }
}
