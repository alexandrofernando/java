public class P039 {
	public static void main(String args[]) {
		int solutionNums[] = new int[1001];
		for (int a = 1; a < 334; a++) {
			for (int b = a; b < 501; b++) {
				int temp = a * a + b * b;
				int tempC = (int) Math.pow(temp, 0.5);
				if (a + b + tempC <= 1000 && tempC * tempC == temp) {
					int c = tempC;
					solutionNums[a + b + c]++;
				}
			}
		}
		int answer = 0;
		for (int i = 1; i < solutionNums.length; i++) {
			if (solutionNums[i] > solutionNums[answer]) {
				answer = i;
			}
		}
		System.out.println(answer);
	}
}
