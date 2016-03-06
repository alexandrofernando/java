package P1085__Triangle_War;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Iterator;
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
    static TreeMap<Line, ArrayList<Line[]>> map;
    static TreeMap<Line, Boolean> lines;
    static int count[] = new int[2];
    static int index;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        map = new TreeMap<Line, ArrayList<Line[]>> ();
        lines = new TreeMap<Line, Boolean> ();
        insert(1, 2, 3);
        insert(2, 4, 5);
        insert(2, 3, 5);
        insert(3, 5, 6);
        insert(4, 7, 8);
        insert(4, 5, 8);
        insert(5, 8, 9);
        insert(5, 6, 9);
        insert(6, 9, 10);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            count[0] = 0;
            count[1] = 0;
            init();
            int turn = 0;
            int m = cin.nextInt();
            for (int i = 0; i < m; i++) {
                Line line = new Line(cin.nextInt(), cin.nextInt());
                lines.put(line, true);
                int triangle = CountTriangle(line);
                if (triangle == 0) {
                    turn = (turn + 1) % 2;
                }
                else {
                    count[turn] += triangle;
                }
            }
            index = convert();
            System.out.print("Game " + t + ": ");
            if (count[0] >= 5) {
                System.out.println("A wins.");
            }
            else if (count[1] >= 5) {
                System.out.println("B wins.");
            }
            else if (search(turn) == true) {
                if (turn == 0) {
                    System.out.println("A wins.");
                }
                else {
                    System.out.println("B wins.");
                }
            }
            else {
                if (turn == 0) {
                    System.out.println("B wins.");
                }
                else {
                    System.out.println("A wins.");
                }
            }
        }
    }

    static int CountTriangle(Line line) {
        int count = 0;
        ArrayList<Line[]> array = map.get(line);
        for (int i = 0; i < array.size(); i++) {
            boolean power = true;
            Line two[] = array.get(i);
            for (int j = 0; j < two.length; j++) {
                if (lines.get(two[j]) == false) {
                    power = false;
                    break;
                }
            }
            if (power == true) {
                count++;
            }
        }
        return count;
    }

    static boolean search(int turn) {
        int pos = 0;
        Iterator<Entry<Line, Boolean>> iterator = lines.entrySet().iterator();
        while (iterator.hasNext() == true) {
            Entry<Line, Boolean> entry = iterator.next();
            if (entry.getValue() == false) {
                int triangle = CountTriangle(entry.getKey());
                if (triangle > 0) {
                    index += Math.pow(2, 17 - pos);
                    entry.setValue(true);
                    count[turn] += triangle;
                    if (count[turn] >= 5) {
                        count[turn] -= triangle;
                        index -= Math.pow(2, 17 - pos);
                        entry.setValue(false);
                        return true;
                    }
                    boolean temp = search(turn);
                    count[turn] -= triangle;
                    index -= Math.pow(2, 17 - pos);
                    entry.setValue(false);
                    if (temp == true) {
                        return true;
                    }
                }
            }
            pos++;
        }
        pos = 0;
        iterator = lines.entrySet().iterator();
        while (iterator.hasNext() == true) {
            Entry<Line, Boolean> entry = iterator.next();
            if (entry.getValue() == false) {
                int triangle = CountTriangle(entry.getKey());
                if (triangle == 0) {
                    index += Math.pow(2, 17 - pos);
                    entry.setValue(true);
                    boolean temp = search( (turn + 1) % 2);
                    index -= Math.pow(2, 17 - pos);
                    entry.setValue(false);
                    if (temp == false) {
                        return true;
                    }
                }
            }
            pos++;
        }
        return false;
    }

    static int convert() {
        int result = 0;
        Iterator<Entry<Line, Boolean>> iterator = lines.entrySet().iterator();
        while (iterator.hasNext() == true) {
            if (iterator.next().getValue() == true) {
                result = result * 2 + 1;
            }
            else {
                result *= 2;
            }
        }
        return result;
    }

    static void init() {
        Iterator<Entry<Line, Boolean>> iterator = lines.entrySet().iterator();
        while (iterator.hasNext() == true) {
            iterator.next().setValue(false);
        }
    }

    static void insert(int p1, int p2, int p3) {
        int points[] = {
            p1, p2, p3};
        for (int i = 0; i < 3; i++) {
            ArrayList<Line[]>
                array = map.get(new Line(points[ (i + 1) % 3],
                                         points[ (i + 2) % 3]));
            if (array == null) {
                array = new ArrayList<Line[]> ();
            }
            Line twoLines[] = new Line[2];
            twoLines[0] = new Line(points[i], points[ (i + 1) % 3]);
            twoLines[1] = new Line(points[i], points[ (i + 2) % 3]);
            array.add(twoLines);
            map.put(new Line(points[ (i + 1) % 3], points[ (i + 2) % 3]), array);
            lines.put(new Line(points[i], points[ (i + 1) % 3]), false);
        }
    }
}

class Line
    implements Comparable<Line> {
    int p1;
    int p2;
    public Line(int P1, int P2) {
        if (P1 < P2) {
            this.p1 = P1;
            this.p2 = P2;
        }
        else {
            this.p2 = P1;
            this.p1 = P2;
        }
    }

    public int compareTo(Line another) {
        if (this.p1 != another.p1) {
            return this.p1 - another.p1;
        }
        else {
            return this.p2 - another.p2;
        }
    }
}
