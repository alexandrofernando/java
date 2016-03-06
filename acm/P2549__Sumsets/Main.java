package P2549__Sumsets;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

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
            int n = cin.nextInt();
            if (n == 0) {
                break;
            }
            int elements[] = new int[n];
            for (int i = 0; i < n; i++) {
                elements[i] = cin.nextInt();
            }
            Arrays.sort(elements);
            Sum sums[] = new Sum[n * (n - 1) / 2];
            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    sums[index] = new Sum(elements[i] + elements[j], elements[i],
                                          elements[j]);
                    index++;
                }
            }
            Arrays.sort(sums);
            boolean find = false;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < n && j != i; j++) {
                    int temp = elements[i] - elements[j];
                    int pos = -Arrays.binarySearch(sums, new Sum(temp, 0, 0)) -
                              1;
                    while (pos < sums.length && sums[pos].sum == temp) {
                        if (elements[i] != sums[pos].add1 &&
                            elements[i] != sums[pos].add2 &&
                            elements[j] != sums[pos].add1 &&
                            elements[j] != sums[pos].add2) {
                            System.out.println(elements[i]);
                            find = true;
                            break;
                        }
                        pos++;
                    }
                    if (find == true) {
                        break;
                    }
                }
                if (find == true) {
                    break;
                }
            }
            if (find == false) {
                System.out.println("no solution");
            }
        }
    }
}


class Sum implements Comparable<Sum> {
    int sum;
    int add1;
    int add2;
    public Sum(int theSum, int theAdd1, int theAdd2) {
        this.sum = theSum;
        this.add1 = theAdd1;
        this.add2 = theAdd2;
    }

    public int compareTo(Sum another) {
        if (this.sum < another.sum) {
            return -1;
        } else {
            return 1;
        }
    }
}
