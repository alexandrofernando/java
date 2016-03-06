package P1988__Cube_Stacking;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-15
 * Time: 22:48:31
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static Cube cubes[];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int P = in.nextInt();
        cubes = new Cube[30001];
        for (int i = 1; i <= 30000; i++) {
            cubes[i] = new Cube(i);
        }
        for (int i = 0; i < P; i++) {
            String operation = in.next();
            if (operation.equals("M") == true) {
                int X = in.nextInt();
                int Y = in.nextInt();
                int rootX = searchRoot(X);
                int rootY = searchRoot(Y);
                cubes[rootY].parent = rootX;
                cubes[rootY].frontNumber = cubes[rootX].backNumber;
                cubes[rootX].backNumber += cubes[rootY].backNumber;
            } else if (operation.equals("C") == true) {
                int X = in.nextInt();
                int root = searchRoot(X);
                System.out.println(cubes[root].backNumber - cubes[X].frontNumber - 1);
            }
        }
    }

    static int searchRoot(int node) {
        int root = node;
        int count = 0;
        while (cubes[root].parent != root) {
            count += cubes[root].frontNumber;
            root = cubes[root].parent;
        }
        int previous;
        while (node != root) {
            int temp = cubes[node].parent;
            cubes[node].parent = root;
            previous = cubes[node].frontNumber;
            cubes[node].frontNumber = count;
            count -= previous;
            node = temp;
        }
        return root;
    }
}

class Cube {
    int parent;
    int frontNumber;
    int backNumber;

    public Cube(int theParent) {
        this.parent = theParent;
        this.frontNumber = 0;
        this.backNumber = 1;
    }
}