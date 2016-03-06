package P2897__Dramatic_Multiplications;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = cin.nextInt();
            boolean used[] = new boolean[n * 10];
            int K = cin.nextInt();
            int digit = K;
            String result = digit + "";
            boolean power = true;
            int carry = 0;
            while (true) {
                int temp = digit * n + carry;
                if (temp == K) {
                    if (digit == 0) {
                        power = false;
                    }
                    break;
                }
                if (used[temp] == true) {
                    power = false;
                    break;
                }
                result = (temp % 10) + result;
                used[temp] = true;
                digit = temp % 10;
                carry = temp / 10;
            }
            if (power == true) {
                System.out.println(result);
            } else {
                System.out.println("0");
            }
        }
    }
}
