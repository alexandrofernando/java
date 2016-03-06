package Distinct;

// https://codility.com/demo/results/demoG4GE6V-E3Z/

import java.util.HashSet;

public class Solution {
	public int solution(int[] A) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int number : A) {
			set.add(number);
		}
		return set.size();
	}
}
