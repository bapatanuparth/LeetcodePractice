package leetcodeBitManipulation;

//Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
//Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.

public class MinFlipsToMakeAorBEqualC {

	// a | b ^ c should be equal to c
	// we want a | b == c
	// to check it, a | b ^ c will be 0 for all the bits that match
	// so we need to a | b ^ c and then check with c
	public int minFlips(int a, int b, int c) {

		int ab = a | b;
		int eq = ab ^ c;
		int ans = 0;
		for (int i = 0; i <= 31; i++) {
			int mask = 1 << i; // we shift 1 from right one by one, doing AND with mask will tell us if there
								// was 1 or 0 at that bit
			if ((eq & mask) > 0) { // this means there was a mismatch between a|b and c
				// eq & mask ==1, which means eq ==1, i.e. a | b ^ c ==1 i.e. a | b != c
				ans += (a & mask) == (b & mask) && (c & mask) == 0 ? 2 : 1;
				// if c ==0 and a, b both are equal to 1, then we need to flip 2 bits else we
				// need to flip only 1 bit
			}
		}
		return ans;
	}

}
