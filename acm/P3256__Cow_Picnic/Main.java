package P3256__Cow_Picnic;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-27
 * Time: 18:35:55
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        int N = in.nextInt();
        int M = in.nextInt();
        ArrayList<Integer> adjacents[] = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjacents[i] = new ArrayList<Integer>();
        }
        boolean reaches[][] = new boolean[N][K];
        LinkedList<Pasture_Cow> queue = new LinkedList<Pasture_Cow>();
        for (int i = 0; i < K; i++) {
            int pasture = in.nextInt() - 1;
            reaches[pasture][i] = true;
            queue.offer(new Pasture_Cow(pasture, i));
        }
        for (int i = 0; i < M; i++) {
            int from = in.nextInt() - 1;
            int to = in.nextInt() - 1;
            adjacents[from].add(to);
        }
        while (queue.isEmpty() == false) {
            Pasture_Cow head = queue.poll();
            for (int i = 0; i < adjacents[head.pasture].size(); i++) {
                int temp = adjacents[head.pasture].get(i);
                if (reaches[temp][head.cow] == false) {
                    reaches[temp][head.cow] = true;
                    queue.offer(new Pasture_Cow(temp, head.cow));
                }
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            boolean all = true;
            for (int j = 0; j < K; j++) {
                if (reaches[i][j] == false) {
                    all = false;
                    break;
                }
            }
            if (all == true) {
                result++;
            }
        }
        System.out.println(result);
    }
}

class Pasture_Cow {
    int pasture;
    int cow;

    public Pasture_Cow(int thePasture, int theCow) {
        this.pasture = thePasture;
        this.cow = theCow;
    }
}