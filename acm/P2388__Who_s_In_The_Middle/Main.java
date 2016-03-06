package P2388__Who_s_In_The_Middle;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        ArrayList<Integer> outputs = new ArrayList<Integer> ();
        for (int i = 0; i < N; i++) {
            outputs.add(cin.nextInt());
        }
        Collections.sort(outputs);
        System.out.println(outputs.get( (N - 1) / 2));
    }
}
