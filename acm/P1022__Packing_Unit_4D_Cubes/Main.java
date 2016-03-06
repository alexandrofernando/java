package P1022__Packing_Unit_4D_Cubes;

import java.util.Scanner;
import java.io.File;
import java.util.TreeMap;

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
    static TreeMap<Integer, Cube> cubes;
    static int bound[][];
    static boolean consistent;
    static int count;
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = cin.nextInt();
            cubes = new TreeMap<Integer, Cube> ();
            for (int i = 0; i < n; i++) {
                cubes.put(cin.nextInt(),
                          new Cube(cin.nextInt(), cin.nextInt(), cin.nextInt(),
                                   cin.nextInt(), cin.nextInt(), cin.nextInt(),
                                   cin.nextInt(), cin.nextInt()));
            }
            bound = new int[4][2];
            Cube first = cubes.get(cubes.firstKey());
            consistent = true;
            count = 0;
            DFS(first, new int[4]);
            if (consistent == false || count < n) {
                System.out.println("Inconsistent");
            }
            else {
                int result = 1;
                for (int i = 0; i < 4; i++) {
                    result *= (bound[i][1] - bound[i][0] + 1);
                }
                System.out.println(result);
            }
        }
    }

    public static void DFS(Cube current, int theX[]) {
        count++;
        current.visit = true;
        current.x = theX;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                if (current.adj[i][j] != 0) {
                    Cube temp = cubes.get(current.adj[i][j]);
                    int newX[] = current.x.clone();
                    if (j == 0) {
                        newX[i]--;
                        if (newX[i] < bound[i][0]) {
                            bound[i][0] = newX[i];
                        }
                    }
                    else {
                        newX[i]++;
                        if (newX[i] > bound[i][1]) {
                            bound[i][1] = newX[i];
                        }
                    }
                    if (temp.visit == false) {
                        DFS(temp, newX);
                    }
                    else {
                        for (int k = 0; k < 4; k++) {
                            if (temp.x[k] != newX[k]) {
                                consistent = false;
                                return;
                            }
                        }
                    }
                    if (consistent == false) {
                        return;
                    }
                }
            }
        }
    }
}

class Cube {
    boolean visit = false;
    int adj[][] = new int[4][2];
    int x[] = new int[4];
    public Cube(int theAdj00, int theAdj01, int theAdj10, int theAdj11,
                int theAdj20, int theAdj21, int theAdj30, int theAdj31) {
        this.adj[0][0] = theAdj00;
        this.adj[0][1] = theAdj01;
        this.adj[1][0] = theAdj10;
        this.adj[1][1] = theAdj11;
        this.adj[2][0] = theAdj20;
        this.adj[2][1] = theAdj21;
        this.adj[3][0] = theAdj30;
        this.adj[3][1] = theAdj31;
    }
}
