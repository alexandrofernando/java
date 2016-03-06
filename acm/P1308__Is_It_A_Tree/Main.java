package P1308__Is_It_A_Tree;

import java.util.Scanner;
import java.io.File;
import java.util.TreeSet;

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
        int test = 1;
        while (true) {
            int start = cin.nextInt();
            int end = cin.nextInt();
            if (start < 0 && end < 0) {
                break;
            }
            boolean tree = true;
            TreeSet<Integer> nodes = new TreeSet<Integer>();
            TreeSet<Integer> ends = new TreeSet<Integer>();
            int nodeNumber = 0;
            while (start != 0 || end != 0) {
                if (tree == true) {
                    if (start == end || ends.contains(end) == true) {
                        tree = false;
                    } else {
                        ends.add(end);
                        if (nodes.contains(start) == false) {
                            nodes.add(start);
                            nodeNumber++;
                        }
                        if (nodes.contains(end) == false) {
                            nodes.add(end);
                            nodeNumber++;
                        }
                    }
                }
                start = cin.nextInt();
                end = cin.nextInt();
            }
            if (tree == true && nodeNumber != 0 &&
                ends.size() != nodeNumber - 1) {
                tree = false;
            }
            if (tree == true) {
                System.out.println("Case " + test + " is a tree.");
            } else {
                System.out.println("Case " + test + " is not a tree.");
            }
            test++;
        }
    }
}
