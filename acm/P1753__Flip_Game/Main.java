package P1753__Flip_Game;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-4-20
 * Time: 17:25:55
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static boolean field[][] = new boolean[4][4];

    public static void main(String args[]) {
        int rounds[] = new int[65536];
        for (int i = 0; i < rounds.length; i++) {
            rounds[i] = -1;
        }
        rounds[0] = 0;
        rounds[65535] = 0;
        LinkedList<State> queue = new LinkedList<State>();
        queue.offer(new State(0, 0));
        queue.offer(new State(65535, 0));
        while (queue.isEmpty() == false) {
            State head = queue.poll();
            decode(head.code);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    flip(i, j);
                    int code = encode();
                    if (rounds[code] == -1) {
                        rounds[code] = head.round + 1;
                        queue.offer(new State(code, head.round + 1));
                    }
                    flip(i, j);
                }
            }
        }
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            String str = in.next();
            for (int j = 0; j < 4; j++) {
                if (str.charAt(j) == 'b') {
                    field[i][j] = false;
                } else {
                    field[i][j] = true;
                }
            }
        }
        int code = encode();
        if (rounds[code] == -1) {
            System.out.println("Impossible");
        } else {
            System.out.println(rounds[code]);
        }
    }

    static void flip(int x, int y) {
        int offsetX[] = {0, -1, 1, 0, 0};
        int offsetY[] = {0, 0, 0, -1, 1};
        for (int i = 0; i < 5; i++) {
            int newX = x + offsetX[i];
            int newY = y + offsetY[i];
            if (newX >= 0 && newX < 4 && newY >= 0 && newY < 4) {
                field[newX][newY] = !field[newX][newY];
            }
        }
    }

    static int encode() {
        int code = 0;
        for (int i = 3; i >= 0; i--) {
            for (int j = 3; j >= 0; j--) {
                code = code * 2;
                if (field[i][j] == true) {
                    code++;
                }
            }
        }
        return code;
    }

    static void decode(int code) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (code % 2 == 0) {
                    field[i][j] = false;
                } else {
                    field[i][j] = true;
                }
                code /= 2;
            }
        }
    }
}

class State {
    int code;
    int round;

    public State(int theCode, int theRound) {
        this.code = theCode;
        this.round = theRound;
    }
}