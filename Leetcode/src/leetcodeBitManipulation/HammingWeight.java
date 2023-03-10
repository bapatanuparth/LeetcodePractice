package leetcodeBitManipulation;

//Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
//
//Note:
//
//Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
//In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.

public class HammingWeight {

	public int hammingWeight(int n) {
		int res = 0;
		// System.out.println(n);
		for (int i = 1; i < 33; i++) {
			int x = 1 << (i - 1);

			if ((n & x) != 0)
				res++;
		}
		return res;
	}
}
