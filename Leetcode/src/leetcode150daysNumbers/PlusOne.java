package leetcode150daysNumbers;

//You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
//
//Increment the large integer by one and return the resulting array of digits.

public class PlusOne {

	public int[] plusOne(int[] digits) {
		int n = digits.length;

		// move along the input array starting from the end
		for (int idx = n - 1; idx >= 0; --idx) {
			// set all the nines at the end of array to zeros
			if (digits[idx] == 9) {
				digits[idx] = 0;
			}
			// here we have the rightmost not-nine
			else {
				// increase this rightmost not-nine by 1
				digits[idx]++;
				// and the job is done
				return digits;
			}
		}
		// we're here because all the digits are nines
		digits = new int[n + 1];
		digits[0] = 1;
		return digits;
	}
}
