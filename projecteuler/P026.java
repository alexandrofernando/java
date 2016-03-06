public class P026 {
	public static void main(String args[]) {
		int longest = 0;
		int answer = 0;
		for (int i = 1; i < 1000; i++) {
			int cycle = getRecurCycle(i);
			if (cycle > longest) {
				longest = cycle;
				answer = i;
			}
		}
		System.out.println(answer);
	}

	static int getRecurCycle(int number) {
		int visited[] = new int[number];
		int current = 1;
		for (int step = 1;; step++) {
			current = current * 10 % number;
			if (current == 0) {
				return 0;
			}
			if (visited[current] > 0) {
				return step - visited[current];
			}
			visited[current] = step;
		}
	}
}
