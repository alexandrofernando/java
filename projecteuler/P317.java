
public class P317 {

    public static void main(String args[]) {
        double h = 100;
        double v0 = 20;
        double g = 9.81;
        double volume = Math.PI * v0 * v0 / g * (h + v0 * v0 / (2 * g)) * (h + v0 * v0 / (2 * g));
        System.out.printf("%.4f\n", volume);
    }
}
