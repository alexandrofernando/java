package P1958__Strange_Towers_of_Hanoi;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-24
 * Time: 0:25:42
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        int results[] = new int[13];
        results[1] = 1;
        for (int i = 2; i <= 12; i++) {
            results[i] = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                int move = 2 * results[i - j] + ((int) Math.pow(2, j) - 1);
                if (move < results[i]) {
                    results[i] = move;
                }
            }
        }
        for (int i = 1; i <= 12; i++) {
            System.out.println(results[i]);
        }
    }
}
