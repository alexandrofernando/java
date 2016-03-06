import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class P151 {
	static HashMap<ArrayList<Integer>, Double> expectations = new HashMap<ArrayList<Integer>, Double>();

	public static void main(String args[]) {
		ArrayList<Integer> envelope = new ArrayList<Integer>();
		envelope.add(1);
		double e = search(envelope, 1);
		System.out.printf("%.6f", e);
	}

	static double search(ArrayList<Integer> envelope, double prob) {
		if (envelope.size() == 0) {
			return 0;
		}
		Double e = expectations.get(envelope);
		if (e != null) {
			return prob * e.doubleValue();
		}
		double result = 0;
		if (envelope.size() == 1 && envelope.get(0) != 1
				&& envelope.get(0) != 5) {
			result += 1;
		}
		int size = envelope.size();
		for (int i = 0; i < size; i++) {
			int take = envelope.remove(i);
			for (int j = take + 1; j <= 5; j++) {
				envelope.add(j);
			}
			Collections.sort(envelope);
			result += search(envelope, 1.0 / size);
			for (int j = take + 1; j <= 5; j++) {
				envelope.remove(new Integer(j));
			}
			envelope.add(take);
			Collections.sort(envelope);
		}
		expectations.put(envelope, result);
		return prob * result;
	}
}
