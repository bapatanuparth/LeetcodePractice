package leetCodeArrays2;

public class SemiOrderedPermutation {

//	You are given a 0-indexed permutation of n integers nums.
//
//	A permutation is called semi-ordered if the first number equals 1 and the last number equals n. You can perform the below operation as many times as you want until you make nums a semi-ordered permutation:
//
//	Pick two adjacent elements in nums, then swap them.
//	Return the minimum number of operations to make nums a semi-ordered permutation.
//
//	A permutation is a sequence of integers from 1 to n of length n containing each number exactly once.

	public int semiOrderedPermutation(int[] nums) {
		int n = nums.length;
		int onepos = -1, npos = -1;
		boolean swap = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1)
				onepos = i;
			if (nums[i] == n) {
				npos = i;
				if (onepos == -1)
					swap = true;
			}
		}

		int res = onepos + n - npos - 1;

		return swap == true ? res - 1 : res;
	}
}
