public class P109 {
	static int equal12 = 0;

	public static void main(String args[]) {
		int answer = 0;
		for (int i = 1; i <= 3; i++) {
			if (i == 3) {
				answer += (checkout(i, new String[i], 0, 0) - equal12) / 2
						+ equal12;
			} else {
				answer += checkout(i, new String[i], 0, 0);
			}
		}
		System.out.println(answer);
	}

	static int checkout(int target, String history[], int dart, int score) {
		if (dart == target) {
			if (score >= 100) {
				return 0;
			}
			if (target == 3) {
				if (history[0].compareTo(history[1]) == 0) {
					equal12++;
				}
			}
			return 1;
		}
		int sum = 0;
		if (dart == target - 1) {
			for (int i = 1; i <= 20; i++) {
				history[dart] = "D" + i;
				sum += checkout(target, history, dart + 1, score + i * 2);
			}
			history[dart] = "D25";
			sum += checkout(target, history, dart + 1, score + 50);
		} else {
			String marks[] = { "S", "D", "T" };
			for (int i = 1; i <= 20; i++) {
				for (int j = 0; j < 3; j++) {
					history[dart] = marks[j] + i;
					sum += checkout(target, history, dart + 1, score + i
							* (j + 1));
				}
			}
			history[dart] = "S25";
			sum += checkout(target, history, dart + 1, score + 25);
			history[dart] = "D25";
			sum += checkout(target, history, dart + 1, score + 50);
		}
		return sum;
	}
}
