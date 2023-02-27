package leetcodeMath;

//You have observations of n + m 6-sided dice rolls with each face numbered from 1 to 6. n of the observations went missing, and you only have the observations of m rolls. Fortunately, you have also calculated the average value of the n + m rolls.
//
//You are given an integer array rolls of length m where rolls[i] is the value of the ith observation. You are also given the two integers mean and n.
//
//Return an array of length n containing the missing observations such that the average value of the n + m rolls is exactly mean. If there are multiple valid answers, return any of them. If no such array exists, return an empty array.
//
//The average value of a set of k numbers is the sum of the numbers divided by k.
//
//Note that mean is an integer, so the sum of the n + m rolls should be divisible by n + m.

//Input: rolls = [1,5,6], mean = 3, n = 4
//Output: [2,3,2,2]
public class FindMissingObservations {

	public int[] missingRolls(int[] rolls, int mean, int n) {

		int m = rolls.length;
		int sum = 0;
		for (int i : rolls)
			sum += i;
		int total = mean * (n + m); // calculate total sum of n+m elements expected

		// so left is the sum to be generated from n elements
		int left = total - sum;
		if (left > n * 6 || left < n) // impossible to generate cases
			return new int[] {};

		// so average of left sum for n elements is taken
		int div = left / n;
		int offset = left % n; // remainder of the sum to be adjusted in elements

		int[] res = new int[n];

		for (int i = 0; i < res.length; i++) {
			res[i] = div;
			res[i] += offset > 0 ? 1 : 0; // if remainder is there, add it to the average value one by one, so value
											// dont exceed 6
			offset--;
		}
		return res;
	}
}
