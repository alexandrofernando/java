package P3250__Bad_Hair_Day;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-21
 * Time: 23:16:04
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        long sum = 0;
        for (int i = 0; i < N; i++) {
            int height = in.nextInt();
            while (stack.empty() == false && stack.peek() <= height) {
                stack.pop();
            }
            sum += stack.size();
            stack.push(height);
        }
        System.out.println(sum);
    }
}
