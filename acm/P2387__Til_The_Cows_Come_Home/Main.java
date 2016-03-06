package P2387__Til_The_Cows_Come_Home;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        int N = cin.nextInt();
        Landmark landmarks[] = new Landmark[N + 1];
        for (int i = 1; i <= N; i++) {
            landmarks[i] = new Landmark();
        }
        for (int i = 0; i < T; i++) {
            int temp1 = cin.nextInt();
            int temp2 = cin.nextInt();
            int temp3 = cin.nextInt();
            landmarks[temp1].adjacents.add(new Trail(temp2, temp3));
            landmarks[temp2].adjacents.add(new Trail(temp1, temp3));
        }
        landmarks[N].minimum = 0;
        ArrayList<Integer> rest = new ArrayList<Integer>();
        for (int i = 1; i <= N; i++) {
            rest.add(i);
        } while (true) {
            int index = 0;
            for (int i = 1; i < rest.size(); i++) {
                if (landmarks[rest.get(i)].minimum < landmarks[rest.get(index)].
                    minimum) {
                    index = i;
                }
            }
            int vertex = rest.remove(index);
            if (vertex == 1) {
                System.out.println(landmarks[vertex].minimum);
                break;
            } else {
                for (int i = 0; i < landmarks[vertex].adjacents.size(); i++) {
                    Trail trail = landmarks[vertex].adjacents.get(i);
                    if (landmarks[vertex].minimum +
                        trail.distance < landmarks[trail.end].minimum) {
                        landmarks[trail.end].minimum = landmarks[vertex].
                                minimum + trail.distance;
                    }
                }
            }
        }
    }
}


class Trail {
    int end;
    int distance;
    public Trail(int theEnd, int theDistance) {
        this.end = theEnd;
        this.distance = theDistance;
    }
}


class Landmark {
    int minimum;
    ArrayList<Trail> adjacents;
    public Landmark() {
        this.minimum = Integer.MAX_VALUE;
        this.adjacents = new ArrayList<Trail>();
    }
}
