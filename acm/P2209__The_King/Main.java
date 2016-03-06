package P2209__The_King;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

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
        int number = cin.nextInt();
        int exponent = cin.nextInt();
        int chances[] = new int[number];
        for (int i = 0; i < number; i++) {
            int temp = cin.nextInt();
            chances[i] = 1;
            for (int j = 0; j < exponent; j++) {
                chances[i] *= temp;
            }
        }
        Arrays.sort(chances);
        int sum = 0;
        for (int i = number - 1; i >= 0; i--) {
            if (chances[i] <= 0) {
                break;
            }
            sum += chances[i];
        }
        System.out.println(sum);
    }
}
