package P3299__Humidex;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-23
 * Time: 5:55:00
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            double temperature = -101;
            double dewpoint = -101;
            double humidex = -101;
            char ch1 = in.next().charAt(0);
            if (ch1 == 'E') {
                break;
            }
            if (ch1 == 'T') {
                temperature = in.nextDouble();
            } else if (ch1 == 'D') {
                dewpoint = in.nextDouble();
            } else {
                humidex = in.nextDouble();
            }
            char ch2 = in.next().charAt(0);
            if (ch2 == 'T') {
                temperature = in.nextDouble();
            } else if (ch2 == 'D') {
                dewpoint = in.nextDouble();
            } else {
                humidex = in.nextDouble();
            }
            if (temperature == -101) {
                double e = 6.11 * Math.exp(5417.7530 * (1 / 273.16 - 1 / (dewpoint + 273.16)));
                double h = 0.5555 * (e - 10.0);
                temperature = humidex - h;
            } else if (dewpoint == -101) {
                double h = humidex - temperature;
                double e = h / 0.5555 + 10.0;
                dewpoint = 1 / (1 / 273.16 - Math.log(e / 6.11) / 5417.7530) - 273.16;
            } else {
                double e = 6.11 * Math.exp(5417.7530 * (1 / 273.16 - 1 / (dewpoint + 273.16)));
                double h = 0.5555 * (e - 10.0);
                humidex = temperature + h;
            }
            System.out.printf("T %.1f D %.1f H %.1f\n", temperature, dewpoint, humidex);
        }
    }
}
