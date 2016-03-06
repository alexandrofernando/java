
import java.util.HashSet;

public class P346 {

    public static void main(String args[]) {
        final long LIMIT = 1000000000000L;
        HashSet<Long> strongRepunit = new HashSet<Long>();
        long repunit;
        for (long base = 2; (repunit = base * base + base + 1) < LIMIT - 1;
                base++) {
            long power = base * base;
            while (repunit < LIMIT - 1) {
                strongRepunit.add(repunit);
                power *= base;
                repunit += power;
            }
        }
        long sum = 1;
        for (long sr : strongRepunit) {
            sum += sr;
        }
        System.out.println(sum);
    }
}
