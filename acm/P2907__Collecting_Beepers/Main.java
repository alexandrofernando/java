package P2907__Collecting_Beepers;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-2-11
 * Time: 15:09:02
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static Position start;
    static int number;
    static Position positions[];
    static boolean visited[];
    static int result;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            in.nextInt();
            in.nextInt();
            start = new Position(in.nextInt(), in.nextInt());
            number = in.nextInt();
            positions = new Position[number];
            visited = new boolean[number];
            for (int i = 0; i < number; i++) {
                positions[i] = new Position(in.nextInt(), in.nextInt());
            }
            result = Integer.MAX_VALUE;
            search(0, -1, 0);
            System.out.println("The shortest path has length " + result);
        }
    }

    static void search(int finish, int previous, int length) {
        if (finish == number) {
            length += Position.getDistance(positions[previous], start);
            if (length < result) {
                result = length;
            }
        } else {
            for (int i = 0; i < number; i++) {
                if (visited[i] == false) {
                    visited[i] = true;
                    int temp;
                    if (previous == -1) {
                        temp = Position.getDistance(start, positions[i]);
                    } else {
                        temp = Position.getDistance(positions[previous], positions[i]);
                    }
                    search(finish + 1, i, length + temp);
                    visited[i] = false;
                }
            }
        }
    }
}

class Position {
    int x;
    int y;

    public Position(int X, int Y) {
        this.x = X;
        this.y = Y;
    }

    static int getDistance(Position a, Position b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}