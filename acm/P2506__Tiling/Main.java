package P2506__Tiling;

import java.util.Scanner;
import java.io.File;
import java.math.BigDecimal;

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
        BigDecimal numbers[] = new BigDecimal[251];
        numbers[0] = new BigDecimal(1);
        numbers[1] = new BigDecimal(1);
        for (int i = 2; i <= 250; i++) {
            numbers[i] = numbers[i -
                2].multiply(new BigDecimal(2)).add(numbers[i - 1]);
        }
        while (cin.hasNextInt() == true) {
            System.out.println(numbers[cin.nextInt()]);
        }
    }
}
