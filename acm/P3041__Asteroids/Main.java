package P3041__Asteroids;

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-5-19
 * Time: 13:24:06
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        boolean adjacents[][] = new boolean[N][N];
        for (int i = 0; i < K; i++) {
            int R = in.nextInt();
            int C = in.nextInt();
            adjacents[R - 1][C - 1] = true;
        }

        int vertex1[] = new int[N];
        for (int i = 0; i < N; i++) {
            vertex1[i] = -1;
        }
        int vertex2[] = new int[N];
        for (int i = 0; i < N; i++) {
            vertex2[i] = -1;
        }
        int extra = 0;
        boolean find;
        do {
            find = false;
            int mark1[] = new int[N];
            int mark2[] = new int[N];
            for (int i = 0; i < N; i++) {
                mark1[i] = -1;
            }
            for (int i = 0; i < N; i++) {
                mark2[i] = -1;
            }
            LinkedList<Element> queue = new LinkedList<Element>();
            for (int i = 0; i < N; i++) {
                if (vertex1[i] == -1) {
                    mark1[i] = -2;
                    queue.offer(new Element(i, 1));
                }
            }
            while (queue.isEmpty() == false) {
                Element temp = queue.poll();
                if (temp.group == 1) {
                    for (int i = 0; i < N; i++) {
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
        System.out.println(extra);
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