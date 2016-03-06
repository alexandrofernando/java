package P2411__Mondriaan_s_Dream;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-27
 * Time: 7:57:43
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static long counts[];
    static long temp[];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long results[][] = new long[12][12];
        for (int i = 1; i <= 11; i++) {
            int size = (int) Math.pow(2, i);
            counts = new long[size];
            counts[size - 1] = 1;
            for (int j = 1; j <= 11; j++) {
                temp = new long[size];
                for (int k = 0; k < size; k++) {
                    int current[] = decode(k, i);
                    int previous[] = new int[i];
                    search(current, previous, 0, i, k);
                }
                counts = temp;
                results[i][j] = counts[size - 1];
            }
        }
        while (true) {
            int h = in.nextInt();
            int w = in.nextInt();
            if (h == 0 && w == 0) {
                break;
            }
            System.out.println(results[h][w]);
        }
    }

    static int[] decode(int number, int size) {
        int digits[] = new int[size];
        for (int i = 0; i < size; i++) {
            digits[i] = number % 2;
            number /= 2;
        }
        return digits;
    }

    static int encode(int digits[]) {
        int number = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            number = number * 2 + digits[i];
        }
        return number;
    }

    static void search(int current[], int previous[], int finish, int size, int index) {
        if (finish == size) {
            temp[index] += counts[encode(previous)];
        } else {
            if (current[finish] == 0) {
                previous[finish] = 1;
                search(current, previous, finish + 1, size, index);
            } else {
                previous[finish] = 0;
                search(current, previous, finish + 1, size, index);
                if (finish + 1 < size && current[finish + 1] == 1) {
                    previous[finish] = 1;
                    previous[finish + 1] = 1;
                    search(current, previous, finish + 2, size, index);
                }
            }
        }
    }
}
