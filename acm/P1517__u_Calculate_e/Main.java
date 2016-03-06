package P1517__u_Calculate_e;

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
        System.out.println("n e");
        System.out.println("- -----------");
        double e = 0;
        double a = 1;
        for (int i = 0; i <= 9; i++) {
            if (i > 0) {
                a *= i;
            }
            e += 1 / a;
            System.out.println(i + " " + e);
        }
    }
}
