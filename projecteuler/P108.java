import java.math.BigInteger;

public class P108 {
	static final int LIMIT = 1000;
	static BigInteger answer;
	static BigInteger answerSquare;

	public static void main(String args[]) {
		int primes[] = new int[] { 2, 3, 5, 7, 11, 13, 17 };
		answer = BigInteger.ONE;
		answerSquare = BigInteger.ONE;
		for (int i = 0; i < primes.length; i++) {
			answer = answer.multiply(new BigInteger(primes[i] + ""));
		}
		answerSquare = answer.multiply(answer);
		search(primes, 0, BigInteger.ONE, BigInteger.ONE, 1);
		System.out.println(answer);
	}

	static void search(int primes[], int index, BigInteger n,
			BigInteger nSquare, int solutionNum) {
		BigInteger temp = new BigInteger(n.toString());
		BigInteger tempSquare = new BigInteger(nSquare.toString());
		for (int i = 2;; i += 2) {
			temp = temp.multiply(new BigInteger(primes[index] + ""));
			tempSquare = tempSquare.multiply(new BigInteger(primes[index]
					* primes[index] + ""));
			if (temp.compareTo(answer) >= 0) {
				break;
			}
			int nextSolutionNum = solutionNum * (i + 1);
			if (nextSolutionNum >= LIMIT * 2) {
				if (temp.compareTo(answer) < 0) {
					answer = new BigInteger(temp.toString());
				}
				break;
			}
			search(primes, index + 1, temp, tempSquare, nextSolutionNum);
		}
	}
}