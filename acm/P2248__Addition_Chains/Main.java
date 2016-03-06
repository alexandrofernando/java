package P2248__Addition_Chains;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-5-23
 * Time: 21:59:47
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int steps[];
    static int minLen;
    static int minChains[];
    static int curChains[];
    static int n;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            n = in.nextInt();
            if (n == 0) {
                break;
            }
            steps = new int[n + 1];
            for (int i = n; i >= 1; i--) {
                if (i == n) {
                    steps[i] = 0;
                } else if (i + i >= n) {
                    steps[i] = 1;
                } else {
                    steps[i] = 1 + steps[i + i];
                }
            }
            minLen = Integer.MAX_VALUE;
            minChains = new int[n];
            curChains = new int[n];
            curChains[0] = 1;
            search(0);
            for (int i = 0; i < minLen - 1; i++) {
                System.out.print(minChains[i] + " ");
            }
            System.out.println(minChains[minLen - 1]);
        }
    }

    static void search(int index) {
        if (index + 1 + steps[curChains[index]] >= minLen) {
            return;
        }
        if (curChains[index] == n) {
            minLen = index + 1;
            for (int i = 0; i <= index; i++) {
                minChains[i] = curChains[i];
            }
            return;
        }
        for (int i = index; i >= 0; i--) {
            for (int j = index; j >= i; j--) {
                curChains[index + 1] = curChains[i] + curChains[j];
                if (curChains[index + 1] > curChains[index] && curChains[index + 1] <= n) {
                    search(index + 1);
                }
            }
        }
    }
}
