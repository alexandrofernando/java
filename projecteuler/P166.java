public class P166 {
	public static void main(String args[]) {
		int count = 0;
		int grid[][] = new int[4][4];
		for (grid[0][0] = 0; grid[0][0] <= 9; grid[0][0]++) {
			for (grid[0][1] = 0; grid[0][1] <= 9; grid[0][1]++) {
				for (grid[0][2] = 0; grid[0][2] <= 9; grid[0][2]++) {
					for (grid[0][3] = 0; grid[0][3] <= 9; grid[0][3]++) {
						int sum = grid[0][0] + grid[0][1] + grid[0][2]
								+ grid[0][3];
						for (grid[1][0] = 0; grid[1][0] <= 9; grid[1][0]++) {
							for (grid[2][0] = 0; grid[2][0] <= 9; grid[2][0]++) {
								grid[3][0] = sum - grid[0][0] - grid[1][0]
										- grid[2][0];
								if (grid[3][0] < 0 || grid[3][0] > 9) {
									continue;
								}
								for (grid[1][1] = 0; grid[1][1] <= 9; grid[1][1]++) {
									for (grid[1][2] = 0; grid[1][2] <= 9; grid[1][2]++) {
										grid[1][3] = sum - grid[1][0]
												- grid[1][1] - grid[1][2];
										if (grid[1][3] < 0 || grid[1][3] > 9) {
											continue;
										}
										grid[2][1] = sum - grid[3][0]
												- grid[1][2] - grid[0][3];
										if (grid[2][1] < 0 || grid[2][1] > 9) {
											continue;
										}
										grid[3][1] = sum - grid[0][1]
												- grid[1][1] - grid[2][1];
										if (grid[3][1] < 0 || grid[3][1] > 9) {
											continue;
										}
										for (grid[2][2] = 0; grid[2][2] <= 9; grid[2][2]++) {
											grid[2][3] = sum - grid[2][0]
													- grid[2][1] - grid[2][2];
											if (grid[2][3] < 0
													|| grid[2][3] > 9) {
												continue;
											}
											grid[3][2] = sum - grid[0][2]
													- grid[1][2] - grid[2][2];
											if (grid[3][2] < 0
													|| grid[3][2] > 9) {
												continue;
											}
											grid[3][3] = sum - grid[0][0]
													- grid[1][1] - grid[2][2];
											if (grid[3][3] < 0
													|| grid[3][3] > 9) {
												continue;
											}
											if (grid[3][0] + grid[3][1]
													+ grid[3][2] + grid[3][3] != sum
													|| grid[0][3] + grid[1][3]
															+ grid[2][3]
															+ grid[3][3] != sum) {
												continue;
											}
											count++;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(count);
	}
}
