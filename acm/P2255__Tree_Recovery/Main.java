package P2255__Tree_Recovery;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-8
 * Time: 7:50:59
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext() == true) {
            String preorder = in.next();
            String inorder = in.next();
            search(preorder, inorder);
            System.out.println();
        }
    }

    static void search(String preorder, String inorder) {
        if (preorder.equals("") == false) {
            char ch = preorder.charAt(0);
            int pos = inorder.indexOf(ch);
            search(preorder.substring(1, pos + 1), inorder.substring(0, pos));
            search(preorder.substring(pos + 1), inorder.substring(pos + 1));
            System.out.print(ch);
        }
    }
}
