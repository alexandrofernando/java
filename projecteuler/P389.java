import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class P389 {
	public static void main(String args[]) {
		TreeMap<Integer, Double> sum2count = new TreeMap<Integer, Double>();
		int sides[] = { 4, 6, 8, 12, 20 };
		for (int i = 0; i < sides.length; i++) {
			HashMap<Integer, Double> newSum2count = new HashMap<Integer, Double>();
			if (i == 0) {
				newSum2count.put(0, 1.0);
				newSum2count = dice(newSum2count, sides[i], 1);
			} else {
				int prevSum = 0;
				HashMap<Integer, Double> diceSum2count = new HashMap<Integer, Double>();
				diceSum2count.put(0, 1.0);
				for (int sum : sum2count.keySet()) {
					diceSum2count = dice(diceSum2count, sides[i], sum - prevSum);
					newSum2count = merge(newSum2count, diceSum2count,
							sum2count.get(sum));
					prevSum = sum;
				}
			}
			normalize(newSum2count);
			sum2count = new TreeMap<Integer, Double>(newSum2count);
		}

		double total = 0;
		double count = 0;
		for (Entry<Integer, Double> entry : sum2count.entrySet()) {
			total += entry.getValue() * entry.getKey();
			count += entry.getValue();
		}
		double expectation = total / count;
		double variance = 0;
		for (Entry<Integer, Double> entry : sum2count.entrySet()) {
			double diff = entry.getKey() - expectation;
			variance += diff * diff * entry.getValue();
		}
		variance /= count;
		System.out.printf("%.4f\n", variance);
	}

	static HashMap<Integer, Double> dice(HashMap<Integer, Double> sum2count,
			int side, int diceNum) {
		HashMap<Integer, Double> newSum2count = sum2count;
		HashMap<Integer, Double> singleDice = new HashMap<Integer, Double>();
		for (int j = 1; j <= side; j++) {
			singleDice.put(j, 1.0 / side);
		}
		for (int i = 0; i < diceNum; i++) {
			newSum2count = add(newSum2count, singleDice);
		}
		return newSum2count;
	}

	static void normalize(Map<Integer, Double> sum2count) {
		double countTotal = 0;
		for (double count : sum2count.values()) {
			countTotal += count;
		}
		for (Entry<Integer, Double> entry : sum2count.entrySet()) {
			sum2count.put(entry.getKey(), entry.getValue() / countTotal);
		}
	}

	static HashMap<Integer, Double> merge(HashMap<Integer, Double> sum2count1,
			HashMap<Integer, Double> sum2count2, Double weight2) {
		HashMap<Integer, Double> merged = new HashMap<Integer, Double>();
		HashSet<Integer> keys = new HashSet<Integer>();
		keys.addAll(sum2count1.keySet());
		keys.addAll(sum2count2.keySet());
		for (int key : keys) {
			double count1 = sum2count1.containsKey(key) ? sum2count1.get(key)
					: 0;
			double count2 = sum2count2.containsKey(key) ? sum2count2.get(key)
					: 0;
			merged.put(key, count1 + count2 * weight2);
		}
		return merged;
	}

	static HashMap<Integer, Double> add(Map<Integer, Double> sum2count1,
			Map<Integer, Double> sum2count2) {
		HashMap<Integer, Double> total = new HashMap<Integer, Double>();
		for (Entry<Integer, Double> entry1 : sum2count1.entrySet()) {
			for (Entry<Integer, Double> entry2 : sum2count2.entrySet()) {
				int sum = entry1.getKey() + entry2.getKey();
				double oldCount = total.containsKey(sum) ? total.get(sum) : 0;
				total.put(sum, oldCount + entry1.getValue() * entry2.getValue());
			}
		}
		normalize(total);
		return total;
	}
}
