import java.util.ArrayList;

public class P220 {
	static long finalX;
	static long finalY;
	static final long TARGET_STEP = 1000000000000L;
	static Group groups[][];

	public static void main(String args[]) {
		final int N = 50;
		groups = new Group[2][N + 1];
		groups[0][0] = new Group(0, 0, 0, 0);
		groups[1][0] = new Group(0, 0, 0, 0);
		for (int i = 1; i <= N; i++) {
			groups[0][i] = new Group(0, 0, 0, 0);
			groups[0][i] = Group.combine(groups[0][i], groups[0][i - 1]);
			groups[0][i] = Group.combine(groups[0][i], new Group(0, 0, 1, 0));
			groups[0][i] = Group.combine(groups[0][i], groups[1][i - 1]);
			groups[0][i] = Group.combine(groups[0][i], new Group(0, 1, 1, 1));

			groups[1][i] = new Group(0, 0, 0, 0);
			groups[1][i] = Group.combine(groups[1][i], new Group(-1, 0, 3, 1));
			groups[1][i] = Group.combine(groups[1][i], groups[0][i - 1]);
			groups[1][i] = Group.combine(groups[1][i], new Group(0, 0, 3, 0));
			groups[1][i] = Group.combine(groups[1][i], groups[1][i - 1]);
		}
		ArrayList<String> instructions = new ArrayList<String>();
		instructions.add("F");
		instructions.add("a" + N);
		search(new Group(0, 0, 0, 0), instructions);
		System.out.println(finalX + "," + finalY);
	}

	static void search(Group group, ArrayList<String> instructions) {
		for (int i = 0; i < instructions.size(); i++) {
			String command = instructions.get(i);
			if (command.equals("F")) {
				group = Group.combine(group, new Group(0, 1, 0, 1));
			} else if (command.equals("L")) {
				group = Group.combine(group, new Group(0, 0, 3, 0));
			} else if (command.equals("R")) {
				group = Group.combine(group, new Group(0, 0, 1, 0));
			} else if (command.startsWith("a")) {
				int n = Integer.parseInt(command.substring(1));
				if (group.stepNumber + groups[0][n].stepNumber <= TARGET_STEP) {
					group = Group.combine(group, groups[0][n]);
				} else {
					ArrayList<String> nextInstructions = new ArrayList<String>();
					if (n > 0) {
						nextInstructions.add("a" + (n - 1));
					}
					nextInstructions.add("R");
					if (n > 0) {
						nextInstructions.add("b" + (n - 1));
					}
					nextInstructions.add("F");
					nextInstructions.add("R");
					search(group, nextInstructions);
					return;
				}
			} else if (command.startsWith("b")) {
				int n = Integer.parseInt(command.substring(1));
				if (group.stepNumber + groups[1][n].stepNumber <= TARGET_STEP) {
					group = Group.combine(group, groups[1][n]);
				} else {
					ArrayList<String> nextInstructions = new ArrayList<String>();
					nextInstructions.add("L");
					nextInstructions.add("F");
					if (n > 0) {
						nextInstructions.add("a" + (n - 1));
					}
					nextInstructions.add("L");
					if (n > 0) {
						nextInstructions.add("b" + (n - 1));
					}
					search(group, nextInstructions);
					return;
				}
			}
			if (group.stepNumber == TARGET_STEP) {
				finalX = group.offsetRight;
				finalY = group.offsetFront;
				return;
			}
		}
	}
}

class Group {
	long offsetRight;
	long offsetFront;
	int offsetDirection;
	long stepNumber;

	Group(long theOffsetRight, long theOffsetFront, int theOffsetDirection,
			long theStepNumber) {
		this.offsetRight = theOffsetRight;
		this.offsetFront = theOffsetFront;
		this.offsetDirection = theOffsetDirection;
		this.stepNumber = theStepNumber;
	}

	static Group combine(Group g1, Group g2) {
		long combinedOffsetRight = g1.offsetRight;
		long combinedOffsetFront = g1.offsetFront;
		if (g1.offsetDirection == 0) {
			combinedOffsetRight += g2.offsetRight;
			combinedOffsetFront += g2.offsetFront;
		} else if (g1.offsetDirection == 1) {
			combinedOffsetRight += g2.offsetFront;
			combinedOffsetFront -= g2.offsetRight;
		} else if (g1.offsetDirection == 2) {
			combinedOffsetRight -= g2.offsetRight;
			combinedOffsetFront -= g2.offsetFront;
		} else if (g1.offsetDirection == 3) {
			combinedOffsetRight -= g2.offsetFront;
			combinedOffsetFront += g2.offsetRight;
		}
		int combinedOffsetDirection = (g1.offsetDirection + g2.offsetDirection) % 4;
		long combinedStepNumber = g1.stepNumber + g2.stepNumber;
		return new Group(combinedOffsetRight, combinedOffsetFront,
				combinedOffsetDirection, combinedStepNumber);
	}
}