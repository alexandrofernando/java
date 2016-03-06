package P1466__Girls_and_Boys;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-2-16
 * Time: 0:27:00
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static ArrayList<Integer> relations[];
    static int groups[];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int studentNumber = in.nextInt();
            relations = new ArrayList[studentNumber];
            for (int i = 0; i < studentNumber; i++) {
                String temp = in.next();
                int index = Integer.parseInt(temp.substring(0, temp.length() - 1));
                temp = in.next();
                int number = Integer.parseInt(temp.substring(1, temp.length() - 1));
                relations[index] = new ArrayList<Integer>();
                for (int j = 0; j < number; j++) {
                    relations[index].add(in.nextInt());
                }
            }
            groups = new int[studentNumber];
            for (int i = 0; i < studentNumber; i++) {
                if (groups[i] == 0) {
                    bfs(i);
                }
            }
            int size1 = 0;
            int size2 = 0;
            int maps[] = new int[studentNumber];
            for (int i = 0; i < studentNumber; i++) {
                if (groups[i] == 1) {
                    maps[i] = size1;
                    size1++;
                } else {
                    maps[i] = size2;
                    size2++;
                }
            }
            ArrayList<Integer> adjacent1[] = new ArrayList[size1];
            for (int i = 0; i < size1; i++) {
                adjacent1[i] = new ArrayList<Integer>();
            }
            ArrayList<Integer> adjacent2[] = new ArrayList[size2];
            for (int i = 0; i < size2; i++) {
                adjacent2[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < studentNumber; i++) {
                for (int j = 0; j < relations[i].size(); j++) {
                    int person = relations[i].get(j);
                    if (groups[i] == 1) {
                        adjacent1[maps[i]].add(maps[person]);
                    } else {
                        adjacent2[maps[i]].add(maps[person]);
                    }
                }
            }
            int vertex1[] = new int[size1];
            for (int i = 0; i < size1; i++) {
                vertex1[i] = -1;
            }
            int vertex2[] = new int[size2];
            for (int i = 0; i < size2; i++) {
                vertex2[i] = -1;
            }
            int extra = 0;
            boolean find;
            do {
                find = false;
                int mark1[] = new int[size1];
                int mark2[] = new int[size2];
                for (int i = 0; i < size1; i++) {
                    mark1[i] = -1;
                }
                for (int i = 0; i < size2; i++) {
                    mark2[i] = -1;
                }
                LinkedList<Element> queue = new LinkedList<Element>();
                for (int i = 0; i < size1; i++) {
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
            }
            while (find == true);
            System.out.println(studentNumber - extra);
        }
    }

    static void bfs(int index) {
        groups[index] = 1;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(index);
        while (!queue.isEmpty()) {
            int head = queue.poll();
            for (int i = 0; i < relations[head].size(); i++) {
                int person = relations[head].get(i);
                if (groups[person] == 0) {
                    groups[person] = -groups[head];
                    queue.offer(person);
                }
            }
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