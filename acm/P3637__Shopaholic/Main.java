package P3637__Shopaholic;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-1-11
 * Time: 2:11:25
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = in.nextInt();
            int prices[] = new int[n];
            for (int i = 0; i < n; i++) {
                prices[i] = in.nextInt();
            }
            Arrays.sort(prices);
            int discount = 0;
            for (int i = 2; i < n; i += 3) {
                discount += prices[n - 1 - i];
            }
            System.out.println(discount);
        }
    }
}
