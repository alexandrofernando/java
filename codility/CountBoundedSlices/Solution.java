package CountBoundedSlices;

// Oxygenium 2014
// http://codility.com/cert/view/certRWUF6N-UTR3TTPD28S8XMMH

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static final int LIMIT = 1000000000;

	public int solution(int K, int[] A) {
		int result = 0;
		ExtremeQueue queue = new ExtremeQueue();
		int leftIndex = 0;
		for (int rightIndex = 0; rightIndex < A.length; rightIndex++) {
			queue.enqueue(A[rightIndex]);
			int max = queue.getMax();
			int min = queue.getMin();
			while (max - min > K) {
				leftIndex++;
				queue.dequeue();
				max = queue.getMax();
				min = queue.getMin();
			}
			result = addUpToLimit(result, rightIndex - leftIndex + 1);
		}

		return result;
	}

	int addUpToLimit(int a, int b) {
		return Math.min(a + b, LIMIT);
	}
}

class ExtremeQueue {
	Queue<Integer> queue = new LinkedList<Integer>();
	LinkedList<Integer> maxs = new LinkedList<Integer>();
	LinkedList<Integer> mins = new LinkedList<Integer>();

	void enqueue(int value) {
		queue.offer(value);

		while (!maxs.isEmpty() && maxs.getLast() < value) {
			maxs.removeLast();
		}
		maxs.add(value);

		while (!mins.isEmpty() && mins.getLast() > value) {
			mins.removeLast();
		}
		mins.add(value);
	}

	int dequeue() {
		int head = queue.poll();

		if (head == maxs.getFirst()) {
			maxs.removeFirst();
		}

		if (head == mins.getFirst()) {
			mins.removeFirst();
		}

		return head;
	}

	int getMax() {
		return maxs.getFirst();
	}

	int getMin() {
		return mins.getFirst();
	}
}