package P1456__Supermarket;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-14
 * Time: 0:41:36
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt() == true) {
            int n = in.nextInt();
            Product products[] = new Product[n];
            for (int i = 0; i < n; i++) {
                products[i] = new Product(in.nextInt(), in.nextInt());
            }
            Arrays.sort(products);
            boolean schedule[] = new boolean[10001];
            int total = 0;
            for (int i = 0; i < n; i++) {
                for (int j = products[i].deadline; j >= 1; j--) {
                    if (schedule[j] == false) {
                        schedule[j] = true;
                        total += products[i].profit;
                        break;
                    }
                }
            }
            System.out.println(total);
        }
    }
}

class Product implements Comparable<Product> {
    int profit;
    int deadline;

    public Product(int theProfit, int theDeadline) {
        this.profit = theProfit;
        this.deadline = theDeadline;
    }

    public int compareTo(Product another) {
        return another.profit - this.profit;
    }
}