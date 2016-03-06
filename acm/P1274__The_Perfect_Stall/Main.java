package P1274__The_Perfect_Stall;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-31
 * Time: 19:56:01
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt() == true) {
            int N = in.nextInt();
            int M = in.nextInt();
            ArrayList<Integer> adjacent1[] = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                adjacent1[i] = new ArrayList<Integer>();
            }
            ArrayList<Integer> adjacent2[] = new ArrayList[M];
            for (int i = 0; i < M; i++) {
                adjacent2[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < N; i++) {
                int S = in.nextInt();
                for (int j = 0; j < S; j++) {
                    int temp = in.nextInt() - 1;
                    adjacent1[i].add(temp);
                    adjacent2[temp].add(i);
                }
            }
            int vertex1[] = new int[N];
            for (int i = 0; i < N; i++) {
                vertex1[i] = -1;
            }
            int vertex2[] = new int[M];
            for (int i = 0; i < M; i++) {
                vertex2[i] = -1;
            }
            int extra = 0;
            boolean find;
            do {
                find = false;
                int mark1[] = new int[N];
                int mark2[] = new int[M];
                for (int i = 0; i < N; i++) {
                    mark1[i] = -1;
                }
                for (int i = 0; i < M; i++) {
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
                        for (int i = 0; i < adjacent1[temp.index].size(); i++) {
                            int b = adjacent1[temp.index].get(i);
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
                                        } else {
                                            power = true;
                                            current = mark1[current];
                                        }
                                    }
                                    extra++;
                                    find = true;
                                    break;
                                } else {
                                    queue.offer(new Element(b, 2));
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
}

class Element {
    int index;
    int group;

    public Element(int theIndex, int theGroup) {
        this.index = theIndex;
        this.group = theGroup;
    }
}