import java.util.ArrayList;

public class P172 {
	static final int DIGIT_NUM = 18;
	static final int TIMES_LIMIT = 3;
	static long answer = 0;

	public static void main(String args[]) {
		ArrayList<Integer> times = new ArrayList<Integer>();
		search(times, 0);
		answer = answer / 10 * 9;
		System.out.println(answer);
	}

	static void search(ArrayList<Integer> times, int total) {
		if (total == DIGIT_NUM) {
			int counts[] = new int[4];
			for (int i = 0; i < times.size(); i++) {
				counts[times.get(i)]++;
			}
			long composite = 1;
			int rest = 10;
			for (int i = 1; i <= 3; i++) {
				composite *= C(rest, counts[i]);
				rest -= counts[i];
			}
			rest = DIGIT_NUM;
			for (int i = 0; i < times.size(); i++) {
				int time = times.get(i);
				composite *= C(rest, time);
				rest -= time;
			}
			answer += composite;
			return;
		}
		for (int time = (times.size() == 0) ? TIMES_LIMIT : times.get(times
				.size() - 1); time >= 1; time--) {
			if (total + time > DIGIT_NUM) {
				continue;
			}
			if (total + time * (10 - times.size()) < DIGIT_NUM) {
				break;
			}
			times.add(time);
			search(times, total + time);
			times.remove(times.size() - 1);
		}
	}

	static long C(int n, int m) {
		if (m + m > n) {
			return C(n, n - m);
		}
		long result = 1;
		for (int i = n; i > n - m; i--) {
			result *= i;
		}
		for (int i = 1; i <= m; i++) {
			result /= i;
		}
		return result;
	}
}
