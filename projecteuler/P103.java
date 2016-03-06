import java.util.HashSet;
import java.util.Iterator;

public class P103 {
	static final int N = 7;
	static int minSum = 255;
	static String setString = "20313839404245";
	@SuppressWarnings("unchecked")
	static HashSet<Integer> setSum[] = new HashSet[N + 1];

	public static void main(String args[]) {
		for (int i = 0; i <= N; i++) {
			setSum[i] = new HashSet<Integer>();
		}
		setSum[0].add(0);
		search(new int[N], 0, 0);
		System.out.println(setString);
	}

	static void search(int set[], int index, int sum) {
		if (index == N) {
			minSum = sum;
			setString = "";
			for (int i = 0; i < N; i++) {
				setString += set[i];
			}
			return;
		}
		for (int i = (index == 0) ? 1 : set[index - 1] + 1; i * (N - index)
				+ sum < minSum; i++) {
			set[index] = i;
			if (index >= 2) {
				int sumNum = index / 2;
				int sumBottom = 0;
				for (int j = 0; j < sumNum + 1; j++) {
					sumBottom += set[j];
				}
				int sumTop = 0;
				for (int j = index; j > index - sumNum; j--) {
					sumTop += set[j];
				}
				if (sumBottom <= sumTop) {
					break;
				}
			}
			if (isValid(i, index)) {
				@SuppressWarnings("unchecked")
				HashSet<Integer> insertSetSum[] = new HashSet[index + 2];
				for (int j = index + 1; j >= 1; j--) {
					insertSetSum[j] = new HashSet<Integer>();
					Iterator<Integer> iter = setSum[j - 1].iterator();
					while (iter.hasNext()) {
						int s = iter.next() + i;
						setSum[j].add(s);
						insertSetSum[j].add(s);
					}
				}
				search(set, index + 1, sum + i);
				for (int j = 1; j <= index + 1; j++) {
					Iterator<Integer> iter = insertSetSum[j].iterator();
					while (iter.hasNext()) {
						setSum[j].remove(iter.next());
					}
				}
			}
		}
	}

	static boolean isValid(int lastNumber, int index) {
		for (int i = 1; i <= index - 2; i++) {
			Iterator<Integer> iter = setSum[i].iterator();
			while (iter.hasNext()) {
				if (setSum[i + 1].contains(iter.next() + lastNumber)) {
					return false;
				}
			}
		}
		return true;
	}
}
