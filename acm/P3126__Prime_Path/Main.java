package P3126__Prime_Path;

import java.util.Scanner;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-2
 * Time: 23:54:05
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        boolean primes[] = new boolean[10000];
        for (int i = 1000; i <= 9999; i++) {
            primes[i] = isPrime(i);
        }
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int number1 = in.nextInt();
            int number2 = in.nextInt();
            boolean visited[] = new boolean[10000];
            LinkedList<Number_Step> queue = new LinkedList<Number_Step>();
            queue.offer(new Number_Step(number1, 0));
            visited[number1] = true;
            boolean find = false;
            while (queue.isEmpty() == false) {
                Number_Step head = queue.poll();
                if (head.number == number2) {
                    System.out.println(head.step);
                    find = true;
                    break;
                }
                for (int i = 1; i <= 1000; i *= 10) {
                    int temp = head.number / (i * 10) * (i * 10) + head.number % i;
                    for (int j = 0; j < 10; j++) {
                        int temp1 = temp + j * i;
                        if (visited[temp1] == false && primes[temp1] == true) {
                            queue.offer(new Number_Step(temp1, head.step + 1));
                            visited[temp1] = true;
                        }
                    }
                }
            }
            if (find == false) {
                System.out.println("Impossible");
            }
        }
    }

    static boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class Number_Step {
    int number;
    int step;

    public Number_Step(int theNumber, int theStep) {
        this.number = theNumber;
        this.step = theStep;
    }
}