package P1200__Crazy_Search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-2-16
 * Time: 7:51:16
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int NC = Integer.parseInt(st.nextToken());
        String text = stdin.readLine();
        HashSet<String> substrings = new HashSet<String>();
        for (int i = 0; i + N <= text.length(); i++) {
            substrings.add(text.substring(i, i + N));
        }
        System.out.println(substrings.size());
    }
}
