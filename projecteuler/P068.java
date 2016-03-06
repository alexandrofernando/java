public class P068 {
	static String max = "";
	static int ring[] = new int[] { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public static void main(String args[]) {
		search(1);
		System.out.println(max);
	}

	static void search(int index) {
		if (index == 7) {
			int sum = ring[0] + ring[5] + ring[6];
			int value7 = sum - ring[1] - ring[6];
			int value8 = sum - ring[2] - value7;
			int value9 = sum - ring[3] - value8;
			if ((value7 == ring[7] && value8 == ring[8] && value9 == ring[9])
					|| (value7 == ring[7] && value8 == ring[9] && value9 == ring[8])
					|| (value7 == ring[8] && value8 == ring[7] && value9 == ring[9])
					|| (value7 == ring[8] && value8 == ring[9] && value9 == ring[7])
					|| (value7 == ring[9] && value8 == ring[7] && value9 == ring[8])
					|| (value7 == ring[9] && value8 == ring[8] && value9 == ring[7])) {
				int oldRing7 = ring[7];
				int oldRing8 = ring[8];
				int oldRing9 = ring[9];
				ring[7] = value7;
				ring[8] = value8;
				ring[9] = value9;
				int turn = 0;
				for (int i = 1; i <= 4; i++) {
					if (ring[i] < ring[turn]) {
						turn = i;
					}
				}
				String solution = "";
				for (int i = 0; i < 5; i++) {
					solution += ring[(i + turn) % 5];
					solution += ring[(i + turn) % 5 + 5];
					solution += ring[(i + turn + 1) % 5 + 5];
				}
				if (solution.compareTo(max) > 0) {
					max = solution;
				}
				ring[7] = oldRing7;
				ring[8] = oldRing8;
				ring[9] = oldRing9;
			}
		} else {
			for (int i = index; i < ring.length; i++) {
				if (i != index) {
					int temp = ring[i];
					ring[i] = ring[index];
					ring[index] = temp;
				}
				search(index + 1);
				if (i != index) {
					int temp = ring[i];
					ring[i] = ring[index];
					ring[index] = temp;
				}
			}
		}
	}
}
