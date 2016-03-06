
import java.util.ArrayList;

public class P167 {

    public static void main(String args[]) {
        final long K = 100000000000L;
        long sum = 0;
        for (int n = 2; n <= 10; n++) {
            sum += ulam2(n, K);
        }
        System.out.println(sum);
    }

    static long ulam2(int n, long k) {
        boolean s[] = new boolean[4 * n + 4];
        s[1] = true;
        s[4 * n + 3] = true;
        for (int i = 2 * n; i <= 4 * n + 2; i += 2) {
            s[i] = true;
        }
        int precedeNum = n + 4;
        int index = s.length - 1;
        long code = 0;
        for (boolean b : s) {
            code = code * 2 + (b ? 1 : 0);
        }
        int number = 4 * n + 4;
        long mask = 1;
        for (int i = 0; i < s.length; i++) {
            mask *= 2;
        }
        int period = 0;
        int loopBegin = 8 * n + 9;
        long loopCode = -1;
        int baseDiff = -1;
        ArrayList<Integer> offsetsInloop = new ArrayList<Integer>();
        while (true) {
            number++;
            index = (index + 1) % s.length;
            boolean nextS =
                    (number % 2 == 0)
                    ? false
                    : s[index] ^ s[(index - 2 + s.length) % s.length];
            code = (code * 2 + (nextS ? 1 : 0)) % mask;
            if (number + 1 == loopBegin) {
                loopCode = code;
            } else if (code == loopCode) {
                baseDiff = number + 1 - loopBegin;
                break;
            }
            if (nextS) {
                if (number + 1 >= loopBegin) {
                    period++;
                    offsetsInloop.add(number - loopBegin);
                } else {
                    precedeNum++;
                }
            }
            s[index] = nextS;
        }

        long periodNum = (k - precedeNum) / period;
        int numInPeriod = (int) ((k - precedeNum) % period);
        if (numInPeriod == 0) {
            periodNum--;
            numInPeriod = offsetsInloop.size();
        }
        return loopBegin + periodNum * baseDiff + offsetsInloop.get(numInPeriod - 1);
    }
}
