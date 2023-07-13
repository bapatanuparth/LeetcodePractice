package leetcode150daysArrays;

//Given an array of positive integers arr, return the sum of all possible odd-length subarrays of arr.
//
//A subarray is a contiguous subsequence of the array.
public class SumOfAllOddLengthSubarrays {

//	Start by finding the total number of subarrays that each index appears in. This is calculated by taking the number of subarrays ending at that index (i + 1) multiplied by the number of subarrays starting at that index (n - i).
//
//	To find the number of odd subarrays containing an index, take the total subarrays containing that index and divide by 2. If the total containing the array was odd, add 1 to the result to take into account the extra odd subarray.
//
//	Multiply each number and the number of odd subarrays it appears in. Return the sum of this.

	public int sumOddLengthSubarrays(int[] arr) {
		int result = 0;
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			int endingHere = i + 1;
			int startingHere = n - i;
			int totalSubarrays = endingHere * startingHere;
			int oddSubarrays = totalSubarrays / 2;
			if (totalSubarrays % 2 == 1)
				oddSubarrays++;
			result += oddSubarrays * arr[i];
		}

		return result;
	}

}
