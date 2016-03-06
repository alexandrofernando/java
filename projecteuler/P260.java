// VM arguments: -Xms32m -Xmx1400m

public class P260 {
	static final int LIMIT = 1000;
	static int sum = 0;
	static boolean winConfigurations[][][] = new boolean[LIMIT + 1][LIMIT + 1][LIMIT + 1];

	public static void main(String args[]) {
		int stones[] = new int[3];
		for (stones[0] = 0; stones[0] <= LIMIT; stones[0]++) {
			for (stones[1] = 0; stones[1] <= LIMIT; stones[1]++) {
				for (stones[2] = 0; stones[2] <= LIMIT; stones[2]++) {
					if (!winConfigurations[stones[0]][stones[1]][stones[2]]) {
						if (stones[0] <= stones[1] && stones[1] <= stones[2]) {
							sum += stones[0] + stones[1] + stones[2];
						}
						int piles[][] = new int[][] { { 0 }, { 1 }, { 2 },
								{ 0, 1 }, { 0, 2 }, { 1, 2 }, { 0, 1, 2 } };
						for (int i = 0; i < piles.length; i++) {
							int nextStones[] = new int[3];
							for (int j = 0; j < nextStones.length; j++) {
								nextStones[j] = stones[j];
							}
							while (true) {
								boolean exceed = false;
								for (int j = 0; j < piles[i].length; j++) {
									nextStones[piles[i][j]]++;
									if (nextStones[piles[i][j]] > LIMIT) {
										exceed = true;
										break;
									}
								}
								if (exceed) {
									break;
								}
								winConfigurations[nextStones[0]][nextStones[1]][nextStones[2]] = true;
							}
						}
					}
				}
			}
		}
		System.out.println(sum);
	}
}