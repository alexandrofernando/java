package P3239__Solution_to_the_n_Queens_Puzzle;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-1-20
 * Time: 20:21:48
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
            int solution[] = new int[n];
            if (n % 6 != 2 && n % 6 != 3) {
                if (n % 2 == 0) {
                    for (int i = 0; i <= n / 2 - 1; i++) {
                        solution[i] = i * 2 + 2;
                    }
                    for (int i = n / 2; i <= n - 1; i++) {
                        solution[i] = i * 2 - n + 1;
                    }
                } else {
                    for (int i = 0; i <= (n - 1) / 2 - 1; i++) {
                        solution[i] = i * 2 + 2;
                    }
                    for (int i = (n - 1) / 2; i <= n - 1; i++) {
                        solution[i] = i * 2 - n + 2;
                    }
                }
            } else {
                if (n % 2 == 0) {
                    int m = n / 2;
                    if (m % 2 == 0) {
                        for (int i = 0; i <= (n - m) / 2; i++) {
                            solution[i] = i * 2 + m;
                        }
                        for (int i = (n - m) / 2 + 1; i <= n / 2 - 1; i++) {
                            solution[i] = i * 2 - n + m;
                        }
                        for (int i = n / 2; i <= n - m / 2 - 2; i++) {
                            solution[i] = i * 2 - n + m + 3;
                        }
                        for (int i = n - m / 2 - 1; i <= n - 1; i++) {
                            solution[i] = i * 2 - n * 2 + m + 3;
                        }
                    } else {
                        for (int i = 0; i <= (n - m - 1) / 2; i++) {
                            solution[i] = i * 2 + m;
                        }
                        for (int i = (n - m + 1) / 2; i <= n / 2 - 1; i++) {
                            solution[i] = i * 2 - n + m;
                        }
                        for (int i = n / 2; i <= n - (m + 3) / 2; i++) {
                            solution[i] = i * 2 - n + m + 3;
                        }
                        for (int i = n - (m + 1) / 2; i <= n - 1; i++) {
                            solution[i] = i * 2 - n * 2 + m + 3;
                        }
                    }
                } else {
                    int m = (n - 1) / 2;
                    if (m % 2 == 0) {
                        for (int i = 0; i <= (n - m - 1) / 2; i++) {
                            solution[i] = i * 2 + m;
                        }
                        for (int i = (n - m + 1) / 2; i <= (n - 3) / 2; i++) {
                            solution[i] = i * 2 - n + m + 1;
                        }
                        for (int i = (n - 1) / 2; i <= n - m / 2 - 3; i++) {
                            solution[i] = i * 2 - n + m + 4;
                        }
                        for (int i = n - m / 2 - 2; i <= n - 2; i++) {
                            solution[i] = i * 2 - n * 2 + m + 5;
                        }
                        solution[n - 1] = n;
                    } else {
                        for (int i = 0; i <= (n - m) / 2 - 1; i++) {
                            solution[i] = i * 2 + m;
                        }
                        for (int i = (n - m) / 2; i <= (n - 3) / 2; i++) {
                            solution[i] = i * 2 - n + m + 1;
                        }
                        for (int i = (n - 1) / 2; i <= n - (m + 5) / 2; i++) {
                            solution[i] = i * 2 - n + m + 4;
                        }
                        for (int i = n - (m + 3) / 2; i <= n - 2; i++) {
                            solution[i] = i * 2 - n * 2 + m + 5;
                        }
                        solution[n - 1] = n;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (i != 0) {
                    System.out.print(" ");
                }
                System.out.print(solution[i]);
            }
            System.out.println();
        }
    }
}
