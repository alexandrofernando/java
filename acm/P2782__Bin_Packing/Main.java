package P2782__Bin_Packing;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

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
        int n = cin.nextInt();
        int L = cin.nextInt();
        ArrayList<Integer> lengths = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            lengths.add(cin.nextInt());
        }
        Collections.sort(lengths);
        int bin = 0;
        while (lengths.isEmpty() == false) {
            int L1 = lengths.remove(lengths.size() - 1);
            int rest = L - L1;
            int index = Collections.binarySearch(lengths, rest);
            if (index >= 0) {
                lengths.remove(index);
            } else {
                index = -index - 1;
                if (index > 0) {
                    lengths.remove(index - 1);
                }
            }
            bin++;
        }
        System.out.println(bin);
    }
}
