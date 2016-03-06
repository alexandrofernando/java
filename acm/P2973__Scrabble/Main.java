package P2973__Scrabble;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-4
 * Time: 8:21:29
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            String words[] = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = in.next();
            }
            String tiles = in.next();
            int counts[] = new int[26];
            int any = 0;
            for (int i = 0; i < tiles.length(); i++) {
                char ch = tiles.charAt(i);
                if (ch == '_') {
                    any++;
                } else {
                    counts[ch - 'A']++;
                }
            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                if (words[i].length() <= tiles.length()) {
                    int tempCounts[] = new int[26];
                    int tempAny = 0;
                    boolean power = true;
                    for (int j = 0; j < words[i].length(); j++) {
                        char ch = words[i].charAt(j);
                        if (tempCounts[ch - 'A'] < counts[ch - 'A']) {
                            tempCounts[ch - 'A']++;
                        } else if (tempAny < any) {
                            tempAny++;
                        } else {
                            power = false;
                            break;
                        }
                    }
                    if (power == true) {
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
