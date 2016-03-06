package P1564__Sum_It_Up;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-26
 * Time: 0:38:08
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static ArrayList<Number_Count> list;
    static boolean exist;
    static Stack<Integer> numbers;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int T = in.nextInt();
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            list = new ArrayList<Number_Count>();
            int total = 0;
            for (int i = 0; i < n; i++) {
                int number = in.nextInt();
                total += number;
                boolean same = false;
                if (list.isEmpty() == false) {
                    Number_Count nc = list.get(list.size() - 1);
                    if (nc.number == number) {
                        nc.count++;
                        same = true;
                    }
                }
                if (same == false) {
                    list.add(new Number_Count(number, 1));
                }
            }
            System.out.println("Sums of " + T + ":");
            exist = false;
            numbers = new Stack<Integer>();
            search(0, T, total);
            if (exist == false) {
                System.out.println("NONE");
            }
        }
    }

    static void search(int index, int target, int rest) {
        if (index == list.size()) {
            if (target == 0) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (i != 0) {
                        System.out.print("+");
                    }
                    System.out.print(numbers.get(i));
                }
                System.out.println();
                exist = true;
            }
        } else if (target >= 0 && target <= rest) {
            Number_Count nc = list.get(index);
            int top = Math.min(target / nc.number, nc.count);
            for (int i = top; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    numbers.push(nc.number);
                }
                search(index + 1, target - i * nc.number, rest - nc.number * nc.count);
                for (int j = 0; j < i; j++) {
                    numbers.pop();
                }
            }
        }
    }
}

class Number_Count {
    int number;
    int count;

    public Number_Count(int theNumber, int theCount) {
        this.number = theNumber;
        this.count = theCount;
    }
}