package _3_breadth_first_search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _11_sequence_reconstruction {
	/**
	 * @param org:  a permutation of the integers from 1 to n
	 * @param seqs: a list of sequences
	 * @return: true if it can be reconstructed only one or false
	 */
	public boolean sequenceReconstruction(int[] org, int[][] seqs) {
		// write your code here
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		Map<Integer, Integer> degree = new HashMap<Integer, Integer>();
		// Initialize map and degree
		for (int num : org) {
			map.put(num, new HashSet());
			degree.put(num, 0);
		}
		// Init map and degree according to seq
		int n = org.length;
		int count = 0;
		for (int[] seq : seqs) {
			count += seq.length;
			if (seq.length >= 1 && (seq[0] <= 0 || seq[0] > n)) {
				return false;
			}
			for (int i = 1; i < seq.length; i++) {
				if (seq[i] <= 0 || seq[i] > n) {
					return false;
				}
				if (map.get(seq[i - 1]).add(seq[i])) {
					degree.put(seq[i], degree.get(seq[i]) + 1);
				}
			}
		}
		if (count < n) {
			return false;
		}
		// Init queue
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int key : degree.keySet()) {
			if (degree.get(key) == 0) {
				queue.add(key);
			}
		}
		int cnt = 0;
		while (queue.size() == 1) {
			int head = queue.poll();
			Set<Integer> set = map.get(head);
			for (int num : set) {
				degree.put(num, degree.get(num) - 1);
				if (degree.get(num) == 0) {
					queue.add(num);
				}
			}
			// Means there may be two different sequences this time
			if (head != org[cnt]) {
				return false;
			}
			cnt++;
		}
		return cnt == org.length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_11_sequence_reconstruction sr = new _11_sequence_reconstruction();
		int[] org = { 1, 2, 3 };
		int[][] seqs = { { 1, 2 }, { 1, 3 } };
		boolean result = sr.sequenceReconstruction(org, seqs);
		System.out.print(result);
	}

}
