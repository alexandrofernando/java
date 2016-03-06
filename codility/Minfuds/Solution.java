package Minfuds;

// Epsilon 2011
// https://codility.com/demo/results/demoBCAG22-4BD/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	final int INFINITE = 10000;

	public double solution(int[] A, int[] B) {
		Line[] lines = new Line[A.length];
		for (int i = 0; i < lines.length; i++) {
			lines[i] = new Line(A[i], B[i]);
		}
		Arrays.sort(lines);
		ArrayList<Point> maxPoints = computeExtremePoints(lines, true);
		reverse(lines);
		ArrayList<Point> minPoints = computeExtremePoints(lines, false);
		return computeMinDiff(maxPoints, minPoints);
	}

	double computeMinDiff(ArrayList<Point> maxPoints, ArrayList<Point> minPoints) {
		double minDiff = Double.MAX_VALUE;
		int maxIndex = 0;
		int minIndex = 0;
		while (maxIndex < maxPoints.size() || minIndex < minPoints.size()) {
			double diff;
			if (minIndex == minPoints.size()
					|| (maxIndex < maxPoints.size() && maxPoints.get(maxIndex).x <= minPoints
							.get(minIndex).x)) {
				Line minLine;
				if (minIndex == 0) {
					minLine = new Line(minPoints.get(0), minPoints.get(1));
				} else if (minIndex == minPoints.size()) {
					minLine = new Line(minPoints.get(minPoints.size() - 2),
							minPoints.get(minPoints.size() - 1));
				} else {
					minLine = new Line(minPoints.get(minIndex - 1),
							minPoints.get(minIndex));
				}
				diff = maxPoints.get(maxIndex).y
						- minLine.getPoint(maxPoints.get(maxIndex).x).y;
				maxIndex++;
			} else {
				Line maxLine;
				if (maxIndex == 0) {
					maxLine = new Line(maxPoints.get(0), maxPoints.get(1));
				} else if (maxIndex == maxPoints.size()) {
					maxLine = new Line(maxPoints.get(maxPoints.size() - 2),
							maxPoints.get(maxPoints.size() - 1));
				} else {
					maxLine = new Line(maxPoints.get(maxIndex - 1),
							maxPoints.get(maxIndex));
				}
				diff = maxLine.getPoint(minPoints.get(minIndex).x).y
						- minPoints.get(minIndex).y;
				minIndex++;
			}
			minDiff = Math.min(minDiff, diff);
		}
		return minDiff;
	}

	ArrayList<Point> computeExtremePoints(Line[] lines, boolean maxOrMin) {
		ArrayList<Point> extremePoints = new ArrayList<Point>();
		for (Line line : lines) {
			while (true) {
				if (extremePoints.isEmpty()) {
					extremePoints.add(line.getPoint(-INFINITE));
					break;
				}
				Point lastTwoPoint = extremePoints
						.get(extremePoints.size() - 2);
				Point lastPoint = extremePoints
						.remove(extremePoints.size() - 1);
				double yDiff = line.getPoint(lastTwoPoint.x).y - lastTwoPoint.y;
				if ((maxOrMin && yDiff < 0) || (!maxOrMin && yDiff > 0)) {
					extremePoints.add(intersect(line, new Line(lastTwoPoint,
							lastPoint)));
					break;
				}
				if (extremePoints.size() == 1) {
					extremePoints.remove(0);
				}
			}
			extremePoints.add(line.getPoint(INFINITE));
		}
		return extremePoints;
	}

	void reverse(Line[] lines) {
		for (int i = 0, j = lines.length - 1; i < j; i++, j--) {
			Line temp = lines[i];
			lines[i] = lines[j];
			lines[j] = temp;
		}
	}

	Point intersect(Line line1, Line line2) {
		double x = (line1.b - line2.b) / (line2.a - line1.a);
		double y = line1.a * x + line1.b;
		return new Point(x, y);
	}
}

class Point {
	double x;
	double y;

	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

class Line implements Comparable<Line> {
	double a;
	double b;

	Line(double a, double b) {
		this.a = a;
		this.b = b;
	}

	Line(Point p1, Point p2) {
		a = (p1.y - p2.y) / (p1.x - p2.x);
		b = p1.y - a * p1.x;
	}

	public int compareTo(Line other) {
		if (a != other.a) {
			return (int) Math.signum(a - other.a);
		}
		return (int) Math.signum(b - other.b);
	}

	Point getPoint(double x) {
		return new Point(x, a * x + b);
	}
}