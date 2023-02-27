package leetCodeArrays2;
//There is a function signFunc(x) that returns:

//
//1 if x is positive.
//-1 if x is negative.
//0 if x is equal to 0.
//You are given an integer array nums. Let product be the product of all values in the array nums.
//
//Return signFunc(product).

public class SignProductOfArray {
	public int arraySign(int[] nums) {
		int pos = 0, neg = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				return 0;
			else if (nums[i] > 0)
				pos++;
			else
				neg++;
		}

		return neg % 2 == 0 ? 1 : -1;
	}

}
