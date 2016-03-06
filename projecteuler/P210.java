
public class P210 {

    public static void main(String args[]) {
        final long R = 1000000000;
        long nonObtuseCount = 0;
        long t = R / 4;
        long middle = -1;
        for (long s = R / 4; s >= 0; s--) {
            long dp;
            while (true) {
                dp = dotProduct(s, t, 0, 0, R / 2, 0);
                if (dp <= 0) {
                    break;
                }
                t--;
            }
            long p = t;
            if (dp == 0 && t > 0) {
                p--;
            }
            if (s % 2 != (p + 2) % 2) {
                p--;
            }
            long addition;
            if (s % 2 == 0) {
                addition = (R - p) / 2;
            } else {
                addition = (R - 1 - p) / 2;
            }
            if (s == R / 4) {
                middle = addition;
            }
            nonObtuseCount += addition;
        }
        nonObtuseCount *= 2;
        nonObtuseCount -= middle;
        nonObtuseCount *= 2;
        long total = 2 * R * R + 2 * R + 1;
        long invalid = R + 1;
        System.out.println(total - invalid - nonObtuseCount);
    }

    static long dotProduct(long x0, long y0, long x1, long y1, long x2, long y2) {
        return (x1 - x0) * (x2 - x0) + (y1 - y0) * (y2 - y0);
    }
}
