package P1230__Pass_Muraille;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

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
    static int rights[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = cin.nextInt();
            int K = cin.nextInt();
            rights = new int[n];
            ArrayList<Integer> columns[] = new ArrayList[101];
            for (int i = 0; i < columns.length; i++) {
                columns[i] = new ArrayList<Integer> ();
            }
            for (int i = 0; i < n; i++) {
                int x1 = cin.nextInt();
                int y1 = cin.nextInt();
                int x2 = cin.nextInt();
                int y2 = cin.nextInt();
                int leftX;
                int rightX;
                if (x1 < x2) {
                    leftX = x1;
                    rightX = x2;
                }
                else {
                    leftX = x2;
                    rightX = x1;
                }
                rights[i] = rightX;
                for (int j = leftX; j <= rightX; j++) {
                    columns[j].add(i);
                }
            }
            int result = 0;
            for (int i = 0; i < columns.length; i++) {
                if (columns[i].size() > K) {
                    result += columns[i].size() - K;
                    Collections.sort(columns[i], new MyComparator());
                    for (int j = K; j < columns[i].size(); j++) {
                        int index = columns[i].get(j);
                        for (int k = i + 1; k <= rights[index]; k++) {
                            columns[k].remove(new Integer(index));
                        }
                    }
                }
            }
            System.out.println(result);
        }
    }

    static class MyComparator
        implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return rights[a] - rights[b];
        }
    }
}
