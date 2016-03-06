package P2536__Gopher_II;

import java.util.Scanner;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-25
 * Time: 2:51:31
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt() == true) {
            int n = in.nextInt();
            int m = in.nextInt();
            int s = in.nextInt();
            int v = in.nextInt();
            double gopherX[] = new double[n];
            double gopherY[] = new double[n];
            for (int i = 0; i < n; i++) {
                gopherX[i] = in.nextDouble();
                gopherY[i] = in.nextDouble();
            }
            double holeX[] = new double[m];
            double holeY[] = new double[m];
            for (int i = 0; i < m; i++) {
                holeX[i] = in.nextDouble();
                holeY[i] = in.nextDouble();
            }
            boolean adjacents[][] = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    double x = gopherX[i] - holeX[j];
                    double y = gopherY[i] - holeY[j];
                    if (s * s * v * v >= x * x + y * y) {
                        adjacents[i][j] = true;
                    }
                }
            }
            int vertex1[] = new int[n];
            for (int i = 0; i < m; i++) {
                vertex1[i] = -1;
            }
            int vertex2[] = new int[n];
            for (int i = 0; i < m; i++) {
                vertex2[i] = -1;
            }
            int extra = 0;
            boolean find;
            do {
                find = false;
                int mark1[] = new int[n];
                int mark2[] = new int[m];
                for (int i = 0; i < n; i++) {
                    mark1[i] = -1;
                }
                for (int i = 0; i < m; i++) {
                    mark2[i] = -1;
                }
                LinkedList<Element> queue = new LinkedList<Element>();
                for (int i = 0; i < n; i++) {
                    if (vertex1[i] == -1) {
                        mark1[i] = -2;
                        queue.offer(new Element(i, 1));
                    }
                }
                while (queue.isEmpty() == false) {
                    Element temp = queue.poll();
                    if (temp.group == 1) {
                        for (int i = 0; i < m; i++) {
                            if (adjacents[temp.index][i] == false) {
                                continue;
                            }
                            if (mark2[i] == -1) {
                                mark2[i] = temp.index;
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
                        if (find == true) {
                            break;
                        }
                    } else {
                        mark1[vertex2[temp.index]] = temp.index;
                        queue.offer(new Element(vertex2[temp.index], 1));
                    }
                }
            } while (find == true);
            System.out.println(n - extra);
        }
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