import java.util.ArrayList;

public class P215 {
	static final int LENGTH = 32;
	static final int HEIGHT = 10;
	static ArrayList<ArrayList<Integer>> lineFormats = new ArrayList<ArrayList<Integer>>();

	public static void main(String args[]) {
		buildLineFormats(new ArrayList<Integer>(), 0);
		int lineFormatNum = lineFormats.size();
		boolean adjacent[][] = new boolean[lineFormatNum][lineFormatNum];
		for (int i = 0; i < lineFormatNum; i++) {
			for (int j = 0; j < lineFormatNum; j++) {
				adjacent[i][j] = canAdjacent(lineFormats.get(i),
						lineFormats.get(j));
			}
		}
		long W[][] = new long[HEIGHT + 1][lineFormats.size()];
		for (int i = 1; i < W.length; i++) {
			for (int j = 0; j < W[0].length; j++) {
				if (i == 1) {
					W[i][j] = 1;
				} else {
					for (int k = 0; k < W[0].length; k++) {
						if (adjacent[j][k]) {
							W[i][j] += W[i - 1][k];
						}
					}
				}
			}
		}
		long answer = 0;
		for (int i = 0; i < W[0].length; i++) {
			answer += W[HEIGHT][i];
		}
		System.out.println(answer);
	}

	static boolean canAdjacent(ArrayList<Integer> lf1, ArrayList<Integer> lf2) {
		int length1 = 0;
		int length2 = 0;
		int index1 = 0;
		int index2 = 0;
		while (length1 != LENGTH || length2 != LENGTH) {
			if (length1 == length2 && length1 != 0) {
				return false;
			}
			if (length1 < length2) {
				length1 += lf1.get(index1);
				index1++;
			} else {
				length2 += lf2.get(index2);
				index2++;
			}
		}
		return true;
	}

	static void buildLineFormats(ArrayList<Integer> lineFormat, int length) {
		if (length == LENGTH) {
			ArrayList<Integer> lf = new ArrayList<Integer>();
			for (int i = 0; i < lineFormat.size(); i++) {
				lf.add(lineFormat.get(i));
			}
			lineFormats.add(lf);
		} else {
			for (int brick = 2; brick <= 3; brick++) {
				if (length + brick <= LENGTH) {
					lineFormat.add(brick);
					buildLineFormats(lineFormat, length + brick);
					lineFormat.remove(lineFormat.size() - 1);
				}
			}
		}
	}
}
