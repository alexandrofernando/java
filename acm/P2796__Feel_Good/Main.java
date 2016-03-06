package P2796__Feel_Good;

import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-5-2
 * Time: 11:24:56
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        long values[] = new long[n + 1];
        long sums[] = new long[n + 1];
        line = stdin.readLine();
        st = new StringTokenizer(line);
        for (int i = 1; i <= n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
            sums[i] = sums[i - 1] + values[i];
        }
        int rights[] = new int[n + 1];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 1; i <= n; i++) {
            while (stack.empty() == false && values[stack.peek()] > values[i]) {
                rights[stack.pop()] = i - 1;
            }
            stack.push(i);
        }
        while (stack.empty() == false) {
            rights[stack.pop()] = n;
        }
        int lefts[] = new int[n + 1];
        stack = new Stack<Integer>();
        for (int i = n; i >= 1; i--) {
            while (stack.empty() == false && values[stack.peek()] > values[i]) {
                lefts[stack.pop()] = i + 1;
            }
            stack.push(i);
        }
        while (stack.empty() == false) {
            lefts[stack.pop()] = 1;
        }
        long max = -1;
        int left = -1;
        int right = -1;
        for (int i = 1; i <= n; i++) {
            long temp = values[i] * (sums[rights[i]] - sums[lefts[i] - 1]);
            if (temp > max) {
                max = temp;
                left = lefts[i];
                right = rights[i];
            }
        }
        System.out.println(max);
        System.out.println(left + " " + right);
    }
}
