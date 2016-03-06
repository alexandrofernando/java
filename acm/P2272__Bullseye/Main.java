package P2272__Bullseye;

import java.util.Scanner;
import java.io.File;

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
        boolean end = false;
        while (true) {
            int scores[] = new int[2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    double x = cin.nextDouble();
                    if (Math.abs(x + 100) < 1E-9) {
                        end = true;
                        break;
                    }
                    double y = cin.nextDouble();
                    double temp = x * x + y * y;
                    if (temp <= 9) {
                        scores[i] += 100;
                    } else if (temp <= 36) {
                        scores[i] += 80;
                    } else if (temp <= 81) {
                        scores[i] += 60;
                    } else if (temp <= 144) {
                        scores[i] += 40;
                    } else if (temp <= 225) {
                        scores[i] += 20;
                    }
                }
                if (end == true) {
                    break;
                }
            }
            if (end == true) {
                break;
            }
            System.out.print("SCORE: " + scores[0] + " to " + scores[1] + ", ");
            if (scores[0] > scores[1]) {
                System.out.println("PLAYER 1 WINS.");
            } else if (scores[0] < scores[1]) {
                System.out.println("PLAYER 2 WINS.");
            } else {
                System.out.println("TIE.");
            }
        }
    }
}
