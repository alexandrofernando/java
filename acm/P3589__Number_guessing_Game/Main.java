package P3589__Number_guessing_Game;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-6-14
 * Time: 0:55:41
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            String str1 = in.next();
            String str2 = in.next();
            boolean used1[] = new boolean[4];
            boolean used2[] = new boolean[4];
            int A = 0;
            for (int i = 0; i < 4; i++) {
                if (str1.charAt(i) == str2.charAt(i)) {
                    used1[i] = true;
                    used2[i] = true;
                    A++;
                }
            }
            int B = 0;
            for (int i = 0; i < 4; i++) {
                if (used1[i] == false) {
                    for (int j = 0; j < 4; j++) {
                        if (used2[j] == false && str1.charAt(i) == str2.charAt(j)) {
                            used1[i] = true;
                            used2[j] = true;
                            B++;
                        }
                    }
                }
            }
            System.out.println(A + "A" + B + "B");
        }
    }
}
