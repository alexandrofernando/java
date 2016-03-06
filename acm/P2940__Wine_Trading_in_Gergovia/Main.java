package P2940__Wine_Trading_in_Gergovia;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-18
 * Time: 20:33:25
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
            int needs[] = new int[n];
            for (int i = 0; i < n; i++) {
                needs[i] = in.nextInt();
            }
            long work = 0;
            int positive = -1;
            int negtive = -1;
            boolean movePos = true;
            boolean moveNeg = true;
            while (true) {
                if (movePos == true) {
                    do {
                        positive++;
                    } while (positive < n && needs[positive] <= 0);
                    if (positive == n) {
                        break;
                    }
                }
                if (moveNeg == true) {
                    do {
                        negtive++;
                    } while (needs[negtive] >= 0);
                }
                int sum = needs[positive] + needs[negtive];
                if (sum > 0) {
                    work += Math.abs((positive - negtive) * needs[negtive]);
                    needs[positive] = sum;
                    movePos = false;
                    moveNeg = true;
                } else if (sum < 0) {
                    work += Math.abs((positive - negtive) * needs[positive]);
                    needs[negtive] = sum;
                    movePos = true;
                    moveNeg = false;
                } else {
                    work += Math.abs((positive - negtive) * needs[positive]);
                    movePos = true;
                    moveNeg = true;
                }
            }
            System.out.println(work);
        }
    }
}
