package P1143__Number_Game;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeMap;
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
    static TreeMap<Integer, Boolean> map;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        map = new TreeMap<Integer, Boolean> ();
        map.put(0, false);
        int test = 1;
        do {
            int n = cin.nextInt();
            if (n == 0) {
                break;
            }
            ArrayList<Integer> available = new ArrayList<Integer> ();
            for (int i = 0; i < n; i++) {
                available.add(cin.nextInt());
            }
            Collections.sort(available);
            System.out.println("Test Case #" + test);
            test++;
            boolean power = false;
            for (int i = 0; i < available.size(); i++) {
                ArrayList<Integer> after = choose(available, i);
                if (hasWin(after) == false) {
                    if (power == false) {
                        System.out.print("The winning moves are: " +
                                         available.get(i));
                        power = true;
                    }
                    else {
                        System.out.print(" " + available.get(i));
                    }
                }
            }
            if (power == true) {
                System.out.println();
            }
            else {
                System.out.println("There's no winning move.");
            }
            System.out.println();
        }
        while (true);
    }

    static ArrayList<Integer> choose(ArrayList<Integer> a, int index) {
        boolean rest[] = new boolean[21];
        for (int i = 0; i < a.size(); i++) {
            rest[a.get(i)] = true;
        }
        int step = a.get(index);
        rest[step] = false;
        for (int i = 2; i <= 20; i++) {
            if (rest[i] == false) {
                int temp = i + step;
                while (temp <= 20) {
                    rest[temp] = false;
                    temp += step;
                }
            }
        }
        ArrayList<Integer> b = new ArrayList<Integer> ();
        for (int i = 2; i <= 20; i++) {
            if (rest[i] == true) {
                b.add(i);
            }
        }
        return b;
    }

    static boolean hasWin(ArrayList<Integer> a) {
        int index = 0;
        for (int i = 0; i < a.size(); i++) {
            index += Math.pow(2, a.get(i));
        }
        if (map.containsKey(index) == true) {
            return map.get(index);
        }
        for (int i = 0; i < a.size(); i++) {
            ArrayList<Integer> b = choose(a, i);
            if (hasWin(b) == false) {
                map.put(index, true);
                return true;
            }
        }
        map.put(index, false);
        return false;
    }
}
