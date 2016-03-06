
public class P181 {

    public static void main(String args[]) {
        final int BLACK = 60;
        final int WHITE = 40;
        long ways[][] = new long[BLACK + 1][WHITE + 1];
        ways[0][0] = 1;
        for (int i = 0; i <= BLACK; i++) {
            for (int j = 0; j <= WHITE; j++) {
                if (i != 0 || j != 0) {
                    for (int p = i; p <= BLACK; p++) {
                        for (int q = j; q <= WHITE; q++) {
                            ways[p][q] += ways[p - i][q - j];
                        }
                    }
                }
            }
        }
        System.out.println(ways[BLACK][WHITE]);
    }
}
