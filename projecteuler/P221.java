import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class P221 {
	public static void main(String args[]) {
		ArrayList<Double> alexandrians = new ArrayList<Double>();
		int LIMIT = 150000;
		for (double p = 1;; p++) {
			double minA = 4 * p * p * p;
			int minPos = Collections.binarySearch(alexandrians, minA);
			if (minPos < 0) {
				minPos = -1 - minPos;
			}
			if (minPos + 1 > LIMIT) {
				break;
			}
			double target = p * p + 1;
			for (double i = p; i >= 1; i--) {
				if (target % i == 0) {
					double q = -i - p;
					double r = -target / i - p;
					double A = p * q * r;
					int pos = Collections.binarySearch(alexandrians, A);
					if (pos < 0) {
						pos = -1 - pos;
						alexandrians.add(pos, A);
					}
				}
			}
		}
		DecimalFormat df = new DecimalFormat("0");
		System.out.println(df.format(alexandrians.get(LIMIT - 1)));
	}
}
