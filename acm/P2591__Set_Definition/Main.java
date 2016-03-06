package P2591__Set_Definition;

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
        int set[] = new int[10000005];
        set[1] = 1;
        int two = 1;
        int three = 1;
        for (int i = 2; i < set.length; i++) {
            int number1 = set[two] * 2 + 1;
            int number2 = set[three] * 3 + 1;
            if (number1 < number2) {
                set[i] = number1;
                two++;
            }
            else if (number1 > number2) {
                set[i] = number2;
                three++;
            }
            else {
                set[i] = number1;
                two++;
                three++;
            }
        }
        while (cin.hasNextInt() == true) {
            int N = cin.nextInt();
            System.out.println(set[N]);
        }
    }
}
