package leetcodeBitManipulation;

//Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

//
//You must implement a solution with a linear runtime complexity and use only constant extra space.

public class SingleNumberII {

//	Here is some intuition to help understand this nice and concise solution:
//
//		First of all, consider the (set^val) as one of the following:
//		1. adding "val" to the "set" if "val" is not in the "set" => A^0 = A
//		2. removing "val" from the "set" if "val" is already in the "set" => A^A = 0
//
//		Assume "ones" and "twos" to be sets that are keeping track of which numbers have appeared once and twice respectively;
//
//		"(ones ^ A[i]) & ~twos" basically means perform the above mentioned operation if and only if A[i] is not present in the set "twos". So to write it in layman:
//
//		   IF the set "ones" does not have A[i]
//		       Add A[i] to the set "ones" if and only if its not there in set "twos"
//		   ELSE
//		       Remove it from the set "ones"
//		So, effectively anything that appears for the first time will be in the set. Anything that appears a second time will be removed. We'll see what happens when an element appears a third time (thats handled by the set "twos").
//
//		After this, we immediately update set "twos" as well with similar logic:
//		"(twos^ A[i]) & ~ones" basically means:
//
//		   IF the set "twos" does not have A[i]
//		       Add A[i] to the set "twos" if and only if its not there in set "ones"
//		   ELSE
//		       Remove it from the set "twos"
//		So, effectively, any number that appears a first time will be in set "ones" so it will not be added to "twos". Any number appearing a second time would have been removed from set "ones" in the previous step and will now be added to set "twos". Lastly, any number appearing a third time will simply be removed from the set "twos" and will no longer exist in either set.
//
//		Finally, once we are done iterating over the entire list, set "twos" would be empty and set "ones" will contain the only number that appears once.

	public int singleNumber(int[] A) {
		int ones = 0, twos = 0;
		for (int i = 0; i < A.length; i++) {
			ones = (ones ^ A[i]) & ~twos;
			twos = (twos ^ A[i]) & ~ones;
		}
		return ones;
	}

	// method 2, easier approach
	public int singleNumber2(int[] nums) {
		// intuition == take some of each bit of each number
		// as every other number appears 3 times, if sum%3 at each place != 0, it means
		// that bit sum
		// included the single element
		int res = 0;
		// for each of the 32 bits
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			// traverse over the nums
			for (int j = 0; j < nums.length; j++) {
				// always to check if ith bit is set or not, right shift current number by i
				// then perform & operation with 1
				// this way we bring that bit to the right most and & with 000001 so we can se
				// if its set or not
				if (((nums[j] >> i) & 1) == 1) {
					sum += 1;
					sum %= 3; // take %3
				}
			}
			if (sum != 0) {
				// now in result, we need to set that bit. so we left shift sum by i to reach
				// the ith bit
				// then | with the result so that res has that bit set
				res |= sum << i;
			}
		}

		return res;
	}
}
