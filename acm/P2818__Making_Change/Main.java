package P2818__Making_Change;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-27
 * Time: 21:53:52
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int Q = in.nextInt();
            int D = in.nextInt();
            int N = in.nextInt();
            int P = in.nextInt();
            int C = in.nextInt();
            if (Q == 0 && D == 0 && N == 0 && P == 0 && C == 0) {
                break;
            }
            int quarter = 0;
            int dime = 0;
            int nickel = 0;
            int penny = 0;
            int total = Integer.MAX_VALUE;
            for (int tempQ = Q * 25 > C ? C / 25 : Q; tempQ >= 0; tempQ--) {
                int rest = C;
                rest -= tempQ * 25;
                int tempD = rest / 10;
                if (tempD > D) {
                    tempD = D;
                }
                rest -= tempD * 10;
                int tempN = rest / 5;
                if (tempN > N) {
                    tempN = N;
                }
                rest -= tempN * 5;
                int tempP = rest;
                if (tempP > P) {
                    tempP = P;
                }
                rest -= tempP;
                int tempTotal = tempQ + tempD + tempN + tempP;
                if (rest == 0 && tempTotal < total) {
                    quarter = tempQ;
                    dime = tempD;
                    nickel = tempN;
                    penny = tempP;
                    total = tempTotal;
                }
            }
            if (total == Integer.MAX_VALUE) {
                System.out.println("Cannot dispense the desired amount.");
            } else {
                System.out.println("Dispense " + quarter + " quarters, " + dime + " dimes, " + nickel + " nickels, and " + penny + " pennies.");
            }
        }
    }
}
