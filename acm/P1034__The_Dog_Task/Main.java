package P1034__The_Dog_Task;

import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;
import java.util.Iterator;

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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        Point points1[] = new Point[n];
        for (int i = 0; i < n; i++) {
            points1[i] = new Point(cin.nextInt(), cin.nextInt());
        }
        Point points2[] = new Point[m];
        for (int i = 0; i < m; i++) {
            points2[i] = new Point(cin.nextInt(), cin.nextInt());
        }
        LinkedList<Integer> adjacent1[] = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adjacent1[i] = new LinkedList<Integer> ();
        }
        LinkedList<Integer> adjacent2[] = new LinkedList[m];
        for (int i = 0; i < m; i++) {
            adjacent2[i] = new LinkedList<Integer> ();
        }
        for (int i = 0; i < n - 1; i++) {
            double dis = points1[i].distance(points1[i + 1]);
            for (int j = 0; j < m; j++) {
                if (points1[i].distance(points2[j]) +
                    points1[i + 1].distance(points2[j]) <= dis * 2) {
                    adjacent1[i].add(j);
                    adjacent2[j].add(i);
                }
            }
        }
        int vertex1[] = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            vertex1[i] = -1;
        }
        int vertex2[] = new int[m];
        for (int i = 0; i < m; i++) {
            vertex2[i] = -1;
        }
        int extra = 0;
        boolean find;
        do {
            find = false;
            int mark1[] = new int[n - 1];
            int mark2[] = new int[m];
            for (int i = 0; i < n - 1; i++) {
                mark1[i] = -1;
            }
            for (int i = 0; i < m; i++) {
                mark2[i] = -1;
            }
            LinkedList<Element> queue = new LinkedList<Element> ();
            for (int i = 0; i < n - 1; i++) {
                if (vertex1[i] == -1) {
                    mark1[i] = -2;
                    queue.offer(new Element(i, 1));
                }
            }
            Iterator<Integer> iterator;
            while (queue.isEmpty() == false) {
                Element temp = queue.poll();
                if (temp.group == 1) {
                    iterator = adjacent1[temp.index].iterator();
                    while (iterator.hasNext() == true) {
                        int b = iterator.next().intValue();
                        if (mark2[b] == -1) {
                            mark2[b] = temp.index;
                            if (vertex2[b] == -1) {
                                boolean power = true;
                                int current = b;
                                while (power == true || mark1[current] != -2) {
                                    if (power == true) {
                                        vertex1[mark2[current]] = current;
                                        vertex2[current] = mark2[current];
                                        power = false;
                                        current = mark2[current];
                                    }
                                    else {
                                        power = true;
                                        current = mark1[current];
                                    }
                                }
                                extra++;
                                find = true;
                                break;
                            }
                            else {
                                queue.offer(new Element(b, 2));
                            }
                        }
                    }
                    if (find == true) {
                        break;
                    }
                }
                else {
                    mark1[vertex2[temp.index]] = temp.index;
                    queue.offer(new Element(vertex2[temp.index], 1));
                }
            }
        }
        while (find == true);
        System.out.println(n + extra);
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(points1[i].x + " " + points1[i].y);
            if (i != n - 1 && vertex1[i] != -1) {
                System.out.print(" " + points2[vertex1[i]].x + " " +
                                 points2[vertex1[i]].y);
            }
        }
        System.out.println();
    }
}

class Point {
    int x, y;
    public Point(int X, int Y) {
        this.x = X;
        this.y = Y;
    }

    public double distance(Point another) {
        return Math.sqrt( (this.x - another.x) * (this.x - another.x) +
                         (this.y - another.y) * (this.y - another.y));
    }
}

class Element {
    int index;
    int group;
    public Element(int theIndex, int theGroup) {
        this.index = theIndex;
        this.group = theGroup;
    }
}
