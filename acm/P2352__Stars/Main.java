package P2352__Stars;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.
                in));
        ArrayList<Integer> order = new ArrayList<Integer>();
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int amounts[] = new int[N];
        MyComparator mc = new MyComparator();
        for (int i = 0; i < N; i++) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int index = Collections.binarySearch(order, X, mc);
            index = -index - 1;
            amounts[index]++;
            order.add(index, X);
        }
        for (int i = 0; i < N; i++) {
            System.out.println(amounts[i]);
        }
    }
}


class MyComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        if (a <= b) {
            return -1;
        } else {
            return 1;
        }
    }
}
