package P2287__Tian_Ji_The_Horse_Racing;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-21
 * Time: 2:14:59
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
            int horse1[] = new int[n];
            int horse2[] = new int[n];
            for (int i = 0; i < n; i++) {
                horse1[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                horse2[i] = in.nextInt();
            }
            Arrays.sort(horse1);
            Arrays.sort(horse2);
            int win = -1;
            int money = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (n - i <= win) {
                    break;
                }
                int count = 0;
                int tempMoney = -i * 200;
                for (int j = 0; j < n; j++) {
                    if (j - i >= 0) {
                        if (horse1[j] > horse2[j - i]) {
                            count++;
                            tempMoney += 200;
                        } else if (horse1[j] < horse2[j - i]) {
                            tempMoney -= 200;
                        }
                    }
                }
                if (count > win) {
                    money = tempMoney;
                    win = count;
                }
            }
            System.out.println(money);
        }
    }
}
