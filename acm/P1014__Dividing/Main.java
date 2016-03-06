package P1014__Dividing;

import java.util.Scanner;
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
    public static void main(String args[]) throws Exception {
        int test = 1;
        Scanner cin = new Scanner(System.in);
        int marble[] = new int[6];
        while (true) {
            boolean power = false;
            for (int i = 0; i < marble.length; i++) {
                marble[i] = cin.nextInt();
                if (marble[i] != 0) {
                    power = true;
                }
            }
            if (power == false) {
                break;
            }
            int compare[] = {
                0, 4, 5, 5, 6, 5};
            int odd[] = {
                0, 3, 5, 5, 5, 5};
            int even[] = {
                0, 4, 4, 4, 6, 4};
            for (int i = 1; i < marble.length; i++) {
                if (marble[i] > compare[i]) {
                    if (marble[i] % 2 == 1) {
                        marble[i] = odd[i];
                    }
                    else {
                        marble[i] = even[i];
                    }
                }
            }
            ArrayList divide = new ArrayList<Integer> ();
            divide.add(0);
            for (int i = 1; i < marble.length; i++) {
                for (int j = 0; j < marble[i]; j++) {
                    ArrayList copy = new ArrayList<Integer> ();
                    for (int k = 0; k < divide.size(); k++) {
                        int temp = ( (Integer) divide.get(k)).intValue();
                        if (copy.contains(temp + (i + 1)) == false) {
                            copy.add(temp + (i + 1));
                        }
                        if (copy.contains(temp - (i + 1)) == false) {
                            copy.add(temp - (i + 1));
                        }
                    }
                    divide = (ArrayList) copy.clone();
                }
            }
            System.out.println("Collection #" + test + ":");
            boolean can = false;
            for (int i = 0; i < divide.size(); i++) {
                int temp = ( (Integer) divide.get(i)).intValue();
                if ( (temp + marble[0]) % 2 == 0 &&
                    Math.abs(marble[0]) >= Math.abs(temp)) {
                    can = true;
                    break;
                }
            }
            if (can == true) {
                System.out.println("Can be divided.");
            }
            else {
                System.out.println("Can't be divided.");
            }
            System.out.println();
            test++;
        }
    }
}
