package P1316__Self_Numbers;

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
    public static void main(String[] args) {
        boolean hasGen[] = new boolean[10000];
        for (int i = 1; i < 10000; i++) {
            int next = i;
            int number = i;
            while (number != 0) {
                next += number % 10;
                number /= 10;
            }
            if (next < 10000) {
                hasGen[next] = true;
            }
        }
        for (int i = 1; i < 10000; i++) {
            if (hasGen[i] == false) {
                System.out.println(i);
            }
        }
    }
}
