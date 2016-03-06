public class P205 {
	public static void main(String args[]) {
		double dice4[] = new double[37];
		double dice6[] = new double[37];
		calcProbability(dice4, 4, 0, 1, 9);
		calcProbability(dice6, 6, 0, 1, 6);
		double answer = 0;
		for (int i = 0; i < dice4.length; i++) {
			for (int j = 0; j < i; j++) {
				answer += dice4[i] * dice6[j];
			}
		}
		System.out.printf("%.7f", answer);
	}

	static void calcProbability(double dice[], int diceSide, int sum, double p,
			int rest) {
		if (rest == 0) {
			dice[sum] += p;
		} else {
			for (int i = 1; i <= diceSide; i++) {
				calcProbability(dice, diceSide, sum + i, p / diceSide, rest - 1);
			}
		}
	}
}
