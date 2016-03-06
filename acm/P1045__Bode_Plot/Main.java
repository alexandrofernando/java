package P1045__Bode_Plot;

import java.util.Scanner;
import java.text.NumberFormat;

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
        double Vs = cin.nextDouble();
        double R = cin.nextDouble();
        double C = cin.nextDouble();
        int test = cin.nextInt();
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(3);
        nf.setMinimumFractionDigits(3);
        for (int t = 1; t <= test; t++) {
            double w = cin.nextDouble();
            double Vr = Vs * R / Math.sqrt(R * R + 1.0 / w / w / C / C);
            System.out.println(nf.format(Vr));
        }
    }
}
