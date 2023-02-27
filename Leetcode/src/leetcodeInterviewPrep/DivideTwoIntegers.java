package leetcodeInterviewPrep;

//Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

//
//The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
//
//Return the quotient after dividing dividend by divisor.
//
public class DivideTwoIntegers {

	// exponential search gives TLE -->
	public int divideExpo(int dividend, int divisor) {
		int negatives = 0;

		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}

		if (dividend < 0) {
			negatives++;
			dividend = -dividend;
		}
		if (divisor < 0) {
			negatives++;
			divisor = -divisor;
		}

		int quotient = 0;
		while (dividend >= divisor) {
			int powerOfTwo = 1;

			int value = divisor;

			while (value + value < dividend) {
				value += value;
				powerOfTwo += powerOfTwo;
			}

			quotient += powerOfTwo;
			dividend -= value;
		}

		if (negatives == 1)
			return -quotient;
		return quotient;
	}

	// this solution gives TLE for input INTEGER>MAX_VALUE
	public int divide(int dividend, int divisor) {
		int negatives = 0;

		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}

		// calculate if dividend/ divisor or both are negative
		// convert them to positive
		if (dividend < 0) {
			negatives++;
			dividend = -dividend;
		}
		if (divisor < 0) {
			negatives++;
			divisor = -divisor;
		}

		// do repeated subtractions till we reach the end
		int subtractions = 0;
		while (dividend - divisor >= 0) {
			subtractions++;
			dividend -= divisor;
		}

		if (negatives == 1) {
			subtractions = -subtractions;
		}

		return subtractions;
	}
}
