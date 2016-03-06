package NumberOfDiscIntersections;

// Beta 2010
// http://codility.com/demo/results/demo6VVUY6-4PM/

import java.util.Arrays;

public class Solution {
	public int solution(int[] A) {
		final int LIMIT = 10000000;
		Point[] points = new Point[A.length * 2];
		for (int i = 0; i < A.length; i++) {
			points[i * 2] = new Point((long) i - A[i], true);
			points[i * 2 + 1] = new Point((long) i + A[i], false);
		}
		Arrays.sort(points);
		int intersectNum = 0;
		int rangeNum = 0;
		for (Point point : points) {
			if (point.leftOrRight) {
				intersectNum += rangeNum;
				if (intersectNum > LIMIT) {
					return -1;
				}
				rangeNum++;
			} else {
				rangeNum--;
			}
		}
		return intersectNum;
	}
}

class Point implements Comparable<Point> {
	long x;
	boolean leftOrRight;

	Point(long x, boolean leftOrRight) {
		this.x = x;
		this.leftOrRight = leftOrRight;
	}

	public int compareTo(Point other) {
		if (x != other.x) {
			return (int) Math.signum(x - other.x);
		}
		return leftOrRight ? -1 : 1;
	}
}