package P1097__Roads_Scholar;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int cityNumber = cin.nextInt();
        double distance[][] = new double[n][n];
        for (int i = 0; i < m; i++) {
            int p1 = cin.nextInt();
            int p2 = cin.nextInt();
            double dis = cin.nextDouble();
            distance[p1][p2] = dis;
            distance[p2][p1] = dis;
        }
        City cities[] = new City[cityNumber];
        for (int i = 0; i < cityNumber; i++) {
            cities[i] = new City(cin.nextInt(), cin.next());
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j && (distance[i][j] < 1E-6 ||
                                   distance[i][k] + distance[k][j] <
                                   distance[i][j]) &&
                        distance[i][k] > 1E-6 && distance[k][j] > 1E-6) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        int s = cin.nextInt();
        for (int i = 0; i < s; i++) {
            int from = cin.nextInt();
            int to = cin.nextInt();
            double d = cin.nextDouble();
            ArrayList<City_Distance> sign = new ArrayList<City_Distance> ();
            for (int j = 0; j < cityNumber; j++) {
                if (Math.abs(distance[from][to] + distance[to][cities[j].index] -
                             distance[from][cities[j].index]) < 1E-6) {
                    sign.add(new City_Distance(cities[j].name,
                                               (int) (distance[from][cities[j].
                        index] - d + 0.5)));
                }
            }
            Collections.sort(sign);
            for (int j = 0; j < sign.size(); j++) {
                System.out.printf("%-20s%d\n", sign.get(j).name,
                                  sign.get(j).distance);
            }
            System.out.println();
        }
    }
}

class City {
    int index;
    String name;
    public City(int theIndex, String theName) {
        this.index = theIndex;
        this.name = theName;
    }
}

class City_Distance
    implements Comparable<City_Distance> {
    String name;
    int distance;
    public City_Distance(String theName, int theDistance) {
        this.name = theName;
        this.distance = theDistance;
    }

    public int compareTo(City_Distance another) {
        if (this.distance != another.distance) {
            return this.distance - another.distance;
        }
        else {
            return this.name.compareTo(another.name);
        }
    }
}
