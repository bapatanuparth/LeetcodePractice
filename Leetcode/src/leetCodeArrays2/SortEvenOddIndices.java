package leetCodeArrays2;

import java.util.PriorityQueue;
import java.util.Queue;

public class SortEvenOddIndices {

	public int[] sortEvenOdd(int[] nums) {

		Queue<Integer> qeven = new PriorityQueue<>((a, b) -> a - b);
		Queue<Integer> qodd = new PriorityQueue<>((a, b) -> b - a);

		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0)
				qeven.add(nums[i]);
			else
				qodd.add(nums[i]);
		}

		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0)
				nums[i] = qeven.poll();
			else
				nums[i] = qodd.poll();
		}

		return nums;
	}
}
