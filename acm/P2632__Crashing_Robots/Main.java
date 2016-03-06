package P2632__Crashing_Robots;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-23
 * Time: 19:11:36
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int A = in.nextInt();
            int B = in.nextInt();
            int warehouse[][] = new int[B + 1][A + 1];
            int N = in.nextInt();
            int M = in.nextInt();
            Robot robots[] = new Robot[N + 1];
            for (int i = 1; i <= N; i++) {
                int X = in.nextInt();
                int Y = B + 1 - in.nextInt();
                String direction = in.next();
                robots[i] = new Robot(X, Y, direction);
                warehouse[Y][X] = i;
            }
            boolean crash = false;
            for (int i = 0; i < M; i++) {
                int index = in.nextInt();
                String action = in.next();
                int repeat = in.nextInt();
                if (crash == true) {
                    continue;
                }
                if (action.equals("L") == true) {
                    robots[index].direction = (robots[index].direction - repeat % 4 + 4) % 4;
                } else if (action.equals("R") == true) {
                    robots[index].direction = (robots[index].direction + repeat % 4) % 4;
                } else if (action.equals("F") == true) {
                    int offsetX;
                    int offsetY;
                    if (robots[index].direction == 0) {
                        offsetX = 0;
                        offsetY = -1;
                    } else if (robots[index].direction == 1) {
                        offsetX = 1;
                        offsetY = 0;
                    } else if (robots[index].direction == 2) {
                        offsetX = 0;
                        offsetY = 1;
                    } else {
                        offsetX = -1;
                        offsetY = 0;
                    }
                    for (int j = 1; j <= repeat; j++) {
                        int tempX = robots[index].x + offsetX * j;
                        int tempY = robots[index].y + offsetY * j;
                        if (tempX == 0 || tempX == A + 1 || tempY == 0 || tempY == B + 1) {
                            System.out.println("Robot " + index + " crashes into the wall");
                            crash = true;
                            break;
                        } else if (warehouse[tempY][tempX] != 0) {
                            System.out.println("Robot " + index + " crashes into robot " + warehouse[tempY][tempX]);
                            crash = true;
                            break;
                        }
                    }
                    if (crash == false) {
                        warehouse[robots[index].y][robots[index].x] = 0;
                        warehouse[robots[index].y + offsetY * repeat][robots[index].x + offsetX * repeat] = index;
                        robots[index].x += offsetX * repeat;
                        robots[index].y += offsetY * repeat;
                    }
                }
            }
            if (crash == false) {
                System.out.println("OK");
            }
        }
    }
}

class Robot {
    int x;
    int y;
    int direction;

    public Robot(int X, int Y, String str) {
        this.x = X;
        this.y = Y;
        if (str.equals("N") == true) {
            direction = 0;
        } else if (str.equals("E") == true) {
            direction = 1;
        } else if (str.equals("S") == true) {
            direction = 2;
        } else if (str.equals("W") == true) {
            direction = 3;
        }
    }
}