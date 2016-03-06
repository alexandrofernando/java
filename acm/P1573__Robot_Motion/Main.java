package P1573__Robot_Motion;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-15
 * Time: 1:14:15
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        while (true) {
            int row = in.nextInt();
            int column = in.nextInt();
            int entry = in.nextInt();
            if (row == 0 && column == 0 && entry == 0) {
                break;
            }
            int step[][] = new int[row][column];
            char instructions[][] = new char[row][column];
            for (int i = 0; i < row; i++) {
                String str = in.next();
                for (int j = 0; j < column; j++) {
                    instructions[i][j] = str.charAt(j);
                }
            }
            int x = 0;
            int y = entry - 1;
            int currentStep = 1;
            while (true) {
                if (x < 0 || x >= row || y < 0 || y >= column) {
                    System.out.println((currentStep - 1) + " step(s) to exit");
                    break;
                }
                if (step[x][y] != 0) {
                    System.out.println((step[x][y] - 1) + " step(s) before a loop of " + (currentStep - step[x][y]) + " step(s)");
                    break;
                }
                step[x][y] = currentStep;
                currentStep++;
                if (instructions[x][y] == 'N') {
                    x--;
                } else if (instructions[x][y] == 'S') {
                    x++;
                } else if (instructions[x][y] == 'E') {
                    y++;
                } else if (instructions[x][y] == 'W') {
                    y--;
                }
            }
        }
    }
}
