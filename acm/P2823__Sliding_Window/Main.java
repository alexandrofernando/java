package P2823__Sliding_Window;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-1-21
 * Time: 22:59:21
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int array[] = new int[n];
        line = stdin.readLine();
        st = new StringTokenizer(line);
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int minOrder[] = new int[n];
        int head = 0;
        int tail = 0;
        for (int i = 0; i < K - 1; i++) {
            while (head > tail && array[i] <= array[minOrder[head - 1]]) {
                head--;
            }
            minOrder[head] = i;
            head++;
        }
        for (int i = K - 1; i < n; i++) {
            while (head > tail && array[i] <= array[minOrder[head - 1]]) {
                head--;
            }
            minOrder[head] = i;
            head++;
            while (minOrder[tail] < i - K + 1) {
                tail++;
            }
            if (i != K - 1) {
                System.out.print(" ");
            }
            System.out.print(array[minOrder[tail]]);
        }
        System.out.println();
        int maxOrder[] = new int[n];
        head = 0;
        tail = 0;
        for (int i = 0; i < K - 1; i++) {
            while (head > tail && array[i] >= array[maxOrder[head - 1]]) {
                head--;
            }
            maxOrder[head] = i;
            head++;
        }
        for (int i = K - 1; i < n; i++) {
            while (head > tail && array[i] >= array[maxOrder[head - 1]]) {
                head--;
            }
            maxOrder[head] = i;
            head++;
            while (maxOrder[tail] < i - K + 1) {
                tail++;
            }
            if (i != K - 1) {
                System.out.print(" ");
            }
            System.out.print(array[maxOrder[tail]]);
        }
        System.out.println();
    }
}