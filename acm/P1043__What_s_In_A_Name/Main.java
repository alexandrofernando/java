package P1043__What_s_In_A_Name;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.io.File;

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
    static int n;
    static ArrayList<String> criminal;
    static TreeSet<String> adjacent[];
    static TreeMap<String, String> result;
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        adjacent = new TreeSet[n];
        for (int i = 0; i < n; i++) {
            adjacent[i] = new TreeSet<String> ();
        }
        for (int i = 0; i < n; i++) {
            String userID = cin.next();
            for (int j = 0; j < n; j++) {
                adjacent[j].add(userID);
            }
        }
        criminal = new ArrayList<String> ();
        result = new TreeMap<String, String> ();
        LinkedList<String> present = new LinkedList<String> ();
        String type = cin.next();
        while (type.equals("Q") == false) {
            if (type.equals("E") == true) {
                String temp = cin.next();
                present.add(temp);
                if (criminal.contains(temp) == false) {
                    criminal.add(temp);
                    result.put(temp, "???");
                }
            }
            else if (type.equals("L") == true) {
                present.remove(cin.next());
            }
            else if (type.equals("M") == true) {
                String tempUserID = cin.next();
                ListIterator<String> iterator = present.listIterator();
                for (int i = 0; i < n; i++) {
                    if (i < criminal.size()) {
                        if (present.contains(criminal.get(i)) == false) {
                            adjacent[i].remove(tempUserID);
                        }
                    }
                    else {
                        adjacent[i].remove(tempUserID);
                    }
                }
            }
            type = cin.next();
        }
        for (int i = 0; i < n; i++) {
            Iterator<String> iterator = adjacent[i].iterator();
            while (iterator.hasNext() == true) {
                String temp = iterator.next();
                if (check(i, temp) == false) {
                    result.put(criminal.get(i), temp);
                    for (int j = 0; j < n; j++) {
                        if (j != i) {
                            adjacent[j].remove(temp);
                        }
                    }
                    break;
                }
            }
        }
        Iterator<Entry<String, String>> iterator = result.entrySet().iterator();
        while (iterator.hasNext() == true) {
            Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    static boolean check(int startIndex, String userIDName) {
        TreeSet<String> newSet = new TreeSet<String> (adjacent[startIndex]);
        newSet.remove(userIDName);
        if (newSet.size() == 0) {
            return false;
        }
        return search(startIndex, 0, newSet, 1, userIDName);
    }

    static boolean search(int startIndex, int currentIndex, TreeSet<String>
        previous, int count, String userIDName) {
        if (currentIndex == n) {
            return true;
        }
        if (currentIndex < startIndex &&
            previous.size() >= count + n - currentIndex - 1) {
            return true;
        }
        if (currentIndex > startIndex &&
            previous.size() >= count + n - currentIndex) {
            return true;
        }
        if (currentIndex == startIndex ||
            adjacent[currentIndex].contains(userIDName) == true ||
            result.get(criminal.get(currentIndex)).equals("???") == false) {
            return search(startIndex, currentIndex + 1, previous, count,
                          userIDName);
        }
        TreeSet<String> newSet = new TreeSet<String> (previous);
        if (search(startIndex, currentIndex + 1, newSet, count, userIDName) == false) {
            return false;
        }
        newSet.addAll(adjacent[currentIndex]);
        if (count + 1 > newSet.size()) {
            return false;
        }
        return search(startIndex, currentIndex + 1, newSet, count + 1,
                      userIDName);
    }
}
