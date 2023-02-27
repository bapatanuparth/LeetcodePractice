package leetcodeHash;

//Given an array of integers arr of even length n and an integer k.

//
//We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
//
//Return true If you can find a way to do that or false otherwise.
//

public class CheckIfArrayPairsDivisibleByK {

//	Keep count of remainders of all elements of arr
//	frequency[0] keeps all elements divisible by k, and a divisible of k can only form a group with other divisible of k. Hence, total number of such divisibles must be even.
//	for every element with remainder of i (i != 0) there should be a element with remainder k-i.
//	Hence, frequency[i] should be equal to frequency[k-i]
	public boolean canArrange(int[] arr, int k) {
		int[] freq = new int[k];

		// calc freq of each arr[i]%k
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i] % k;
			if (temp < 0)
				temp += k;
			freq[temp]++;
		}
		if (freq[0] % 2 != 0) // this means all numbers already divisible by k should be even
			return false;

		for (int i = 1; i < k; i++) {
			if (freq[i] != freq[k - i]) // all the others should have a pair
				return false;
		}

		return true;
	}
}
