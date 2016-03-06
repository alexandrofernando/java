package P1013__Counterfeit_Dollar;

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;

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
    public static void main(String args[]) throws Exception {
        char letters[] = (new String("ABCDEFGHIJKL")).toCharArray();
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        for (int t = 0; t < n; t++) {
            int left[][] = new int[3][];
            int right[][] = new int[3][];
            int relation[] = new int[3];
            for (int i = 0; i < 3; i++) {
                String temp = cin.next();
                left[i] = new int[temp.length()];
                for (int j = 0; j < left[i].length; j++) {
                    left[i][j] = Arrays.binarySearch(letters, temp.charAt(j));
                }
                temp = cin.next();
                right[i] = new int[temp.length()];
                for (int j = 0; j < right[i].length; j++) {
                    right[i][j] = Arrays.binarySearch(letters, temp.charAt(j));
                }
                temp = cin.next();
                if (temp.compareTo("up") == 0) {
                    relation[i] = 1;
                }
                else if (temp.compareTo("down") == 0) {
                    relation[i] = -1;
                }
                else if (temp.compareTo("even") == 0) {
                    relation[i] = 0;
                }
            }
            for (int i = 0; i < 24; i++) {
                int weight[] = new int[12];
                if (i % 2 == 0) {
                    weight[i / 2] = -1;
                }
                else {
                    weight[i / 2] = 1;
                }
                boolean power = true;
                for (int j = 0; j < 3; j++) {
                    int sumLeft = 0;
                    for (int k = 0; k < left[j].length; k++) {
                        sumLeft += weight[left[j][k]];
                    }
                    int sumRight = 0;
                    for (int k = 0; k < right[j].length; k++) {
                        sumRight += weight[right[j][k]];
                    }
                    if ( (sumLeft < sumRight && relation[j] != -1) ||
                        (sumLeft == sumRight && relation[j] != 0) ||
                        (sumLeft > sumRight && relation[j] != 1)) {
                        power = false;
                        break;
                    }
                }
                if (power == true) {
                    System.out.print(letters[i / 2] +
                                     " is the counterfeit coin and it is ");
                    if (i % 2 == 0) {
                        System.out.println("light.");
                    }
                    else {
                        System.out.println("heavy.");
                    }
                    break;
                }
            }
        }
    }
}
