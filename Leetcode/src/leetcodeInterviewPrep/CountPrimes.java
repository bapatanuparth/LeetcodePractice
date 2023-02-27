package leetcodeInterviewPrep;

public class CountPrimes {

	// Sieve of Eratosthenes
	// mark all multiples of 2,3,4,5... as false
	// go till i*i < n
	// remaining elements in array will be primes
	public int countPrimes(int n) {

		boolean[] isprime = new boolean[n];
		// mark all primes as true
		for (int i = 2; i < n; i++) {
			isprime[i] = true;
		}

		// go from 2 to i*i < n,
		for (int i = 2; i * i < n; i++) {

			if (!isprime[i])
				continue;

			// start from j==i*i as all the elements before this are goin got be marked
			// already by previous loops
			for (int j = i * i; j < n; j += i) {
				isprime[j] = false;
			}
		}

		int cnt = 0;
		for (boolean bool : isprime) {
			if (bool)
				cnt++;
		}

		return cnt;
	}
}
