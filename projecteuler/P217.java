
public class P217 {

    static final long MODULO = 14348907;

    public static void main(String args[]) {
        final int N = 47;
        SumSet s[][][] = new SumSet[N / 2 + 1][10][];
        for (int i = 1; i < s.length; i++) {
            for (int j = 0; j < 10; j++) {
                s[i][j] = new SumSet[9 * i + 1];
                for (int k = 0; k < s[i][j].length; k++) {
                    s[i][j][k] = new SumSet(0, 0);
                    if (i == 1) {
                        if (j == k && j != 0) {
                            s[i][j][k].count = 1;
                            s[i][j][k].sum = j;
                        }
                    } else if (k >= j && k - j <= 9 * (i - 1)) {
                        for (int p = 0; p < 10; p++) {
                            s[i][j][k].count = addMod(s[i][j][k].count,
                                    s[i - 1][p][k - j].count);
                            s[i][j][k].sum = addMod(s[i][j][k].sum,
                                    s[i - 1][p][k - j].sum * 10
                                    + s[i - 1][p][k - j].count * j);
                        }
                    }
                }
            }
        }
        long tn = 45;
        for (int i = 2; i <= N; i++) {
            int halfN = i / 2;
            long base = 1;
            for (int j = 0; j < halfN; j++) {
                base = multiplyMod(base, 10);
            }
            int remainder = i % 2;
            long total = 0;
            for (int j = 1; j < s[halfN][0].length; j++) {
                long sum1 = 0;
                long count1 = 0;
                for (int k = 0; k < 10; k++) {
                    sum1 = addMod(sum1, s[halfN][k][j].sum);
                    count1 = addMod(count1, s[halfN][k][j].count);
                }
                long sum0 = sum1;
                long count0 = count1;
                for (int k = halfN - 1; j <= k * 9; k--) {
                    for (int p = 0; p < 10; p++) {
                        sum0 = addMod(sum0, s[k][p][j].sum);
                        count0 = addMod(count0, s[k][p][j].count);
                    }
                }
                if (remainder == 0) {
                    total = addMod(total,
                            multiplyMod(multiplyMod(count0, sum1), base)
                            + multiplyMod(count1, sum0));
                } else {
                    total = addMod(total,
                            (multiplyMod(multiplyMod(count0, sum1), base) * 10
                            + multiplyMod(count1, sum0)) * 10
                            + 45 * multiplyMod(multiplyMod(base, count1), count0));
                }
            }
            tn = addMod(tn, total);
        }
        System.out.println(tn);
    }

    static long addMod(long a, long b) {
        return (a + b) % MODULO;
    }

    static long multiplyMod(long a, long b) {
        return (a * b) % MODULO;
    }
}

class SumSet {

    long count;
    long sum;

    SumSet(long count, long sum) {
        this.count = count;
        this.sum = sum;
    }
}