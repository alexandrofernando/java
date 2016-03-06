package P2440__DNA;

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
        int numbers[] = new int[200];
        numbers[0] = 1;
        numbers[1] = 2;
        for (int i = 2; i < numbers.length; i++) {
            if (i % 4 == 1 || i % 4 == 3) {
                numbers[i] = (numbers[i - 2] + numbers[i - 1]) % 2005;
            } else if (i % 4 == 0) {
                numbers[i] = (numbers[i - 2] + numbers[i - 1] - 1) % 2005;
            } else if (i % 4 == 2) {
                numbers[i] = (numbers[i - 2] + numbers[i - 1] + 1) % 2005;
            }
        } while (cin.hasNextInt() == true) {
            int L = cin.nextInt();
            System.out.println(numbers[L % 200]);
        }
    }
}
