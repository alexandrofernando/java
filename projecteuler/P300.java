import java.util.ArrayList;
import java.util.HashSet;

public class P300 {
	static final int LENGTH = 15;

	public static void main(String args[]) {
		HashSet<Folding> foldings = new HashSet<Folding>();
		int movesNum = (int) Math.pow(3, LENGTH - 2);
		for (int movesCode = 0; movesCode < movesNum; movesCode++) {
			Point points[] = decodeMoves(movesCode * 3 + 1);
			if (points != null) {
				Folding folding = new Folding(points);
				foldings.add(folding);
			}
		}
		int optimalTotal = 0;
		int proteinsNum = (int) Math.pow(2, LENGTH);
		for (int proteinsCode = 0; proteinsCode < proteinsNum; proteinsCode++) {
			String proteins = decodeProteins(proteinsCode);
			int possibleMaxContact = calcPossibleMaxContact(proteins);
			int maxContact = 0;
			for (Folding folding : foldings) {
				if (maxContact == possibleMaxContact) {
					break;
				}
				int contact = calcContact(folding, proteins);
				maxContact = Math.max(maxContact, contact);
			}
			optimalTotal += maxContact;
		}
		System.out.println((double) optimalTotal / proteinsNum);
	}

	static int calcPossibleMaxContact(String proteins) {
		int oddNum = 0;
		int evenNum = 0;
		for (int i = 0; i < LENGTH; i++) {
			if (proteins.charAt(i) == 'H') {
				if (i % 2 == 0) {
					evenNum++;
				} else {
					oddNum++;
				}
			}
		}
		return oddNum * evenNum;
	}

	static int calcContact(Folding folding, String proteins) {
		int contact = 0;
		for (int i = 0; i < LENGTH; i++) {
			if (proteins.charAt(i) == 'H') {
				for (int j : folding.adjacents[i]) {
					if (proteins.charAt(j) == 'H') {
						contact++;
					}
				}
			}
		}
		return contact;
	}

	static String decodeProteins(int proteinsCode) {
		String proteins = "";
		for (int i = 0; i < LENGTH; i++) {
			if (proteinsCode % 2 == 0) {
				proteins += "H";
			} else {
				proteins += "P";
			}
			proteinsCode /= 2;
		}
		return proteins;
	}

	static Point[] decodeMoves(int movesCode) {
		Point points[] = new Point[LENGTH];
		points[0] = new Point(0, 0);
		HashSet<Point> history = new HashSet<Point>();
		history.add(points[0]);
		int direction = 0;
		int offsetX[] = { -1, 0, 1, 0 };
		int offsetY[] = { 0, 1, 0, -1 };
		for (int i = 1; i < points.length; i++) {
			int move = movesCode % 3 - 1;
			movesCode /= 3;
			direction = (direction + move + 4) % 4;
			points[i] = new Point(points[i - 1].x + offsetX[direction],
					points[i - 1].y + offsetY[direction]);
			if (history.contains(points[i])) {
				return null;
			}
			history.add(points[i]);
		}
		return points;
	}
}

class Folding {
	int row;
	int column;
	ArrayList<Integer> adjacents[];

	@SuppressWarnings("unchecked")
	Folding(Point points[]) {
		adjacents = new ArrayList[points.length];
		for (int i = 0; i < adjacents.length; i++) {
			adjacents[i] = new ArrayList<Integer>();
			for (int j = i + 1; j < points.length; j++) {
				if (Point.isAdjacent(points[i], points[j])) {
					adjacents[i].add(j);
				}
			}
		}
	}

	@Override
	public int hashCode() {
		return row * column * adjacents.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Folding other = (Folding) obj;
		if (row != other.row || column != other.column) {
			return false;
		}
		for (int i = 0; i < adjacents.length; i++) {
			if (adjacents[i].size() != other.adjacents[i].size()) {
				return false;
			}
			for (int j = 0; j < adjacents[i].size(); j++) {
				if (adjacents[i].get(j) != other.adjacents[i].get(j)) {
					return false;
				}
			}
		}
		return true;
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	static boolean isAdjacent(Point p1, Point p2) {
		return (p1.x == p2.x && Math.abs(p1.y - p2.y) == 1)
				|| (Math.abs(p1.x - p2.x) == 1 && p1.y == p2.y);
	}

	@Override
	public int hashCode() {
		return x * y;
	}

	@Override
	public boolean equals(Object obj) {
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}
}