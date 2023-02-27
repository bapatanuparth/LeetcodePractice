package leetcodeDynamicProgramming;

public class UglyNumberII {

//	An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
//
//	Given an integer n, return the nth ugly number.

	public int nthUglyNumber(int n) {
//         We have an array k of first n ugly number. We only know, at the beginning, the first one, which is 1. Then

// k[1] = min( k[0]x2, k[0]x3, k[0]x5). The answer is k[0]x2. So we move 2's pointer to 1. Then we test:

// k[2] = min( k[1]x2, k[0]x3, k[0]x5). And so on. Be careful about the cases such as 6, in which we need to forward both pointers of 2 and 3
		int res[] = new int[n];

		int p2 = 0, p3 = 0, p5 = 0;
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			res[i] = Math.min(res[p2] * 2, Math.min(res[p3] * 3, res[p5] * 5));
			if (res[i] == res[p2] * 2)
				p2++;
			if (res[i] == res[p3] * 3)
				p3++;
			if (res[i] == res[p5] * 5)
				p5++;
		}

		return res[n - 1];
	}

}
