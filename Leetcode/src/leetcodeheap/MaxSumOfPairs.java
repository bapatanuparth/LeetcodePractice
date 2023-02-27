package leetcodeheap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].
//
//Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.

//Input: nums = [18,43,36,13,7]
//Output: 54

public class MaxSumOfPairs {

	// similar to what i did but witout using heap
	// u can directly calculate sum while adding element in the map
	public int maximumSumEff(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int sum = 0;
			while (num > 0) {
				int r = num % 10;
				sum = sum + r;
				num = num / 10;
			}
			if (map.containsKey(sum)) {
				int s = map.get(sum);
				if (s + nums[i] > max)
					max = s + nums[i];
				if (nums[i] > s)
					map.replace(sum, nums[i]);
			} else
				map.put(sum, nums[i]);
		}
		if (max == Integer.MIN_VALUE)
			return -1;
		return max;
	}

	// we have to choose 2 numbers whose sum of digits is the greatest in the array
	// Group the array elements by the sum of their digits, and find the largest two
	// elements of each group.
	public int maximumSum(int[] nums) {

		// this hashmap is a map of
		// <int sum, PQ(heap of numbers whos digits addition == sum)>
		Map<Integer, Queue<Integer>> map = new HashMap<>();

		// get sum of each number of the array, put it in a hashmap
		for (int i = 0; i < nums.length; i++) {

			int n = nums[i];
			int sum = 0;
			while (n > 0) {
				sum += n % 10;
				n = n / 10;
			}

			if (map.containsKey(sum)) {
				map.get(sum).add(nums[i]);
			} else {
				Queue<Integer> t = new PriorityQueue<>((a, b) -> b - a);
				t.add(nums[i]);
				map.put(sum, t);
			}
		}

		// now we need to find the max 2 elements in each group of sum
//this is where heap helps us to get 2 max elements easily
		int res = -1;
		for (int i : map.keySet()) {
			Queue<Integer> q = map.get(i);
			if (q.size() <= 1)
				continue;
			else {
				int num1 = q.poll();
				int num2 = q.poll();
				res = Math.max(res, num1 + num2);
			}
		}

		return res;

	}
}
