package P1837__Balance;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int C = in.nextInt();
		int G = in.nextInt();
		int hooks[] = new int[C];
		for (int i = 0; i < C; i++) {
			hooks[i] = in.nextInt();
		}
		int weights[] = new int[G];
		for (int i = 0; i < G; i++) {
			weights[i] = in.nextInt();
		}
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		table.put(0, 1);
		for (int i = 0; i < G; i++) {
			Hashtable<Integer, Integer> nextTable = new Hashtable<Integer, Integer>();
			Iterator<Entry<Integer, Integer>> iter = table.entrySet()
					.iterator();
			while (iter.hasNext()) {
				Entry<Integer, Integer> entry = iter.next();
				int moment = entry.getKey();
				int count = entry.getValue();
				for (int j = 0; j < C; j++) {
					int nextMoment = moment + weights[i] * hooks[j];
					Integer oldCount = nextTable.get(nextMoment);
					if (oldCount == null) {
						nextTable.put(nextMoment, count);
					} else {
						nextTable.put(nextMoment, oldCount.intValue() + count);
					}
				}
			}
			table = nextTable;
		}
		System.out.println(table.get(0));
	}
}
