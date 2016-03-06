package P3507__Judging_Olympia;

import java.util.Scanner;
import java.util.Arrays;
import java.text.NumberFormat;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-5-18
 * Time: 12:08:23
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int grades[] = new int[6];
            boolean power = false;
            for (int i = 0; i < 6; i++) {
                grades[i] = in.nextInt();
                if (grades[i] != 0) {
                    power = true;
                }
            }
            if (power == false) {
                break;
            }
            Arrays.sort(grades);
            int sum = 0;
            for (int i = 1; i <= 4; i++) {
                sum += grades[i];
            }
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumFractionDigits(0);
            System.out.println(nf.format(sum / 4.0));
        }
    }
}
