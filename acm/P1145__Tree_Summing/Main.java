package P1145__Tree_Summing;

import java.util.Scanner;
import java.io.File;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    static Scanner cin;
    static boolean empty;
    static boolean exist;
    public static void main(String[] args) throws Exception {
        cin = new Scanner(System.in);
        while (cin.hasNextInt() == true) {
            int target = cin.nextInt();
            empty = true;
            cin.useDelimiter("\\p{javaWhitespace}*\\(\\p{javaWhitespace}*|\\p{javaWhitespace}*\\)\\p{javaWhitespace}*");
            exist = false;
            search(target);
            if (exist == true && empty == false) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
            cin.useDelimiter("\\p{javaWhitespace}+");
            cin.next();
        }
    }

    static boolean search(int target) {
        String str = cin.next();
        Scanner cin1 = new Scanner(str);
        if (cin1.hasNextInt() == false) {
            return true;
        }
        else {
            int node = cin1.nextInt();
            empty = false;
            boolean isLeaf1 = search(target - node);
            cin.next();
            boolean isLeaf2 = search(target - node);
            cin.next();
            if (isLeaf1 && isLeaf2 == true && node == target) {
                exist = true;
            }
            return false;
        }
    }
}
