package P1040__Transportation;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

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
    static int maxTotal;
    static int restSum[];
    static int restCapacity[];
    static Order orders[];
    static int orderNumber;
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int capacity = cin.nextInt();
        int stationNumber = cin.nextInt();
        orderNumber = cin.nextInt();
        while (capacity != 0 || stationNumber != 0 || orderNumber != 0) {
            stationNumber++;
            orders = new Order[orderNumber];
            for (int i = 0; i < orderNumber; i++) {
                orders[i] = new Order(cin.nextInt(), cin.nextInt(), cin.nextInt());
            }
            Arrays.sort(orders, new MyComparator());
            restSum = new int[orderNumber];
            for (int i = 0; i < orderNumber; i++) {
                int temp = 0;
                for (int j = i; j < orderNumber; j++) {
                    temp += orders[j].earning;
                }
                restSum[i] = temp;
            }
            restCapacity = new int[stationNumber];
            for (int i = 0; i < stationNumber; i++) {
                restCapacity[i] = capacity;
            }
            maxTotal = 0;
            search(0, 0);
            System.out.println(maxTotal);
            capacity = cin.nextInt();
            stationNumber = cin.nextInt();
            orderNumber = cin.nextInt();
        }
    }

    static void search(int orderIndex, int currentEarning) {
        if (orderIndex >= orderNumber) {
            if (currentEarning > maxTotal) {
                maxTotal = currentEarning;
            }
            return;
        }
        if (currentEarning + restSum[orderIndex] < maxTotal) {
            return;
        }
        boolean possible = true;
        for (int i = orders[orderIndex].start; i < orders[orderIndex].end; i++) {
            if (orders[orderIndex].passenger > restCapacity[i]) {
                possible = false;
                break;
            }
        }
        if (possible == true) {
            for (int i = orders[orderIndex].start; i < orders[orderIndex].end;
                 i++) {
                restCapacity[i] -= orders[orderIndex].passenger;
            }
            search(orderIndex + 1, currentEarning + orders[orderIndex].earning);
            for (int i = orders[orderIndex].start; i < orders[orderIndex].end;
                 i++) {
                restCapacity[i] += orders[orderIndex].passenger;
            }
        }
        search(orderIndex + 1, currentEarning);
    }
}

class MyComparator
    implements Comparator<Order> {
    public int compare(Order a, Order b) {
        return b.earning - a.earning;
    }
}

class Order {
    int start, end, passenger;
    int earning;
    public Order(int theStart, int theEnd, int thePassenger) {
        this.start = theStart;
        this.end = theEnd;
        this.passenger = thePassenger;
        this.earning = (theEnd - theStart) * thePassenger;
    }
}
