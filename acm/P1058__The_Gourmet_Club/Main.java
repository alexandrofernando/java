package P1058__The_Gourmet_Club;

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
    static ArrayList<Integer> allow[];
    static ArrayList<Integer> schedule[][];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext() == true) {
            allow = new ArrayList[16];
            for (int i = 0; i < 16; i++) {
                allow[i] = new ArrayList<Integer> ();
                for (int j = 0; j < 16; j++) {
                    if (j != i) {
                        allow[i].add(j);
                    }
                }
            }
            schedule = new ArrayList[5][4];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 4; j++) {
                    schedule[i][j] = new ArrayList<Integer> ();
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    String temp = cin.next();
                    for (int k = 0; k < 4; k++) {
                        schedule[i][j].add(temp.charAt(k) - 'A');
                        for (int p = k + 1; p < 4; p++) {
                            int index1 = temp.charAt(k) - 'A';
                            int index2 = temp.charAt(p) - 'A';
                            allow[index1].remove(new Integer(index2));
                            allow[index2].remove(new Integer(index1));
                        }
                    }
                }
            }
            boolean completable = true;
            for (int i = 0; i < 16; i++) {
                if (allow[i].size() != 6) {
                    completable = false;
                    break;
                }
            }
            if (completable == true) {
                completable = search(3, 0);
            }
            if (completable == true) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (j != 0) {
                            System.out.print(" ");
                        }
                        for (int k = 0; k < 4; k++) {
                            System.out.print( (char) ('A' +
                                schedule[i][j].get(k)));
                        }
                    }
                    System.out.println();
                }
            }
            else {
                System.out.println(
                    "It is not possible to complete this schedule.");
            }
            System.out.println();
        }
    }

    static boolean search(int day, int index) {
        if (index == 16) {
            if (day == 4) {
                return true;
            }
            else if (day == 3) {
                index = 0;
                day = 4;
            }
        }
        for (int i = 0; i < 4; i++) {
            boolean power = true;
            if (schedule[day][i].size() >= 4) {
                power = false;
            }
            else {
                for (int j = 0; j < schedule[day][i].size(); j++) {
                    if (allow[index].contains(schedule[day][i].get(j)) == false) {
                        power = false;
                        break;
                    }
                }
            }
            if (power == true) {
                for (int j = 0; j < schedule[day][i].size(); j++) {
                    int temp = schedule[day][i].get(j);
                    allow[index].remove(new Integer(temp));
                    allow[temp].remove(new Integer(index));
                }
                schedule[day][i].add(index);
                if (search(day, index + 1) == true) {
                    return true;
                }
                schedule[day][i].remove(new Integer(index));
                for (int j = 0; j < schedule[day][i].size(); j++) {
                    int temp = schedule[day][i].get(j);
                    allow[index].add(new Integer(temp));
                    allow[temp].add(new Integer(index));
                }
            }
        }
        return false;
    }
}
