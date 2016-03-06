package P1384__Piggy_Bank;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int E = cin.nextInt();
            int F = cin.nextInt();
            int target = F - E;
            int N = cin.nextInt();
            Coin coins[] = new Coin[N];
            for (int i = 0; i < N; i++) {
                coins[i] = new Coin(cin.nextInt(), cin.nextInt());
            }
            int min[] = new int[target + 1];
            min[0] = 0;
            for (int i = 1; i < min.length; i++) {
                min[i] = Integer.MAX_VALUE;
                for (int j = 0; j < N; j++) {
                    if (i - coins[j].weight >= 0 &&
                        min[i - coins[j].weight] != Integer.MAX_VALUE &&
                        min[i - coins[j].weight] + coins[j].value < min[i]) {
                        min[i] = min[i - coins[j].weight] + coins[j].value;
                    }
                }
            }
            if (min[target] == Integer.MAX_VALUE) {
                System.out.println("This is impossible.");
            } else {
                System.out.println(
                        "The minimum amount of money in the piggy-bank is " +
                        min[target] + ".");
            }
        }
    }
}


class Coin {
    int value;
    int weight;
    public Coin(int theValue, int theWeight) {
        this.value = theValue;
        this.weight = theWeight;
    }
}
