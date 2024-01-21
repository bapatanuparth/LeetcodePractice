package leetcodeGreedy;

//Given an array nums of integers, a move consists of choosing any element and decreasing it by 1.
//
//An array A is a zigzag array if either:
//
//Every even-indexed element is greater than adjacent elements, ie. A[0] > A[1] < A[2] > A[3] < A[4] > ...
//OR, every odd-indexed element is greater than adjacent elements, ie. A[0] < A[1] > A[2] < A[3] > A[4] < ...
//Return the minimum number of moves to transform the given array nums into a zigzag array.

public class DecreaseElementsToMakeArrayZigzag {
	public int movesToMakeZigzag(int[] nums) {
		if (nums.length < 2)
			return 0;
		int n = nums.length;
		int sum1 = 0, sum2 = 0;

		// a > b < c > d
		for (int i = 1; i < n; i += 2) {
			int min = i < n - 1 ? Math.min(nums[i - 1], nums[i + 1]) : nums[i - 1];
			if (nums[i] >= min)
				sum1 += nums[i] - min + 1;
		}

		// a < b > c < d
		for (int i = 0; i < n; i += 2) {
			int min;
			if (i == 0)
				min = nums[i + 1];
			else if (i == n - 1)
				min = nums[i - 1];
			else
				min = Math.min(nums[i + 1], nums[i - 1]);
			if (nums[i] >= min)
				sum2 += nums[i] - min + 1;
		}

		return Math.min(sum1, sum2);
	}

}
