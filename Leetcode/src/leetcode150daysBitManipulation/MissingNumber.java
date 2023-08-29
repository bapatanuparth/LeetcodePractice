package leetcode150daysBitManipulation;

//Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

public class MissingNumber {

	public int missingNumber(int[] nums) {
		int temp = 0;
		// we load all the present numbers
		for (int i : nums) {
			temp ^= i;
		}
		// when we xor with same number again, those get set back to 0
		// only one that was not seen before remains
		for (int i = 0; i <= nums.length; i++) {
			temp ^= i;
		}

		return temp;
	}

}
