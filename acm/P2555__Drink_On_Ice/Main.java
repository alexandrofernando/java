package P2555__Drink_On_Ice;

import java.util.Scanner;
import java.io.File;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        while (true) {
            double waterM = cin.nextDouble();
            double iceM = cin.nextDouble();
            double waterT = cin.nextDouble();
            double iceT = cin.nextDouble();
            if (waterM == 0 && iceM == 0 && waterT == 0 && iceT == 0) {
                break;
            }
            double energy = waterM * waterT * 4.19 + iceM * iceT * 2.09;
            double mixT;
            if (energy > 0) {
                if (energy > iceM * 335) {
                    mixT = (energy - iceM * 335) / (waterM + iceM) / 4.19;
                    waterM += iceM;
                    iceM = 0;
                } else {
                    double temp = energy / 335;
                    waterM += temp;
                    iceM -= temp;
                    mixT = 0;
                }
            } else {
                if (energy < -waterM * 335) {
                    mixT = (energy + waterM * 335) / (waterM + iceM) / 2.09;
                    iceM += waterM;
                    waterM = 0;
                } else {
                    double temp = energy / 335;
                    waterM += temp;
                    iceM -= temp;
                    mixT = 0;
                }
            }
            System.out.printf("%.1f g of ice and %.1f g of water at %.1f C\n",
                              iceM, waterM, mixT);
        }
    }
}
