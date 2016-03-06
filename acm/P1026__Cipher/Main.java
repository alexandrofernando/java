package P1026__Cipher;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

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
        int n = cin.nextInt();
        while (n != 0) {
            int numbers[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                numbers[i] = cin.nextInt();
            }
            ArrayList<ArrayList<Integer>> cycles = new ArrayList<ArrayList<
                Integer>> ();
            int count = 0;
            boolean used[] = new boolean[n + 1];
            while (count < n) {
                int pos = 1;
                while (used[pos] == true) {
                    pos++;
                }
                ArrayList<Integer> s = new ArrayList<Integer> ();
                while (s.contains(pos) == false) {
                    s.add(pos);
                    used[pos] = true;
                    count++;
                    pos = numbers[pos];
                }
                cycles.add(s);
            }
            int K = cin.nextInt();
            while (K != 0) {
                String message = cin.nextLine().substring(1);
                while (message.length() < n) {
                    message = message + " ";
                }
                StringBuffer encoded = new StringBuffer(message);
                for (int i = 0; i < cycles.size(); i++) {
                    ArrayList<Integer> s = cycles.get(i);
                    int offset = K % s.size();
                    for (int j = 0; j < s.size(); j++) {
                        int origin = s.get(j) - 1;
                        int after = s.get( (j + offset) % s.size()) - 1;
                        encoded.setCharAt(after, message.charAt(origin));
                    }
                }
                System.out.println(encoded);
                K = cin.nextInt();
            }
            System.out.println();
            n = cin.nextInt();
        }
    }
}
