package P1159__Palindrome;

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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        String str1 = cin.next();
        String str2 = new StringBuffer(str1).reverse().toString();
        int length = str1.length();
        int lcs[] = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            int newlcs[] = new int[length + 1];
            for (int j = 1; j <= length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    newlcs[j] = lcs[j - 1] + 1;
                }
                else if (lcs[j] >= newlcs[j - 1]) {
                    newlcs[j] = lcs[j];
                }
                else {
                    newlcs[j] = newlcs[j - 1];
                }
            }
            lcs = newlcs;
        }
        int result = length - lcs[length];
        System.out.println(result);
    }
}
