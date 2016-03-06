
public class P199 {

    final static int ITERATION_LIMIT = 10;

    public static void main(String args[]) {
        double k = 1;
        double kOuter = 3 * k - 2 * Math.sqrt(3 * k * k);
        double coverArea = 0;
        coverArea += curvature2area(k) * 3;
        coverArea += fill(k, k, k, 1);
        coverArea += fill(k, k, kOuter, 1) * 3;
        System.out.printf("%.8f\n", 1 - coverArea / curvature2area(kOuter));
    }

    static double curvature2area(double k) {
        return Math.PI / k / k;
    }

    static double fill(double k1, double k2, double k3, int iteration) {
        double k4 = k1 + k2 + k3 + 2 * Math.sqrt(k1 * k2 + k2 * k3 + k3 * k1);
        double area = curvature2area(k4);
        if (iteration < ITERATION_LIMIT) {
            area += fill(k4, k1, k2, iteration + 1)
                    + fill(k4, k2, k3, iteration + 1)
                    + fill(k4, k3, k1, iteration + 1);
        }
        return area;
    }
}
