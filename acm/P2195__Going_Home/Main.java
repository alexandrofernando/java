package P2195__Going_Home;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-1
 * Time: 2:32:08
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int N = in.nextInt();
            int M = in.nextInt();
            if (N == 0 && M == 0) {
                break;
            }
            ArrayList<Point> houses = new ArrayList<Point>();
            ArrayList<Point> men = new ArrayList<Point>();
            for (int i = 0; i < N; i++) {
                String str = in.next();
                for (int j = 0; j < M; j++) {
                    char ch = str.charAt(j);
                    if (ch == 'H') {
                        houses.add(new Point(i, j));
                    } else if (ch == 'm') {
                        men.add(new Point(i, j));
                    }
                }
            }
            int n = houses.size();
            int weights[][] = new int[n][n];
            int max = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    weights[i][j] = Math.abs(houses.get(i).x - men.get(j).x) + Math.abs(houses.get(i).y - men.get(j).y);
                    if (weights[i][j] > max) {
                        max = weights[i][j];
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    weights[i][j] = max - weights[i][j];
                }
            }
            int result = max * n - KM(weights, n);
            System.out.println(result);
        }
    }

    static int KM(int weights[][], int n) {
        int sign1[] = new int[n];
        int sign2[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (weights[i][j] > sign1[i]) {
                    sign1[i] = weights[i][j];
                }
            }
        }
        int vertex1[] = new int[n];
        int vertex2[] = new int[n];
        for (int i = 0; i < n; i++) {
            vertex1[i] = -1;
            vertex2[i] = -1;
        }
        int extra = 0;
        boolean find = false;
        boolean subgraph[][] = new boolean[n][n];
        while (extra < n) {
            if (find == false) {
                subgraph = new boolean[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (sign1[i] + sign2[j] == weights[i][j]) {
                            subgraph[i][j] = true;
                        }
                    }
                }
            }
            int mark1[] = new int[n];
            int mark2[] = new int[n];
            for (int i = 0; i < n; i++) {
                mark1[i] = -1;
                mark2[i] = -1;
            }
            LinkedList<Element> queue = new LinkedList<Element>();
            boolean s[] = new boolean[n];
            boolean p[] = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (vertex1[i] == -1) {
                    s[i] = true;
                    mark1[i] = -2;
                    queue.add(new Element(i, 1));
                    break;
                }
            }
            find = false;
            while (queue.isEmpty() == false) {
                Element temp = queue.poll();
                if (temp.group == 1) {
                    for (int i = 0; i < n; i++) {
                        if (subgraph[temp.index][i] == true) {
                            if (mark2[i] == -1) {
                                mark2[i] = temp.index;
                                p[i] = true;
                                if (vertex2[i] == -1) {
                                    boolean power = true;
                                    int current = i;
                                    while (power == true || mark1[current] != -2) {
                                        if (power == true) {
                                            vertex1[mark2[current]] = current;
                                            vertex2[current] = mark2[current];
                                            power = false;
                                            current = mark2[current];
                                        } else {
                                            power = true;
                                            current = mark1[current];
                                        }
                                    }
                                    extra++;
                                    find = true;
                                    break;
                                } else {
                                    queue.offer(new Element(i, 2));
                                }
                            }
                        }
                    }
                    if (find == true) {
                        break;
                    }
                } else {
                    mark1[vertex2[temp.index]] = temp.index;
                    queue.offer(new Element(vertex2[temp.index], 1));
                    s[vertex2[temp.index]] = true;
                }
            }
            if (find == false) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    if (s[i] == true) {
                        for (int j = 0; j < n; j++) {
                            if (p[j] == false) {
                                if (sign1[i] + sign2[j] - weights[i][j] < min) {
                                    min = sign1[i] + sign2[j] - weights[i][j];
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    if (s[i] == true) {
                        sign1[i] -= min;
                    }
                    if (p[i] == true) {
                        sign2[i] += min;
                    }
                }
            }
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += weights[i][vertex1[i]];
        }
        return total;
    }
}

class Point {
    int x;
    int y;

    public Point(int X, int Y) {
        this.x = X;
        this.y = Y;
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