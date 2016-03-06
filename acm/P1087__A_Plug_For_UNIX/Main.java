package P1087__A_Plug_For_UNIX;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

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
    static boolean matrix[][] = new boolean[305][305];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        ArrayList<String> types = new ArrayList<String> ();
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = true;
        }
        int n = cin.nextInt();
        String receptacles[] = new String[n];
        for (int i = 0; i < n; i++) {
            receptacles[i] = cin.next();
            if (types.contains(receptacles[i]) == false) {
                types.add(receptacles[i]);
            }
        }
        int m = cin.nextInt();
        String devices[] = new String[m];
        for (int i = 0; i < m; i++) {
            cin.next();
            devices[i] = cin.next();
        }
        int adapterNumber = cin.nextInt();
        for (int i = 0; i < adapterNumber; i++) {
            String to = cin.next();
            String from = cin.next();
            int indexTo = types.indexOf(to);
            if (indexTo == -1) {
                indexTo = types.size();
                types.add(to);
            }
            int indexFrom = types.indexOf(from);
            if (indexFrom == -1) {
                indexFrom = types.size();
                types.add(from);
            }
            matrix[indexFrom][indexTo] = true;
        }
        transmit();
        ArrayList<Integer> adjacent1[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacent1[i] = new ArrayList<Integer> ();
        }
        ArrayList<Integer> adjacent2[] = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            adjacent2[i] = new ArrayList<Integer> ();
        }
        for (int i = 0; i < n; i++) {
            int index1 = types.indexOf(receptacles[i]);
            for (int j = 0; j < m; j++) {
                int index2 = types.indexOf(devices[j]);
                if (index2 != -1 && matrix[index1][index2] == true) {
                    adjacent1[i].add(j);
                    adjacent2[j].add(i);
                }
            }
        }
        int vertex1[] = new int[n];
        for (int i = 0; i < n; i++) {
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
            int mark1[] = new int[n];
            int mark2[] = new int[m];
            for (int i = 0; i < n; i++) {
                mark1[i] = -1;
            }
            for (int i = 0; i < m; i++) {
                mark2[i] = -1;
            }
            LinkedList<Element> queue = new LinkedList<Element> ();
            for (int i = 0; i < n; i++) {
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
        System.out.println(m - extra);
    }

    static void transmit() {
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == true) {
                    for (int k = 0; k < matrix[0].length; k++) {
                        matrix[i][k] = matrix[i][k] || matrix[j][k];
                    }
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
