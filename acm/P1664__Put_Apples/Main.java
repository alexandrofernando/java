package P1664__Put_Apples;

import java.util.Scanner;
import java.io.File;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int M = cin.nextInt();
            int N = cin.nextInt();
            int result = search(M, N, M);
            System.out.println(result);
        }
    }

    static int search(int apple, int plate, int max) {
        if (plate == 1) {
            if (apple <= max) {
                return 1;
            }
            else {
                return 0;
            }
        }
        else {
            int sum = 0;
            int top = (max < apple ? max : apple);
            for (int i = 0; i <= top; i++) {
                sum += search(apple - i, plate - 1, i);
            }
            return sum;
        }
    }
}
