package P3226__String_s_Puzzle;

import java.util.Scanner;
import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-23
 * Time: 4:16:56
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            BigInteger number = BigInteger.ZERO;
            int counts[] = new int[26];
            for (int i = 0; i < 26; i++) {
                counts[i] = i;
            }
            String str = in.next();
            for (int i = 0; i < n; i++) {
                int index = str.charAt(i) - 'A';
                BigInteger temp = new BigInteger(counts[index] + "");
                for (int j = i + 1; j < n; j++) {
                    temp = temp.multiply(new BigInteger((26 - j) + ""));
                }
                number = number.add(temp);
                for (int j = index + 1; j < 26; j++) {
                    counts[j]--;
                }
            }
            System.out.println(number);
        }
    }
}
