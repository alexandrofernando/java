package P3307__Smart_Sister;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-3
 * Time: 4:36:00
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        ArrayList<Long> numbers = new ArrayList<Long>();
        long temp2 = 1;
        for (int i = 0; i <= 59; i++) {
            long temp3 = 1;
            for (int j = 0; j <= 37; j++) {
                if (temp2 * temp3 >= 1E18) {
                    break;
                }
                long temp5 = 1;
                for (int k = 0; k <= 25; k++) {
                    if (temp2 * temp3 * temp5 >= 1E18) {
                        break;
                    }
                    long temp7 = 1;
                    for (int p = 0; p <= 21; p++) {
                        if (temp2 * temp3 * temp5 * temp7 >= 1E18) {
                            break;
                        }
                        numbers.add(temp2 * temp3 * temp5 * temp7);
                        temp7 *= 7;
                    }
                    temp5 *= 5;
                }
                temp3 *= 3;
            }
            temp2 *= 2;
        }
        Collections.sort(numbers);
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            System.out.println(numbers.get(in.nextInt() - 1));
        }
    }
}
