package P1469__COURSES;

import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-24
 * Time: 22:40:08
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            int P = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            boolean adjacents[][] = new boolean[P][N];
            for (int i = 0; i < P; i++) {
                line = stdin.readLine();
                st = new StringTokenizer(line);
                int count = Integer.parseInt(st.nextToken());
                for (int j = 0; j < count; j++) {
                    int student = Integer.parseInt(st.nextToken()) - 1;
                    adjacents[i][student] = true;
                }
            }
            int vertex1[] = new int[P];
            for (int i = 0; i < P; i++) {
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
                int mark1[] = new int[P];
                int mark2[] = new int[N];
                for (int i = 0; i < P; i++) {
                    mark1[i] = -1;
                }
                for (int i = 0; i < N; i++) {
                    mark2[i] = -1;
                }
                LinkedList<Element> queue = new LinkedList<Element>();
                for (int i = 0; i < P; i++) {
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
            if (extra == P) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
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