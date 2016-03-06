import java.util.ArrayList;

public class P371 {
	public static void main(String args[]) {
		final double ERROR = 1E-12;
		ArrayList<TransProb> transProbs = new ArrayList<TransProb>();
		for (int i = 0; i <= 499; i++) {
			transProbs.add(new TransProb(i * 2, i * 2, (i + 1) / 1000.0));
			transProbs.add(new TransProb(i * 2, i * 2 + 1, 0.001));
			if (i != 499) {
				transProbs.add(new TransProb(i * 2, i * 2 + 2,
						(998 - i * 2) / 1000.0));
			}
			if (i != 0) {
				transProbs.add(new TransProb(i * 2, 1000, i / 1000.0));
			}

			transProbs
					.add(new TransProb(i * 2 + 1, i * 2 + 1, (i + 1) / 1000.0));
			if (i != 499) {
				transProbs.add(new TransProb(i * 2 + 1, i * 2 + 3,
						(998 - i * 2) / 1000.0));
			}
			transProbs.add(new TransProb(i * 2 + 1, 1000, (i + 1) / 1000.0));
		}
		double p[] = new double[1001];
		p[0] = 1;
		double expectedStep = 0;
		for (int step = 1;; step++) {
			p = multiply(p, transProbs);
			double addition = step * p[1000];
			if (expectedStep > 0 && addition < ERROR) {
				break;
			}
			expectedStep += addition;
		}
		System.out.printf("%.8f\n", expectedStep);
	}

	static double[] multiply(double a[], ArrayList<TransProb> transProbs) {
		double b[] = new double[a.length];
		for (TransProb transProb : transProbs) {
			b[transProb.to] += a[transProb.from] * transProb.p;
		}
		return b;
	}
}

class TransProb {
	int from;
	int to;
	double p;

	TransProb(int from, int to, double p) {
		this.from = from;
		this.to = to;
		this.p = p;
	}
}