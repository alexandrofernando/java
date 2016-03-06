package P2748__Logs_Stacking;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-2-11
 * Time: 23:04:26
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        int fibonacci[] = new int[150000];
        fibonacci[1] = 1;
        fibonacci[2] = 1;
        for (int i = 3; i < fibonacci.length; i++) {
            fibonacci[i] = (fibonacci[i - 2] + fibonacci[i - 1]) % 100000;
        }
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int test = Integer.parseInt(st.nextToken());
        StringBuffer output = new StringBuffer();
        for (int t = 1; t <= test; t++) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            output.append(fibonacci[(n % 75000 * 2 + 149999) % 150000] + "\n");
        }
        System.out.println(output);
    }
}
