package P3067__Japan;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-20
 * Time: 21:07:55
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
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            Way ways[] = new Way[K];
            for (int i = 0; i < K; i++) {
                line = stdin.readLine();
                st = new StringTokenizer(line);
                int east = Integer.parseInt(st.nextToken());
                int west = Integer.parseInt(st.nextToken());
                ways[i] = new Way(east, west);
            }
            Arrays.sort(ways);
            int counts[] = new int[2048];
            long cross = 0;
            for (int i = 0; i < K; i++) {
                int value = ways[i].west;
                int bottom = 1;
                int top = 1024;
                int index = 1;
                for (int j = 0; j < 11; j++) {
                    counts[index]++;
                    int middle = (bottom + top) / 2;
                    if (value <= middle) {
                        if (j != 10) {
                            cross += counts[index * 2 + 1];
                        }
                        index *= 2;
                        top = middle;
                    } else {
                        index = index * 2 + 1;
                        bottom = middle + 1;
                    }
                }
            }
            System.out.println("Test case " + t + ": " + cross);
        }
    }
}

class Way implements Comparable<Way> {
    int east;
    int west;

    public Way(int theEast, int theWest) {
        this.east = theEast;
        this.west = theWest;
    }

    public int compareTo(Way another) {
        if (this.east != another.east) {
            return this.east - another.east;
        } else {
            return this.west - another.west;
        }
    }
}