package leetcode150daysGreedy;

//You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
//
//Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
//
//0 <= j <= nums[i] and
//i + j < n
//Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

public class JumpGameII {

	public int jump(int[] nums) {
		if (nums.length == 1)
			return 0;
		int i = 0, end = nums[i];
		int max = 0, steps = 0;
		while (i < nums.length) {
			while (i < nums.length && i <= end) {
				max = Math.max(max, i + nums[i]);
				i++;
			}
			end = Math.max(end, max);
			steps++;
		}
		return steps;

	}

}
