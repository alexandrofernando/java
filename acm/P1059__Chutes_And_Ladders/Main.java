package P1059__Chutes_And_Ladders;

import java.util.Scanner;
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
        Scanner cin = new Scanner(System.in);
        int die[] = new int[1005];
        int length = 0;
        while ( (die[length] = cin.nextInt()) != 0) {
            length++;
        }
        int player;
        while ( (player = cin.nextInt()) != 0) {
            int square[] = new int[100];
            int start, end;
            while ( (start = cin.nextInt()) != 0 | (end = cin.nextInt()) != 0) {
                square[start] = end;
            }
            int position;
            while ( (position = cin.nextInt()) != 0) {
                if (position > 0) {
                    square[position] = -1;
                }
                else {
                    square[ -position] = -2;
                }
            }
            int current[] = new int[player];
            boolean stop[] = new boolean[player];
            int turn = 0;
            int dieIndex = 0;
            while (true) {
                if (stop[turn] == false) {
                    if (current[turn] + die[dieIndex] == 100) {
                        System.out.println(turn + 1);
                        break;
                    }
                    else if (current[turn] + die[dieIndex] < 100) {
                        current[turn] += die[dieIndex];
                        if (square[current[turn]] > 0) {
                            current[turn] = square[current[turn]];
                        }
                    }
                    if (square[current[turn]] == -1) {
                        turn--;
                    }
                    else if (square[current[turn]] == -2) {
                        stop[turn] = true;
                    }
                }
                else {
                    stop[turn] = false;
                }
                dieIndex++;
                turn = (turn + 1) % player;
            }
        }
    }
}
