import java.util.ArrayList;

public class P074 {
	public static void main(String args[]) {
		int answer = 0;
		for (int i = 1; i < 1000000; i++) {
			ArrayList<Integer> chain = new ArrayList<Integer>();
			chain.add(i);
			int number = i;
			while (true) {
				number = next(number);
				int index = chain.indexOf(number);
				if (index >= 0) {
					if (chain.size() == 60) {
						answer++;
					}
					break;
				}
				chain.add(number);
			}
		}
		System.out.println(answer);
	}

	static int next(int number) {
		int factorials[] = new int[] { 1, 1, 2, 6, 24, 120, 720, 5040, 40320,
				362880 };
		int sum = 0;
		while (number != 0) {
			sum += factorials[number % 10];
			number /= 10;
		}
		return sum;
	}
}
