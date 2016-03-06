package P1038__Bugs_Integrated_Inc;

import java.util.Scanner;
import java.io.File;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map.Entry;

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
    static int m;
    static TreeMap<Integer, Integer> max[];
    static int index;
    static int empty[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = cin.nextInt();
            m = cin.nextInt();
            boolean bad[][] = new boolean[n + 1][m + 1];
            int badNumber = cin.nextInt();
            for (int i = 0; i < badNumber; i++) {
                bad[cin.nextInt()][cin.nextInt()] = true;
            }
            max = new TreeMap[2];
            for (int i = 0; i < 2; i++) {
                max[i] = new TreeMap<Integer, Integer> ();
            }
            index = 1;
            max[0].put(0, 0);
            for (int i = 1; i <= n; i++) {
                max[index] = new TreeMap<Integer, Integer> ();
                Iterator<Entry<Integer,
                    Integer>> iterator = max[ (index + 1) %
                    2].entrySet().iterator();
                while (iterator.hasNext() == true) {
                    Entry<Integer, Integer> one = iterator.next();
                    empty = decode(one.getKey());
                    for (int j = 1; j <= m; j++) {
                        if (bad[i][j] == true) {
                            empty[j] = 0;
                        }
                        else {
                            empty[j]++;
                        }
                    }
                    search(1, one.getValue());
                }
                index = (index + 1) % 2;
            }
            index = (index + 1) % 2;
            int result = -1;
            Iterator<Entry<Integer,
                Integer>> iterator = max[index].entrySet().iterator();
            while (iterator.hasNext() == true) {
                Entry<Integer, Integer> one = iterator.next();
                if (one.getValue() > result) {
                    result = one.getValue();
                }
            }
            System.out.println(result);
        }
    }

    static int[] decode(int number) {
        int result[] = new int[m + 1];
        for (int i = m; i >= 1; i--) {
            result[i] = number % 3;
            number /= 3;
        }
        return result;
    }

    static int encode(int a[]) {
        int result = 0;
        for (int i = 1; i <= m; i++) {
            if (a[i] == 3) {
                result = result * 3 + 2;
            }
            else {
                result = result * 3 + a[i];
            }
        }
        return result;
    }

    static void search(int column, int chips) {
        if (column > m) {
            int number = encode(empty);
            if (max[index].containsKey(number) == false ||
                max[index].get(number) < chips) {
                max[index].put(number, chips);
            }
        }
        else {
            search(column + 1, chips);
            if (column + 1 <= m && empty[column] == 3 && empty[column + 1] == 3) {
                empty[column] = 0;
                empty[column + 1] = 0;
                search(column + 2, chips + 1);
                empty[column] = 3;
                empty[column + 1] = 3;
            }
            if (column + 2 <= m && empty[column] >= 2 && empty[column + 1] >= 2 &&
                empty[column + 2] >= 2) {
                int save0 = empty[column];
                int save1 = empty[column + 1];
                int save2 = empty[column + 2];
                empty[column] = 0;
                empty[column + 1] = 0;
                empty[column + 2] = 0;
                search(column + 3, chips + 1);
                empty[column] = save0;
                empty[column + 1] = save1;
                empty[column + 2] = save2;
            }
        }
    }
}
