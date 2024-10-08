package leetcodeSlidingWindow;

//There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store. You are given an integer array customers of length n where customers[i] is the number of the customer that enters the store at the start of the ith minute and all those customers leave after the end of that minute.
//
//On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.
//
//When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.
//
//The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, but can only use it once.
//
//Return the maximum number of customers that can be satisfied throughout the day.

public class GrumpyBookstoreOwner {

	public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
		int left = 0, right = 0, n = customers.length, max = 0, sum = 0;

		while (right < n && right < minutes) {
			sum += customers[right];
			right++;
		}

		for (int i = right; i < n; i++) {
			if (grumpy[i] == 0)
				sum += customers[i];
		}

		max = Math.max(max, sum);

		for (; right < n; right++) {
			if (grumpy[right] == 1)
				sum += customers[right];
			if (grumpy[left] == 1)
				sum -= customers[left];
			left++;
			max = Math.max(max, sum);
		}

		return max;
	}
}
