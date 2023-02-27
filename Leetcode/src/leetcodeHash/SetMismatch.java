package leetcodeHash;

//You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
//
//You are given an integer array nums representing the data status of this set after the error.
//
//Find the number that occurs twice and the number that is missing and return them in the form of an array.

//Input: nums = [1,2,2,4]
//Output: [2,3]
public class SetMismatch {

	public int[] findErrorNums(int[] nums) {
		int[] arr = new int[nums.length];
		int res[] = new int[2];

		// create new temp array and mark all the places visited
		for (int i = 0; i < nums.length; i++) {
			if (arr[nums[i] - 1] != 0) {
				res[0] = nums[i];
			} else {
				arr[nums[i] - 1] = 1;
			}
		}
		// find the one that is not visited
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				res[1] = i + 1;
				break;
			}

		}
		return res;
	}
}
