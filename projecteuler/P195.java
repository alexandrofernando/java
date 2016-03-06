
public class P195 {

    public static void main(String args[]) {
        System.out.println(T(1053779));
    }

    static int T(int r) {
        int limit = (int) Math.floor(2 * Math.sqrt(3) * r);
        int count = 0;
        for (int p = 1;; p++) {
            if (p % 3 == 0) {
                continue;
            }
            int n;
            boolean over1 = false;
            boolean over2 = false;
            for (n = 1; !(over1 && over2); n++) {
                if (gcd(p, n) != 1) {
                    continue;
                }
                if (!over1) {
                    long s1 = 3L * p * n + 3L * n * n;
                    if (s1 <= limit) {
                        count += limit / s1;
                    } else {
                        over1 = true;
                    }
                }
                if (!over2) {
                    long s2 = 3L * p * n + (long) p * p;
                    if (s2 <= limit) {
                        count += limit / s2;
                    } else {
                        over2 = true;
                    }
                }
            }
            if (n == 2) {
                break;
            }
        }
        return count;
    }

    static int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        while (a % b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return b;
    }
}
