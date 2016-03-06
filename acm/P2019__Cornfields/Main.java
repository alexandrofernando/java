package P2019__Cornfields;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-22
 * Time: 5:55:21
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int B = in.nextInt();
        int K = in.nextInt();
        int matrix[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        int colMin[][] = new int[N - B + 1][N];
        int colMax[][] = new int[N - B + 1][N];
        for (int j = 0; j < N; j++) {
            TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
            for (int i = 0; i < N; i++) {
                if (map.containsKey(matrix[i][j]) == true) {
                    map.put(matrix[i][j], map.get(matrix[i][j]) + 1);
                } else {
                    map.put(matrix[i][j], 1);
                }
                if (i - B + 1 >= 0) {
                    colMin[i - B + 1][j] = map.firstKey();
                    colMax[i - B + 1][j] = map.lastKey();
                    int count = map.get(matrix[i - B + 1][j]);
                    if (count > 1) {
                        map.put(matrix[i - B + 1][j], count - 1);
                    } else {
                        map.remove(matrix[i - B + 1][j]);
                    }
                }
            }
        }
        int min[][] = new int[N - B + 1][N - B + 1];
        int max[][] = new int[N - B + 1][N - B + 1];
        for (int i = 0; i < N - B + 1; i++) {
            TreeMap<Integer, Integer> mapMin = new TreeMap<Integer, Integer>();
            TreeMap<Integer, Integer> mapMax = new TreeMap<Integer, Integer>();
            for (int j = 0; j < N; j++) {
                if (mapMin.containsKey(colMin[i][j]) == true) {
                    mapMin.put(colMin[i][j], mapMin.get(colMin[i][j]) + 1);
                } else {
                    mapMin.put(colMin[i][j], 1);
                }
                if (mapMax.containsKey(colMax[i][j]) == true) {
                    mapMax.put(colMax[i][j], mapMax.get(colMax[i][j]) + 1);
                } else {
                    mapMax.put(colMax[i][j], 1);
                }
                if (j - B + 1 >= 0) {
                    min[i][j - B + 1] = mapMin.firstKey();
                    max[i][j - B + 1] = mapMax.lastKey();
                    int count = mapMin.get(colMin[i][j - B + 1]);
                    if (count > 1) {
                        mapMin.put(colMin[i][j - B + 1], count - 1);
                    } else {
                        mapMin.remove(colMin[i][j - B + 1]);
                    }
                    count = mapMax.get(colMax[i][j - B + 1]);
                    if (count > 1) {
                        mapMax.put(colMax[i][j - B + 1], count - 1);
                    } else {
                        mapMax.remove(colMax[i][j - B + 1]);
                    }
                }
            }
        }
        for (int i = 0; i < K; i++) {
            int row = in.nextInt() - 1;
            int column = in.nextInt() - 1;
            System.out.println(max[row][column] - min[row][column]);
        }
    }
}
