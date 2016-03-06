package P3080__Blue_Jeans;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-2-16
 * Time: 7:08:32
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int m = in.nextInt();
            String sequences[] = new String[m];
            for (int i = 0; i < m; i++) {
                sequences[i] = in.next();
            }
            String common = "";
            for (int i = 0; i < sequences[0].length(); i++) {
                for (int j = i + 3; j <= sequences[0].length(); j++) {
                    String str = sequences[0].substring(i, j);
                    boolean possible = true;
                    for (int k = 0; k < m; k++) {
                        if (sequences[k].indexOf(str) == -1) {
                            possible = false;
                            break;
                        }
                    }
                    if (!possible) {
                        continue;
                    }
                    if (str.length() > common.length() || (str.length() == common.length() && str.compareTo(common) < 0)) {
                        common = str;
                    }
                }
            }
            if (common.length() >= 3) {
                System.out.println(common);
            } else {
                System.out.println("no significant commonalities");
            }
        }
    }
}
