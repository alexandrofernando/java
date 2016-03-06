package P2524__Ubiquitous_Religions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


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
    static int students[];
    public static void main(String[] args) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.
                in));
        int test = 1;
        while (true) {
            String line = stdin.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            students = new int[n + 1];
            for (int i = 0; i < m; i++) {
                line = stdin.readLine();
                st = new StringTokenizer(line);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int headA = search(a);
                int headB = search(b);
                if (headA != headB) {
                    students[headB] = headA;
                }
            }
            int result = 0;
            for (int i = 1; i <= n; i++) {
                if (students[i] == 0) {
                    result++;
                }
            }
            System.out.println("Case " + test + ": " + result);
            test++;
        }
    }

    static int search(int index) {
        while (students[index] != 0) {
            index = students[index];
        }
        return index;
    }
}
