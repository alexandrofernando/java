import java.util.HashSet;
import java.util.Hashtable;

public class P075 {
	public static void main(String args[]) {
		HashSet<Integer> skips = new HashSet<Integer>();
		Hashtable<Integer, Integer> valids = new Hashtable<Integer, Integer>();
		for (int i = 1; i <= 612; i++) {
			for (int j = i + 1; i * i + j * j <= 750000; j++) {
				int a = j * j - i * i;
				int b = 2 * i * j;
				int c = j * j + i * i;
				int min = Math.min(a, b);
				int length = a + b + c;
				for (int k = length, r = min; k <= 1500000; k += length, r += min) {
					if (skips.contains(k)) {
						continue;
					}
					Integer s = valids.get(k);
					if (s == null) {
						valids.put(k, r);
					} else if (s.intValue() != r) {
						skips.add(k);
						valids.remove(k);
					}
				}
			}
		}
		System.out.println(valids.size());
	}
}
