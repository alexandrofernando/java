package P1577__Falling_Leaves;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-28
 * Time: 17:00:03
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int lefts[];
    static int rights[];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String str;
            Stack<String> stack = new Stack<String>();
            while (true) {
                str = in.next();
                if (str.equals("*") == true || str.equals("$") == true) {
                    break;
                }
                stack.push(str);
            }
            lefts = new int[26];
            rights = new int[26];
            boolean exists[] = new boolean[26];
            for (int i = 0; i < 26; i++) {
                lefts[i] = -1;
                rights[i] = -1;
            }
            int root = stack.peek().charAt(0) - 'A';
            while (stack.empty() == false) {
                String temp = stack.pop();
                for (int i = 0; i < temp.length(); i++) {
                    int index = temp.charAt(i) - 'A';
                    exists[index] = true;
                    boolean power = false;
                    for (int j = index - 1; j >= 0; j--) {
                        if (exists[j] == true) {
                            if (rights[j] == -1) {
                                rights[j] = index;
                                power = true;
                            }
                            break;
                        }
                    }
                    if (power == false) {
                        for (int j = index + 1; j < 26; j++) {
                            if (exists[j] == true) {
                                lefts[j] = index;
                                break;
                            }
                        }
                    }
                }
            }
            preorder(root);
            System.out.println();
            if (str.equals("$") == true) {
                break;
            }
        }
    }

    static void preorder(int index) {
        System.out.print((char) (index + 'A'));
        if (lefts[index] != -1) {
            preorder(lefts[index]);
        }
        if (rights[index] != -1) {
            preorder(rights[index]);
        }
    }
}
