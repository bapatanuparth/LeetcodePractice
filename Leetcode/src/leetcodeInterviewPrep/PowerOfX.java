package leetcodeInterviewPrep;

public class PowerOfX {

	public double myPow(double x, int n) {
		if (n == -2147483648) { // for int value, -2^31, it does not have a perfect +ve value 2^31.
			// signed int ranges from 2^31-1 to 2^31. Handle the case separately
			if (x == 1 || x == -1)
				return 1;
			else
				return 0;
		}
		if (n > 0)
			return pow(x, n);
		else if (n == 0)
			return 1;
		else { // if n is negative, take reciprocal of the power
			return 1 / pow(x, -n);
		}
	}

	double pow(double x, double n) {
		if (n == 1) // if n==1 return x
			return x;
		if (n == 2) { // if n^2 return n^2
			return x * x;
		} else if (n % 2 == 0) { // if n is even, use formula = xn== (x2)^n/2
			return pow(x * x, n / 2);
		} else {
			double m = n - 1; //else use x*((x2)^n-1/2)
			return x * pow(x * x, m / 2);
		}
	}
}
