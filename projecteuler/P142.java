import java.util.ArrayList;

public class P142 {
	public static void main(String args[]) {
		int minSum = Integer.MAX_VALUE;
		for (int z = 1; z * 3 + 3 < minSum; z++) {
			int target = z * 2;
			ArrayList<Integer> possibles = new ArrayList<Integer>();
			for (int i = 1; i * i < target; i++) {
				if (target % i == 0) {
					int temp = target / i;
					if ((temp - i) % 2 == 0) {
						int m = (temp - i) / 2;
						possibles.add(m * m + z);
					}
				}
			}
			if (possibles.size() < 2) {
				continue;
			}
			for (int i = 0; i < possibles.size(); i++) {
				int x = possibles.get(i);
				for (int j = i + 1; j < possibles.size(); j++) {
					int y = possibles.get(j);
					if (isSquare(x - y) && isSquare(x + y)) {
						minSum = Math.min(minSum, x + y + z);
					}
				}
			}
		}
		System.out.println(minSum);
	}

	static boolean isSquare(int number) {
		int root = (int) Math.round(Math.sqrt(number));
		return root * root == number;
	}
}
