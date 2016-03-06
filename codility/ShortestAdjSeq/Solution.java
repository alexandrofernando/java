package ShortestAdjSeq;

// Iota 2011
// http://codility.com/demo/results/demoFRP3BX-V37/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
	static final int OFFSETS[] = { -1, 1 };

	public int solution(int[] A) {
		HashMap<Integer, ArrayList<Integer>> number2indices = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < A.length; i++) {
			if (!number2indices.containsKey(A[i])) {
				number2indices.put(A[i], new ArrayList<Integer>());
			}
			number2indices.get(A[i]).add(i);
		}

		int[] lengths = new int[A.length];
		Arrays.fill(lengths, -1);
		HashSet<Integer> numbers = new HashSet<Integer>();
		numbers.add(A[0]);
		for (int length = 1;; length++) {
			HashSet<Integer> nextNumbers = new HashSet<Integer>();
			for (int number : numbers) {
				for (int index : number2indices.get(number)) {
					if (index == A.length - 1) {
						return length;
					}
					lengths[index] = length;
					for (int offset : OFFSETS) {
						int nextIndex = index + offset;
						if (nextIndex >= 0 && nextIndex < lengths.length
								&& lengths[nextIndex] == -1) {
							nextNumbers.add(A[nextIndex]);
						}
					}
				}
			}
			numbers = nextNumbers;
		}
	}
}
