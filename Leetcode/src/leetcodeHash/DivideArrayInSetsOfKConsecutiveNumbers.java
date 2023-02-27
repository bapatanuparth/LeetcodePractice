package leetcodeHash;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class DivideArrayInSetsOfKConsecutiveNumbers {

	public boolean isPossibleDivide(int[] nums, int k) {
		// to get the first possible number of the set
		Queue<Integer> q = new PriorityQueue<>();
		// store the freq of occurrence of each element
		Map<Integer, Integer> map = new HashMap<>();

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
			q.add(num);
		}

		while (!q.isEmpty()) {
			// for each element
			int val = q.poll();
			// check whether map contains its next consecutive element
			for (int i = 0; i < k; i++) {

				if (!map.containsKey(i + val))
					return false;
				else {
					// if its freq==0, then check whether it is the 1st element of the new set
					// as this element could be reduced to zero as it was part of another set, it is
					// still valid
					if (map.get(i + val) == 0) {
						if (i != 0)
							return false; // if i==0, and it is expected to be a new element of any other set, it means
											// that repetition of i is not available
						else
							break;
					} else {
						map.replace(i + val, map.get(i + val) - 1);
					}
				}
			}
		}

		return true;

	}
}
