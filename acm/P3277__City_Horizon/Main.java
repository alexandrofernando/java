package P3277__City_Horizon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static ArrayList<Segment> segments = new ArrayList<Segment>();
	static long length = 0;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Building buildings[] = new Building[N];
		for (int i = 0; i < N; i++) {
			buildings[i] = new Building(in.nextLong(), in.nextLong(),
					in.nextLong());
		}
		Arrays.sort(buildings);
		long currentHeight = buildings[0].height;
		long area = 0;
		for (int i = 0; i < N; i++) {
			if (buildings[i].height < currentHeight) {
				area += length * (currentHeight - buildings[i].height);
				currentHeight = buildings[i].height;
			}
			add(buildings[i].left, buildings[i].right);
		}
		area += length * currentHeight;
		System.out.println(area);
	}

	static void add(long x1, long x2) {
		int pos;
		while (true) {
			pos = -1 - Collections.binarySearch(segments, new Segment(x1, x2));
			if (pos > 0 && segments.get(pos - 1).right > x1) {
				x1 = segments.get(pos - 1).right;
				if (x1 >= x2) {
					return;
				}
			} else {
				break;
			}
		}
		if (pos < segments.size() && x1 == segments.get(pos).left
				&& x2 <= segments.get(pos).right) {
			return;
		}
		if (pos == segments.size() || x2 < segments.get(pos).left) {
			segments.add(pos, new Segment(x1, x2));
			length += x2 - x1;
		} else {
			int offset = 0;
			while (pos + offset < segments.size()
					&& segments.get(pos + offset).right <= x2) {
				length -= segments.get(pos + offset).right
						- segments.get(pos + offset).left;
				offset++;
			}
			if (pos + offset == segments.size()) {
				for (int i = 0; i < offset; i++) {
					segments.remove(segments.size() - 1);
				}
				segments.add(new Segment(x1, x2));
				length += x2 - x1;
			} else if (segments.get(pos + offset).left <= x2) {
				length += segments.get(pos + offset).left - x1;
				segments.get(pos + offset).left = x1;
				if (offset > 0) {
					for (int i = pos + offset; i < segments.size(); i++) {
						segments.set(i - offset, segments.get(i));
					}
					for (int i = 0; i < offset; i++) {
						segments.remove(segments.size() - 1);
					}
				}
			} else {
				length += x2 - x1;
				segments.get(pos).left = x1;
				segments.get(pos).right = x2;
				if (offset > 1) {
					for (int i = pos + offset; i < segments.size(); i++) {
						segments.set(i - offset + 1, segments.get(i));
					}
					for (int i = 0; i < offset - 1; i++) {
						segments.remove(segments.size() - 1);
					}
				}
			}
		}
		if (pos + 1 < segments.size()
				&& segments.get(pos).right == segments.get(pos + 1).left) {
			segments.get(pos).right = segments.get(pos + 1).right;
			segments.remove(pos + 1);
		}
		if (pos >= 1 && segments.get(pos).left == segments.get(pos - 1).right) {
			segments.get(pos - 1).right = segments.get(pos).right;
			segments.remove(pos);
		}
	}
}

class Segment implements Comparable<Segment> {
	long left;
	long right;

	Segment(long theLeft, long theRight) {
		this.left = theLeft;
		this.right = theRight;
	}

	public int compareTo(Segment another) {
		if (this.left <= another.left) {
			return -1;
		} else {
			return 1;
		}
	}
}

class Building implements Comparable<Building> {
	long left;
	long right;
	long height;

	Building(long theLeft, long theRight, long theHeight) {
		this.left = theLeft;
		this.right = theRight;
		this.height = theHeight;
	}

	public int compareTo(Building another) {
		if (this.height < another.height) {
			return 1;
		} else if (this.height > another.height) {
			return -1;
		} else {
			return 0;
		}
	}
}