import java.util.Arrays;

public class P185 {
	static final int LENGTH = 16;
	static Guess guesses[] = new Guess[] { new Guess("5616185650518293", 2),
			new Guess("3847439647293047", 1), new Guess("5855462940810587", 3),
			new Guess("9742855507068353", 3), new Guess("4296849643607543", 3),
			new Guess("3174248439465858", 1), new Guess("4513559094146117", 2),
			new Guess("7890971548908067", 3), new Guess("8157356344118483", 1),
			new Guess("2615250744386899", 2), new Guess("8690095851526254", 3),
			new Guess("6375711915077050", 1), new Guess("6913859173121360", 1),
			new Guess("6442889055042768", 2), new Guess("2321386104303845", 0),
			new Guess("2326509471271448", 2), new Guess("5251583379644322", 2),
			new Guess("1748270476758276", 3), new Guess("4895722652190306", 1),
			new Guess("3041631117224635", 3), new Guess("1841236454324589", 3),
			new Guess("2659862637316867", 2) };
	static int possibilities[][] = new int[LENGTH][10];
	static String solution;
	static boolean found = false;

	public static void main(String args[]) {
		Arrays.sort(guesses);
		search(0, 0, 0);
		System.out.println(solution);
	}

	static void search(int index, int correct, int startingPos) {
		if (index == guesses.length) {
			String sol = "";
			for (int i = 0; i < LENGTH; i++) {
				int digit = -1;
				for (int j = 0; j < 10; j++) {
					if (possibilities[i][j] == 0) {
						digit = j;
						break;
					}
				}
				sol += digit;
			}
			found = true;
			solution = sol;
			return;
		}
		if (correct == guesses[index].correctNum) {
			for (int i = 0; i < LENGTH; i++) {
				int count = 0;
				for (int j = 0; j < 10; j++) {
					if (possibilities[i][j] == 0) {
						count++;
					}
				}
				if (count == 0) {
					return;
				}
			}
			for (int i = startingPos; i < LENGTH; i++) {
				possibilities[i][guesses[index].sequence.charAt(i) - '0']--;
			}
			search(index + 1, 0, 0);
			if (found == true) {
				return;
			}
			for (int i = startingPos; i < LENGTH; i++) {
				possibilities[i][guesses[index].sequence.charAt(i) - '0']++;
			}
			return;
		}
		for (int i = startingPos; i < LENGTH
				- (guesses[index].correctNum - correct - 1); i++) {
			int hitDigit = guesses[index].sequence.charAt(i) - '0';
			if (possibilities[i][hitDigit] < 0) {
				continue;
			}
			for (int j = 0; j < 10; j++) {
				if (j != hitDigit) {
					possibilities[i][j]--;
				}
			}
			for (int j = startingPos; j < i; j++) {
				possibilities[j][guesses[index].sequence.charAt(j) - '0']--;
			}
			search(index, correct + 1, i + 1);
			if (found == true) {
				return;
			}
			for (int j = startingPos; j < i; j++) {
				possibilities[j][guesses[index].sequence.charAt(j) - '0']++;
			}
			for (int j = 0; j < 10; j++) {
				if (j != hitDigit) {
					possibilities[i][j]++;
				}
			}
		}
	}
}

class Guess implements Comparable<Guess> {
	String sequence;
	int correctNum;

	Guess(String theSequence, int theCorrectNum) {
		this.sequence = theSequence;
		this.correctNum = theCorrectNum;
	}

	public int compareTo(Guess another) {
		return this.correctNum - another.correctNum;
	}
}