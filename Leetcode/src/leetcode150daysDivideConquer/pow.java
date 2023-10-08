package leetcode150daysDivideConquer;

public class pow {

	public double myPow(double x, int n) {
		return pow(x, (long) n);
	}

	double pow(double x, long n) {
		if (n < 0) {
			x = 1 / x;
			n *= -1;
		}
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		if (n == 2)
			return x * x;
		if (n % 2 == 0) {
			return pow(x * x, n / 2);
		} else {
			return x * pow(x * x, (n - 1) / 2);
		}
	}

}
