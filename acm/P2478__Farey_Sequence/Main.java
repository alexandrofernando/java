package P2478__Farey_Sequence;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-16
 * Time: 7:36:21
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Number numbers[] = new Number[1000001];
        for (int i = 2; i <= 1000000; i++) {
            numbers[i] = new Number(i);
        }
        for (int i = 2; i <= 1000000; i++) {
            if (numbers[i].composite == false) {
                for (int j = i; j <= 1000000; j += i) {
                    numbers[j].composite = true;
                    numbers[j].phi = numbers[j].phi / i * (i - 1);
                }
            }
        }
        numbers[2].N = 1;
        for (int i = 3; i <= 1000000; i++) {
            numbers[i].N = numbers[i - 1].N + numbers[i].phi;
        }
        while (true) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println(numbers[n].N);
        }
    }
}

class Number {
    boolean composite;
    int phi;
    long N;

    public Number(int thePhi) {
        this.composite = false;
        this.phi = thePhi;
    }
}