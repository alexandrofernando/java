package P2668__Defending_Castle;

import java.util.Scanner;
import java.io.File;
import java.util.Stack;

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
        while (true) {
            int D = cin.nextInt();
            int N = cin.nextInt();
            if (D == 0 && N == 0) {
                break;
            }
            long total = 0;
            Stack<Integer> stack = new Stack<Integer>();
            int previous = 0;
            int d = 0;
            for (int i = 1; i <= N && i * i <= D; i++) {
                int damage = (int) Math.ceil((double) D / i);
                total += damage;
                stack.push(damage);
                previous = i;
                d = i;
            }
            boolean power = true;
            while (N > previous) {
                if (stack.empty() == false) {
                    int top = stack.pop();
                    if (power == true) {
                        if (N >= top) {
                            for (int i = previous + 1; i <= top; i++) {
                                int damage = (int) Math.ceil((double) D / i);
                                total += damage;
                            }
                            previous = top;
                        } else {
                            for (int i = previous + 1; i <= N; i++) {
                                int damage = (int) Math.ceil((double) D / i);
                                total += damage;
                            }
                            previous = N;
                        }
                        power = false;
                    } else if (top - 1 >= previous) {
                        if (N >= top - 1) {
                            total += (top - previous - 1) * d;
                            previous = top - 1;
                        } else {
                            total += (N - previous) * d;
                            previous = N;
                        }
                        d--;
                    }
                } else {
                    total += N - previous;
                    previous = N;
                }
            }
            System.out.println(total);
        }
    }
}
