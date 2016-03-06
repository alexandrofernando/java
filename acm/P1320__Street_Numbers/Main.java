package P1320__Street_Numbers;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-16
 * Time: 7:46:54
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        int odd = 1;
        for (int i = 0; i < 10; i++) {
            while (true) {
                odd += 2;
                if (isSquare((odd * odd - 1) / 2) == true) {
                    int even = (int) Math.sqrt((odd * odd - 1) / 2);
                    System.out.printf("%10d%10d\n", odd * even, odd * odd - 1);
                    break;
                }
                if (isSquare((odd * odd + 1) / 2) == true) {
                    int even = (int) Math.sqrt((odd * odd + 1) / 2);
                    System.out.printf("%10d%10d\n", odd * even, odd * odd);
                    break;
                }
            }
        }
    }

    static boolean isSquare(int number) {
        int root = (int) Math.sqrt(number);
        if (root * root == number) {
            return true;
        } else {
            return false;
        }
    }
}
