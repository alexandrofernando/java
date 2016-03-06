package P3444__Wavelet_Compression;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-2-10
 * Time: 17:11:13
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int N = in.nextInt();
            if (N == 0) {
                break;
            }
            int numbers[] = new int[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = in.nextInt();
            }
            for (int i = 1; i <= N / 2; i *= 2) {
                int temp[] = new int[N];
                for (int j = 0; j < i; j++) {
                    temp[j * 2] = (numbers[j] + numbers[j + i]) / 2;
                    temp[j * 2 + 1] = (numbers[j] - numbers[j + i]) / 2;
                }
                for (int j = i * 2; j < N; j++) {
                    temp[j] = numbers[j];
                }
                numbers = temp;
            }
            for (int i = 0; i < N; i++) {
                if (i != 0) {
                    System.out.print(" ");
                }
                System.out.print(numbers[i]);
            }
            System.out.println();
        }
    }
}
