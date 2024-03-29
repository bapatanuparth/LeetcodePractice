package leetcode150daysBitManipulation;

//Write a function that takes the binary representation of an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
//
//Note:
//
//Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
//In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.

//this is also called hamming weight
public class NumberOf1Bits {

	public int hammingWeightNaive(int n) {
		int res = 0;
		// System.out.println(n);
		for (int i = 1; i < 33; i++) {
			if (((n >> i) & 1) == 1)
				res++;
		}
		return res;
	}

	public int hammingWeight(int n) {
		int sum = 0;
		while (n != 0) {
			sum++;
			n &= (n - 1);
		}
		return sum;
	}

}
