package P3211__Washing_Clothes;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-20
 * Time: 3:48:05
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int M = in.nextInt();
            int N = in.nextInt();
            if (M == 0 && N == 0) {
                break;
            }
            Hashtable<String, ArrayList<Integer>> clothes = new Hashtable<String, ArrayList<Integer>>();
            for (int i = 0; i < M; i++) {
                String color = in.next();
                clothes.put(color, new ArrayList<Integer>());
            }
            for (int i = 0; i < N; i++) {
                int time = in.nextInt();
                String color = in.next();
                clothes.get(color).add(time);
            }
            int total = 0;
            Iterator<ArrayList<Integer>> iterator = clothes.values().iterator();
            while (iterator.hasNext() == true) {
                ArrayList<Integer> times = iterator.next();
                int sum = 0;
                for (int i = 0; i < times.size(); i++) {
                    sum += times.get(i);
                }
                int min = sum;
                TreeSet<Integer> parts = new TreeSet<Integer>();
                parts.add(0);
                for (int i = 0; i < times.size(); i++) {
                    TreeSet<Integer> temp = new TreeSet<Integer>();
                    Iterator<Integer> iter = parts.iterator();
                    while (iter.hasNext() == true) {
                        int value = iter.next() + times.get(i);
                        if (value * 2 <= sum) {
                            temp.add(value);
                        }
                    }
                    parts.addAll(temp);
                }
                total += sum - parts.last();
            }
            System.out.println(total);
        }
    }
}
