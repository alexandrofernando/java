
import java.util.HashMap;

public class P345 {

    static int matrix[][] = new int[][]{
        {7, 53, 183, 439, 863, 497, 383, 563, 79, 973, 287, 63, 343, 169, 583},
        {627, 343, 773, 959, 943, 767, 473, 103, 699, 303, 957, 703, 583, 639, 913},
        {447, 283, 463, 29, 23, 487, 463, 993, 119, 883, 327, 493, 423, 159, 743},
        {217, 623, 3, 399, 853, 407, 103, 983, 89, 463, 290, 516, 212, 462, 350},
        {960, 376, 682, 962, 300, 780, 486, 502, 912, 800, 250, 346, 172, 812, 350},
        {870, 456, 192, 162, 593, 473, 915, 45, 989, 873, 823, 965, 425, 329, 803},
        {973, 965, 905, 919, 133, 673, 665, 235, 509, 613, 673, 815, 165, 992, 326},
        {322, 148, 972, 962, 286, 255, 941, 541, 265, 323, 925, 281, 601, 95, 973},
        {445, 721, 11, 525, 473, 65, 511, 164, 138, 672, 18, 428, 154, 448, 848},
        {414, 456, 310, 312, 798, 104, 566, 520, 302, 248, 694, 976, 430, 392, 198},
        {184, 829, 373, 181, 631, 101, 969, 613, 840, 740, 778, 458, 284, 760, 390},
        {821, 461, 843, 513, 17, 901, 711, 993, 293, 157, 274, 94, 192, 156, 574},
        {34, 124, 4, 878, 450, 476, 712, 914, 838, 669, 875, 299, 823, 329, 699},
        {815, 559, 813, 459, 522, 788, 168, 586, 966, 232, 308, 833, 251, 631, 107},
        {813, 883, 451, 509, 615, 77, 281, 613, 459, 205, 380, 274, 302, 35, 805}
    };
    static HashMap<Integer, Integer> history = new HashMap<Integer, Integer>();

    public static void main(String args[]) {
        int matrixSum = search(0, new boolean[matrix.length]);
        System.out.println(matrixSum);
    }

    static int search(int index, boolean used[]) {
        if (index == matrix.length) {
            return 0;
        }
        int code = encode(used);
        Integer restMax = history.get(code);
        if (restMax != null) {
            return restMax;
        }
        int max = -1;
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                max = Math.max(max, matrix[index][i] + search(index + 1, used));
                used[i] = false;
            }
        }
        history.put(code, max);
        return max;
    }

    static int encode(boolean array[]) {
        int code = 0;
        for (boolean b : array) {
            code = code * 2 + (b ? 1 : 0);
        }
        return code;
    }
}
