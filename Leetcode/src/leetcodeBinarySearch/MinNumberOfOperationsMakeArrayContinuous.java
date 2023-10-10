package leetcodeBinarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//You are given an integer array nums. In one operation, you can replace any element in nums with any integer.
//
//nums is considered continuous if both of the following conditions are fulfilled:
//
//All elements in nums are unique.
//The difference between the maximum element and the minimum element in nums equals nums.length - 1.
//For example, nums = [4, 2, 5, 3] is continuous, but nums = [1, 2, 3, 5, 6] is not continuous.
//
//Return the minimum number of operations to make nums continuous.

public class MinNumberOfOperationsMakeArrayContinuous {

	public int minOperations(int[] nums) {
		int n = nums.length;
		Set<Integer> set = new HashSet<>();
		for (int i : nums)
			set.add(i);

		int[] newNums = new int[set.size()];
		int index = 0;
		for (int i : set) {
			newNums[index++] = i;
		}

		Arrays.sort(newNums);

		int changes = nums.length;
		for (int i = 0; i < newNums.length; i++) {
			int max = getCurrEnd(newNums, newNums[i] + n - 1);
			int diff = max - i;
			changes = Math.min(changes, n - diff);
		}

		return changes;
	}

	int getCurrEnd(int newNums[], int target) {
		int left = 0;
		int right = newNums.length - 1;
		int ans = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (newNums[mid] <= target) {
				left = mid + 1;
				ans = left;
			} else {
				right = mid - 1;
			}
		}

		return left;
	}
}
