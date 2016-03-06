package P1144__Network;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

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
    static int count;
    static Place places[];
    static int result;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        do {
            int N = cin.nextInt();
            if (N == 0) {
                break;
            }
            places = new Place[N + 1];
            for (int i = 1; i <= N; i++) {
                places[i] = new Place();
            }
            do {
                int end1 = cin.nextInt();
                if (end1 == 0) {
                    break;
                }
                String str = cin.nextLine();
                Scanner cin1 = new Scanner(str);
                while (cin1.hasNextInt() == true) {
                    int end2 = cin1.nextInt();
                    places[end1].adjacents.add(end2);
                    places[end2].adjacents.add(end1);
                }
            }
            while (true);
            result = 0;
            count = 1;
            places[1].visited = 1;
            for (int i = 0; i < places[1].adjacents.size(); i++) {
                dfs(places[1].adjacents.get(i));
                if (i == 0 && count < N) {
                    result++;
                }
            }
            System.out.println(result);
        }
        while (true);
    }

    static void dfs(int v) {
        count++;
        int min = count;
        places[v].visited = count;
        boolean power = false;
        for (int i = 0; i < places[v].adjacents.size(); i++) {
            int w = places[v].adjacents.get(i);
            if (places[w].visited == 0) {
                dfs(w);
                if (places[w].low < min) {
                    min = places[w].low;
                }
                if (places[w].low >= places[v].visited) {
                    power = true;
                }
            }
            else if (places[w].visited < min) {
                min = places[w].visited;
            }
        }
        if (power == true) {
            result++;
        }
        places[v].low = min;
    }
}

class Place {
    ArrayList<Integer> adjacents;
    int visited;
    int low;
    public Place() {
        this.adjacents = new ArrayList<Integer> ();
        this.visited = 0;
        this.low = 0;
    }
}
