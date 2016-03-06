package P2810__Take_Your_Vitamins;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-22
 * Time: 23:15:24
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> littles = new ArrayList<String>();
        while (true) {
            double V = in.nextDouble();
            String A = in.next();
            double U = in.nextDouble();
            String P = in.nextLine().trim();
            if (V < 0) {
                break;
            }
            if (V / U >= 0.01) {
                System.out.printf("%s %.1f %s %.0f%%\n", P, V, A, V / U * 100);
            } else {
                littles.add(P);
            }
        }
        System.out.println("Provides no significant amount of: ");
        for (int i = 0; i < littles.size(); i++) {
            System.out.println(littles.get(i));
        }
    }
}
