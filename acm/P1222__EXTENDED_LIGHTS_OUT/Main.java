package P1222__EXTENDED_LIGHTS_OUT;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-21
 * Time: 1:23:27
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int tempLights[][];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int lights[][] = new int[5][6];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++) {
                    lights[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < 32; i++) {
                tempLights = new int[5][6];
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 6; k++) {
                        tempLights[j][k] = lights[j][k];
                    }
                }
                int solution[][] = new int[5][6];
                int temp = i;
                for (int j = 0; j < 5; j++) {
                    solution[j][0] = temp % 2;
                    if (solution[j][0] == 1) {
                        press(j, 0);
                    }
                    temp /= 2;
                }
                for (int j = 1; j < 6; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (tempLights[k][j - 1] == 1) {
                            solution[k][j] = 1;
                            press(k, j);
                        }
                    }
                }
                boolean success = true;
                for (int j = 0; j < 5; j++) {
                    if (tempLights[j][5] == 1) {
                        success = false;
                        break;
                    }
                }
                if (success == true) {
                    System.out.println("PUZZLE #" + t);
                    for (int j = 0; j < 5; j++) {
                        for (int k = 0; k < 6; k++) {
                            if (k != 0) {
                                System.out.print(" ");
                            }
                            System.out.print(solution[j][k]);
                        }
                        System.out.println();
                    }
                    break;
                }
            }
        }
    }

    static void press(int x, int y) {
        int offsetX[] = {0, -1, 0, 1, 0};
        int offsetY[] = {0, 0, 1, 0, -1};
        for (int i = 0; i < 5; i++) {
            int tempX = x + offsetX[i];
            int tempY = y + offsetY[i];
            if (tempX >= 0 && tempX < 5 && tempY >= 0 && tempY < 6) {
                tempLights[tempX][tempY] = (tempLights[tempX][tempY] + 1) % 2;
            }
        }
    }
}
