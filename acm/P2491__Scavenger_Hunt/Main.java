package P2491__Scavenger_Hunt;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int step = cin.nextInt();
            ArrayList<LinkedList<String>>
                    array = new ArrayList<LinkedList<String>>();
            for (int i = 0; i < step - 1; i++) {
                String start = cin.next();
                String end = cin.next();
                int index1 = -1;
                for (int j = 0; j < array.size(); j++) {
                    if (array.get(j).getLast().equals(start) == true) {
                        index1 = j;
                        break;
                    }
                }
                int index2 = -1;
                for (int j = 0; j < array.size(); j++) {
                    if (array.get(j).getFirst().equals(end) == true) {
                        index2 = j;
                        break;
                    }
                }
                if (index1 != -1 && index2 != -1) {
                    array.get(index1).addAll(array.get(index2));
                    array.remove(index2);
                } else if (index1 != -1 && index2 == -1) {
                    array.get(index1).add(end);
                } else if (index1 == -1 && index2 != -1) {
                    array.get(index2).addFirst(start);
                } else if (index1 == -1 && index2 == -1) {
                    LinkedList<String> link = new LinkedList<String>();
                    link.add(start);
                    link.add(end);
                    array.add(link);
                }
            }
            System.out.println("Scenario #" + t + ":");
            ListIterator<String> iterator = array.get(0).listIterator();
            while (iterator.hasNext() == true) {
                System.out.println(iterator.next());
            }
            System.out.println();
        }
    }
}
