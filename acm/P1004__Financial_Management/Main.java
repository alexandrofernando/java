package P1004__Financial_Management;

import java.util.Scanner;
import java.text.NumberFormat;
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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        double sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += cin.nextDouble();
        }
        double average = sum / 12;
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        nf.setGroupingUsed(false);
        System.out.println("$" + nf.format(average));
    }
}
