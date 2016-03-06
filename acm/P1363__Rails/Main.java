package P1363__Rails;

import java.util.Scanner;
import java.io.File;
import java.util.Stack;

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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        do {
            int N = cin.nextInt();
            if (N == 0) {
                break;
            }
            do {
                int B[] = new int[N];
                B[0] = cin.nextInt();
                if (B[0] == 0) {
                    break;
                }
                for (int i = 1; i < N; i++) {
                    B[i] = cin.nextInt();
                }
                int finish = 0;
                int A = 1;
                Stack<Integer> station = new Stack<Integer> ();
                boolean possible = true;
                while (finish < N) {
                    if (B[finish] == A) {
                        A++;
                        finish++;
                    }
                    else if (station.empty() == false &&
                             station.peek() == B[finish]) {
                        station.pop();
                        finish++;
                    }
                    else if (A <= N) {
                        station.push(A);
                        A++;
                    }
                    else {
                        possible = false;
                        break;
                    }
                }
                if (possible == true) {
                    System.out.println("Yes");
                }
                else {
                    System.out.println("No");
                }
            }
            while (true);
            System.out.println();
        }
        while (true);
    }
}
