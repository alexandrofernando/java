
import java.util.Arrays;

public class P258 {

    static final long MODULO = 20092010;
    static long ax[][] = new long[4][3999];

    public static void main(String args[]) {
        final long K = 1000000000000000000L;
        int src = 0;
        int trg = 1;
        int src_g = 2;
        int trg_g = 3;

        ax[src_g][0] = 1;

        long x = K / 2048;
        ax[src][48] = 1;
        ax[src][49] = 1;

        while (true) {
            if (x % 2 == 1) {
                multiply(src, src_g, trg_g);

                src_g = 5 - src_g;  // exchange
                trg_g = 5 - trg_g;
            }

            x /= 2;
            if (x == 0) {
                break;
            }

            multiply(src, src, trg);
            src = 1 - src;  // exchange
            trg = 1 - trg;
        }

        long answer = 0;
        for (int i = 0; i < 2000; i++) {
            answer += ax[src_g][i];
        }
        answer %= MODULO;
        System.out.println(answer);
    }

    // s0 * s1 -> t
    static void multiply(int s0, int s1, int t) {
        Arrays.fill(ax[t], 0);

        for (int i = 0; i < 2000; i++) {
            for (int j = 0; j < 2000; j++) {
                ax[t][i + j] += ax[s0][i] * ax[s1][j];
            }
        }

        for (int i = 2000; i < ax[t].length; i++) {
            ax[t][i - 2000] += ax[t][i];
            ax[t][i - 1999] += ax[t][i];
        }

        for (int i = 0; i < 2000; i++) {
            ax[t][i] %= MODULO;
        }
    }
}
