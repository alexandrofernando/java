package P2965__The_Pilots_Brothers_refrigerator;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-2-7
 * Time: 23:02:38
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        boolean changed[][] = new boolean[4][4];
        for (int i = 0; i < 4; i++) {
            String str = in.next();
            for (int j = 0; j < 4; j++) {
                if (str.charAt(j) == '+') {
                    for (int k = 0; k < 4; k++) {
                        changed[i][k] = !changed[i][k];
                    }
                    for (int k = 0; k < 4; k++) {
                        changed[k][j] = !changed[k][j];
                    }
                    changed[i][j] = !changed[i][j];
                }
            }
        }
        ArrayList<Integer> rows = new ArrayList<Integer>();
        ArrayList<Integer> columns = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (changed[i][j]) {
                    rows.add(i + 1);
                    columns.add(j + 1);
                }
            }
        }
        System.out.println(rows.size());
        for (int i = 0; i < rows.size(); i++) {
            System.out.println(rows.get(i) + " " + columns.get(i));
        }
    }
}