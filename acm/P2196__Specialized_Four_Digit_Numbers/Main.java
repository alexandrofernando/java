package P2196__Specialized_Four_Digit_Numbers;

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
        for (int i = 1000; i <= 9999; i++) {
            int sum10 = sum(i, 10);
            int sum16 = sum(i, 16);
            int sum12 = sum(i, 12);
            if (sum10 == sum16 && sum10 == sum12) {
                System.out.println(i);
            }
        }
    }

    static int sum(int number, int base) {
        int result = 0;
        while (number != 0) {
            result += number % base;
            number /= base;
        }
        return result;
    }
}
