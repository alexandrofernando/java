public class P061 {
	static int types[] = new int[] { 8, 7, 6, 5, 4, 3 };
	static boolean found = false;

	public static void main(String args[]) {
		for (int i = 19; i <= 58; i++) {
			int p8 = i * (3 * i - 2);
			if (p8 % 100 / 10 != 0) {
				search(1, new int[] { p8 / 1000, p8 % 1000 / 100,
						p8 % 100 / 10, p8 % 10, 0, 0, 0, 0, 0, 0, 0, 0 });
				if (found) {
					return;
				}
			}
		}
	}

	static void search(int index, int d[]) {
		if (index == types.length - 1) {
			int n6 = d[10] * 1000 + d[11] * 100 + d[0] * 10 + d[1];
			if (types[index] == 7) {
				if (isType7(n6)) {
					found = true;
				}
			} else if (types[index] == 6) {
				if (isType6(n6)) {
					found = true;
				}
			} else if (types[index] == 5) {
				if (isType5(n6)) {
					found = true;
				}
			} else if (types[index] == 4) {
				if (isType4(n6)) {
					found = true;
				}
			} else if (types[index] == 3) {
				if (isType3(n6)) {
					found = true;
				}
			}
			if (found) {
				int n1 = d[0] * 1000 + d[1] * 100 + d[2] * 10 + d[3];
				int n2 = d[2] * 1000 + d[3] * 100 + d[4] * 10 + d[5];
				int n3 = d[4] * 1000 + d[5] * 100 + d[6] * 10 + d[7];
				int n4 = d[6] * 1000 + d[7] * 100 + d[8] * 10 + d[9];
				int n5 = d[8] * 1000 + d[9] * 100 + d[10] * 10 + d[11];
				System.out.println(n1 + n2 + n3 + n4 + n5 + n6);
			}
			return;
		}
		int beginN = d[index * 2] * 1000 + d[index * 2 + 1] * 100 + 10;
		int endN = d[index * 2] * 1000 + d[index * 2 + 1] * 100 + 100;
		for (int i = index; i < types.length; i++) {
			if (i != index) {
				int temp = types[index];
				types[index] = types[i];
				types[i] = temp;
			}
			int tempN;
			if (types[index] == 7) {
				int beginX = (int) (0.3 + Math.sqrt(0.4 * beginN + 0.09));
				while (beginX * (5 * beginX - 3) / 2 < beginN) {
					beginX++;
				}
				for (int j = beginX; (tempN = j * (5 * j - 3) / 2) < endN; j++) {
					if (tempN % 100 / 10 != 0) {
						d[index * 2 + 2] = tempN % 100 / 10;
						d[index * 2 + 3] = tempN % 10;
						search(index + 1, d);
						if (found) {
							return;
						}
					}
				}
			} else if (types[index] == 6) {
				int beginX = (int) (0.25 + Math.sqrt(0.5 * beginN + 0.0625));
				while (beginX * (2 * beginX - 1) < beginN) {
					beginX++;
				}
				for (int j = beginX; (tempN = j * (2 * j - 1)) < endN; j++) {
					if (tempN % 100 / 10 != 0) {
						d[index * 2 + 2] = tempN % 100 / 10;
						d[index * 2 + 3] = tempN % 10;
						search(index + 1, d);
						if (found) {
							return;
						}
					}
				}
			} else if (types[index] == 5) {
				int beginX = (int) (1.0 / 6 + Math.sqrt(2.0 / 3 * beginN + 1.0
						/ 36));
				while (beginX * (3 * beginX - 1) / 2 < beginN) {
					beginX++;
				}
				for (int j = beginX; (tempN = j * (3 * j - 1) / 2) < endN; j++) {
					if (tempN % 100 / 10 != 0) {
						d[index * 2 + 2] = tempN % 100 / 10;
						d[index * 2 + 3] = tempN % 10;
						search(index + 1, d);
						if (found) {
							return;
						}
					}
				}
			} else if (types[index] == 4) {
				int beginX = (int) Math.sqrt(beginN);
				while (beginX * beginX < beginN) {
					beginX++;
				}
				for (int j = beginX; (tempN = j * j) < endN; j++) {
					if (tempN % 100 / 10 != 0) {
						d[index * 2 + 2] = tempN % 100 / 10;
						d[index * 2 + 3] = tempN % 10;
						search(index + 1, d);
						if (found) {
							return;
						}
					}
				}
			} else if (types[index] == 3) {
				int beginX = (int) Math.sqrt(2 * beginN);
				while (beginX * (beginX + 1) / 2 < beginN) {
					beginX++;
				}
				for (int j = beginX; (tempN = j * (j + 1) / 2) < endN; j++) {
					if (tempN % 100 / 10 != 0) {
						d[index * 2 + 2] = tempN % 100 / 10;
						d[index * 2 + 3] = tempN % 10;
						search(index + 1, d);
						if (found) {
							return;
						}
					}
				}
			}
			if (i != index) {
				int temp = types[index];
				types[index] = types[i];
				types[i] = temp;
			}
		}
	}

	static boolean isType8(int number) {
		int x = (int) (1.0 / 3 + Math.sqrt(1.0 / 3 * number + 1.0 / 9) + 1E-12);
		return x * (3 * x - 2) == number;
	}

	static boolean isType7(int number) {
		int x = (int) (0.3 + Math.sqrt(0.4 * number + 0.09) + 1E-12);
		return x * (5 * x - 3) / 2 == number;
	}

	static boolean isType6(int number) {
		int x = (int) (0.25 + Math.sqrt(0.5 * number + 0.0625) + 1E-12);
		return x * (2 * x - 1) == number;
	}

	static boolean isType5(int number) {
		int x = (int) (1.0 / 6 + Math.sqrt(2.0 / 3 * number + 1.0 / 36) + 1E-12);
		return x * (3 * x - 1) / 2 == number;
	}

	static boolean isType4(int number) {
		int x = (int) (Math.sqrt(number) + 1E-12);
		return x * x == number;
	}

	static boolean isType3(int number) {
		int x = (int) (Math.sqrt(2 * number) + 1E-12);
		return x * (x + 1) / 2 == number;
	}
}
