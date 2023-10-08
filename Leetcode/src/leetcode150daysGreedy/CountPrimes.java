package leetcode150daysGreedy;

//Given an integer n, return the number of prime numbers that are strictly less than n.

public class CountPrimes {

	public int countPrimes(int n) {
		int count = 0;
		boolean[] isPrime = new boolean[n];

		for (int i = 2; i < n; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i * i < n; i++) {
			if (!isPrime[i])
				continue;

			for (int j = i * i; j < n; j += i) {
				isPrime[j] = false;
			}
		}

		for (boolean bool : isPrime) {
			if (bool)
				count++;
		}
		return count;
	}

}
