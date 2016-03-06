package P1666__Candy_Sharing_Game;

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
        while (true) {
            int N = cin.nextInt();
            if (N == 0) {
                break;
            }
            int numbers[] = new int[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = cin.nextInt();
            }
            int round = 0;
            while (true) {
                boolean power = true;
                for (int i = 1; i < N; i++) {
                    if (numbers[i] != numbers[0]) {
                        power = false;
                        break;
                    }
                }
                if (power == true) {
                    break;
                }
                int temp[] = new int[N];
                for (int i = 0; i < N; i++) {
                    temp[i] = numbers[i] / 2 + numbers[(i - 1 + N) % N] / 2;
                    if (temp[i] % 2 == 1) {
                        temp[i]++;
                    }
                }
                numbers = temp;
                round++;
            }
            System.out.println(round + " " + numbers[0]);
        }
    }
}
