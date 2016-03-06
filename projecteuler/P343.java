
public class P343 {

    public static void main(String args[]) {
        final int LIMIT = 2000000;
        long input1[] = new long[LIMIT];
        long input2[] = new long[LIMIT];
        for (int i = 0; i < LIMIT; i++) {
            long k = i + 1;
            input1[i] = k + 1;
            input2[i] = k * k - k + 1;
        }
        long output1[] = calcLargestPrimeFactors(input1);
        long output2[] = calcLargestPrimeFactors(input2);
        long sum = 0;
        for (int i = 0; i < LIMIT; i++) {
            long f = Math.max(output1[i], output2[i]) - 1;
            sum += f;
        }
        System.out.println(sum);
    }

    static long[] calcLargestPrimeFactors(long input[]) {
        long output[] = new long[input.length];
        for (int i = 0; i < input.length; i++) {
            long p = input[i];
            if (p > 1) {
                for (long j = i; j < input.length; j += p) {
                    int j1 = (int) j;
                    output[j1] = Math.max(output[j1], p);
                    do {
                        input[j1] /= p;
                    } while (input[j1] % p == 0);
                }
            }
        }
        return output;
    }
}