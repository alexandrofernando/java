package P1844__Sum;

import java.util.Scanner;

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
        int S = cin.nextInt();
        int result = 1;
        int sum = 1;
        while (true) {
            if (sum >= S && (sum - S) % 2 == 0) {
                System.out.println(result);
                break;
            }
            result++;
            sum += result;
        }
    }
}
