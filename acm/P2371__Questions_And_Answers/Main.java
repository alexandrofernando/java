package P2371__Questions_And_Answers;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int numbers[] = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = cin.nextInt();
        }
        Arrays.sort(numbers);
        cin.next();
        int K = cin.nextInt();
        for (int i = 0; i < K; i++) {
            int index = cin.nextInt() - 1;
            System.out.println(numbers[index]);
        }
    }
}
