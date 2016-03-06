import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class P244 {
	static final int SIZE = 4;

	public static void main(String args[]) {
		Configuration s = new Configuration(0, 0, new boolean[][] {
				{ false, true, false, false }, { true, true, false, false },
				{ true, true, false, false }, { true, true, false, false } });
		Configuration t = new Configuration(0, 0, new boolean[][] {
				{ false, false, true, false }, { false, true, false, true },
				{ true, false, true, false }, { false, true, false, true } });
		ArrayList<String> paths = searchShortestPaths(s, t);
		int sum = 0;
		for (String path : paths) {
			sum += calcChecksum(path);
		}
		System.out.println(sum);
	}

	static ArrayList<String> searchShortestPaths(Configuration source,
			Configuration target) {
		int minLength = Integer.MAX_VALUE;
		ArrayList<String> shortestPaths = new ArrayList<String>();
		HashSet<Integer> visited = new HashSet<Integer>();
		visited.add(source.encode());
		LinkedList<Element> queue = new LinkedList<Element>();
		ArrayList<String> emptyPath = new ArrayList<String>();
		emptyPath.add("");
		queue.offer(new Element(0, emptyPath, source));
		int targetCode = target.encode();

		while (true) {
			Element head = queue.poll();
			if (head.step >= minLength) {
				break;
			}
			int offsetX[] = new int[] { -1, 0, 1, 0 };
			int offsetY[] = new int[] { 0, 1, 0, -1 };
			char moves[] = new char[] { 'D', 'L', 'U', 'R' };
			for (int i = 0; i < 4; i++) {
				int nextHoleX = head.config.holeX + offsetX[i];
				int nextHoleY = head.config.holeY + offsetY[i];
				if (nextHoleX >= 0 && nextHoleX < SIZE && nextHoleY >= 0
						&& nextHoleY < SIZE) {
					boolean nextRedTiles[][] = new boolean[SIZE][SIZE];
					for (int p = 0; p < SIZE; p++) {
						for (int q = 0; q < SIZE; q++) {
							nextRedTiles[p][q] = head.config.redTiles[p][q];
						}
					}
					nextRedTiles[head.config.holeX][head.config.holeY] = head.config.redTiles[nextHoleX][nextHoleY];
					nextRedTiles[nextHoleX][nextHoleY] = false;

					Configuration nextConfig = new Configuration(nextHoleX,
							nextHoleY, nextRedTiles);
					int nextCode = nextConfig.encode();
					ArrayList<String> nextPaths = new ArrayList<String>();
					for (String path : head.paths) {
						nextPaths.add(path + moves[i]);
					}
					if (nextCode == targetCode) {
						minLength = head.step + 1;
						shortestPaths.addAll(nextPaths);
					} else if (visited.add(nextCode)) {
						queue.add(new Element(head.step + 1, nextPaths,
								nextConfig));
					}
				}
			}
		}
		return shortestPaths;
	}

	static int calcChecksum(String sequence) {
		int checksum = 0;
		for (int i = 0; i < sequence.length(); i++) {
			char m = sequence.charAt(i);
			checksum = (int) ((checksum * 243L + m) % 100000007);
		}
		return checksum;
	}
}

class Element {
	int step;
	ArrayList<String> paths;
	Configuration config;

	Element(int theStep, ArrayList<String> thePaths, Configuration theConfig) {
		this.step = theStep;
		this.paths = thePaths;
		this.config = theConfig;
	}
}

class Configuration {
	int holeX;
	int holeY;
	boolean redTiles[][];

	Configuration(int theHoleX, int theHoleY, boolean theRedTiles[][]) {
		this.holeX = theHoleX;
		this.holeY = theHoleY;
		this.redTiles = theRedTiles;
	}

	public int encode() {
		int code = 0;
		for (int i = 0; i < redTiles.length; i++) {
			for (int j = 0; j < redTiles[0].length; j++) {
				if (i == holeX && j == holeY) {
					code = code * 3 + 2;
				} else {
					code = code * 3 + (redTiles[i][j] ? 1 : 0);
				}
			}
		}
		return code;
	}
}