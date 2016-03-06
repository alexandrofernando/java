
public class P285 {

    public static void main(String args[]) {
        final int LIMIT = 100000;
        double total = 0;
        for (int k = 1; k <= LIMIT; k++) {
            double area1 = (k == 1) ? 0 : (integral(Math.sqrt(((k - 0.5) * (k - 0.5) / k / k - 1.0 / k / k)), (k - 0.5) / k, k) - integral(1.0 / k, (k - 0.5) / k, k));
            double area2 = integral(Math.sqrt(((k + 0.5) * (k + 0.5) / k / k - 1.0 / k / k)), (k + 0.5) / k, k) - integral(1.0 / k, (k + 0.5) / k, k);
            total += (area2 - area1) * k;
        }
        System.out.printf("%.5f\n", total);
    }

    static double integral(double a, double r, double k) {
        return 0.5 * (a * Math.sqrt(r * r - a * a) + r * r * Math.atan(a / Math.sqrt(r * r - a * a))) - a / k;
    }
}
