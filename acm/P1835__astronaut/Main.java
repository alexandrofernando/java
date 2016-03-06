package P1835__astronaut;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-4-18
 * Time: 22:47:03
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        int offsets[][] = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}, {-1, 0, 0}, {0, -1, 0}, {0, 0, -1}};
        int turns[][] = {{1, 2, 4, 5}, {0, 5, 3, 2}, {0, 1, 3, 4}, {1, 5, 4, 2}, {0, 2, 3, 5}, {0, 4, 3, 1}};

        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int top = 2;
            int front = 0;
            int position[] = new int[3];
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                String direction = in.next();
                if (direction.equals("back") == true) {
                    front = (front + 3) % 6;
                } else if (direction.equals("left") == true) {
                    for (int j = 0; j < 4; j++) {
                        if (turns[top][j] == front) {
                            front = turns[top][(j + 3) % 4];
                            break;
                        }
                    }
                } else if (direction.equals("right") == true) {
                    for (int j = 0; j < 4; j++) {
                        if (turns[top][j] == front) {
                            front = turns[top][(j + 1) % 4];
                            break;
                        }
                    }
                } else if (direction.equals("up") == true) {
                    int temp = top;
                    top = (front + 3) % 6;
                    front = temp;
                } else if (direction.equals("down") == true) {
                    int temp = top;
                    top = front;
                    front = (temp + 3) % 6;
                }
                int x = in.nextInt();
                for (int j = 0; j < 3; j++) {
                    position[j] += offsets[front][j] * x;
                }
            }
            for (int i = 0; i < 3; i++) {
                System.out.print(position[i] + " ");
            }
            System.out.println(front);
        }
    }
}
