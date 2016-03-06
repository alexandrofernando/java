package P1141__Brackets_Sequence;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-11-9
 * Time: 22:17:57
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        if (cin.hasNext() == true) {
            String str = cin.next();
            int length = str.length();
            int d[][] = new int[length][length];
            String regulars[][] = new String[length][length];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    regulars[i][j] = "";
                }
            }
            for (int i = 0; i < length; i++) {
                d[i][i] = 1;
                char ch = str.charAt(i);
                if (ch == '(' || ch == ')') {
                    regulars[i][i] = "()";
                } else if (ch == '[' || ch == ']') {
                    regulars[i][i] = "[]";
                }
            }
            for (int distance = 1; distance <= length - 1; distance++) {
                for (int i = 0; i < length - distance; i++) {
                    int j = i + distance;
                    d[i][j] = Integer.MAX_VALUE;
                    char ch1 = str.charAt(i);
                    char ch2 = str.charAt(j);
                    if ((ch1 == '(' && ch2 == ')') || (ch1 == '[' && ch2 == ']')) {
                        if (d[i + 1][j - 1] < d[i][j]) {
                            d[i][j] = d[i + 1][j - 1];
                            regulars[i][j] = ch1 + regulars[i + 1][j - 1] + ch2;
                        }
                    }
                    if (ch1 == '(' || ch1 == '[') {
                        if (d[i + 1][j] + 1 < d[i][j]) {
                            d[i][j] = d[i + 1][j] + 1;
                            if (ch1 == '(') {
                                regulars[i][j] = '(' + regulars[i + 1][j] + ')';
                            } else if (ch1 == '[') {
                                regulars[i][j] = '[' + regulars[i + 1][j] + ']';
                            }
                        }
                    }
                    if (ch2 == ')' || ch2 == ']') {
                        if (d[i][j - 1] + 1 < d[i][j]) {
                            d[i][j] = d[i][j - 1] + 1;
                            if (ch2 == ')') {
                                regulars[i][j] = '(' + regulars[i][j - 1] + ')';
                            } else if (ch2 == ']') {
                                regulars[i][j] = '[' + regulars[i][j - 1] + ']';
                            }
                        }
                    }
                    for (int k = i; k < j; k++) {
                        if (d[i][k] + d[k + 1][j] < d[i][j]) {
                            d[i][j] = d[i][k] + d[k + 1][j];
                            regulars[i][j] = regulars[i][k] + regulars[k + 1][j];
                        }
                    }
                }
            }
            System.out.println(regulars[0][length - 1]);
        } else {
            System.out.println();
        }
    }
}
