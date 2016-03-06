package P2160__Box;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-17
 * Time: 1:47:01
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lengths[] = new int[12];
        ArrayList<Integer> checks = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) {
            lengths[i * 2] = in.nextInt();
            lengths[i * 2 + 1] = in.nextInt();
            if (lengths[i * 2] == lengths[i * 2 + 1]) {
                checks.add(lengths[i * 2]);
            }
        }
        Arrays.sort(lengths);
        boolean possible = true;
        int sizes[] = new int[3];
        for (int i = 0; i < 3; i++) {
            sizes[i] = lengths[i * 4];
            for (int j = i * 4; j < i * 4 + 4; j++) {
                if (lengths[j] != sizes[i]) {
                    possible = false;
                    break;
                }
            }
            if (possible == false) {
                break;
            }
        }
        if (possible == true) {
            for (int i = 0; i < checks.size(); i++) {
                int temp = checks.get(i);
                int count = 0;
                for (int j = 0; j < 3; j++) {
                    if (sizes[j] == temp) {
                        count++;
                    }
                }
                if (count < 2) {
                    possible = false;
                    break;
                }
            }
        }
        if (possible == true) {
            System.out.println("POSSIBLE");
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}
