import java.util.Hashtable;

public class P014 {
	static Hashtable<Long, Integer> stepNums = new Hashtable<Long, Integer>();

	public static void main(String args[]) {
		int maxStartingNumber = 1;
		int maxStepNum = 1;
		stepNums.put(1L, 1);
		for (int i = 2; i < 1000000; i++) {
			int stepNum = getStepNum(i);
			if (stepNum > maxStepNum) {
				maxStepNum = stepNum;
				maxStartingNumber = i;
			}
		}
		System.out.println(maxStartingNumber);
	}

	static int getStepNum(long number) {
		long n = number;
		int count = 0;
		int result;
		while (true) {
			Integer stepNum = stepNums.get(n);
			if (stepNum != null) {
				result = count + stepNum.intValue();
				break;
			}
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n = n * 3 + 1;
			}
			count++;
		}
		n = number;
		int step = result;
		while (true) {
			Integer stepNum = stepNums.get(n);
			if (stepNum != null) {
				break;
			}
			stepNums.put(n, step);
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n = n * 3 + 1;
			}
			step--;
		}
		return result;
	}
}
