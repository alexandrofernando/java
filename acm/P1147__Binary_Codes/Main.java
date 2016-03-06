package P1147__Binary_Codes;

import java.util.Scanner;

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
        int N = cin.nextInt();
        int lastColumn[] = new int[N];
        int count1 = 0;
        for (int i = 0; i < N; i++) {
            lastColumn[i] = cin.nextInt();
            if (lastColumn[i] == 1) {
                count1++;
            }
        }
        int firstColumn[] = new int[N];
        for (int i = N - count1; i < N; i++) {
            firstColumn[i] = 1;
        }
        int next[] = new int[N];
        int pos = 0;
        for (int i = 0; i < N; i++) {
            if (lastColumn[i] == 0) {
                next[pos] = i;
                pos++;
            }
        }
        for (int i = 0; i < N; i++) {
            if (lastColumn[i] == 1) {
                next[pos] = i;
                pos++;
            }
        }
        int row = 0;
        for (int i = 0; i < N; i++) {
            System.out.print(firstColumn[row] + " ");
            row = next[row];
        }
        System.out.println();
    }
}
