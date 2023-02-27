package leetcodeInterviewPrep;

//You are given a 0-indexed binary string s which represents the types of buildings along a street where:
//
//s[i] = '0' denotes that the ith building is an office and
//s[i] = '1' denotes that the ith building is a restaurant.
//As a city official, you would like to select 3 buildings for random inspection. However, to ensure variety, no two consecutive buildings out of the selected buildings can be of the same type.
//
//For example, given s = "001101", we cannot select the 1st, 3rd, and 5th buildings as that would form "011" which is not allowed due to having two consecutive buildings of the same type.
//Return the number of valid ways to select 3 buildings.

//Input: s = "001101"
//Output: 6
//Explanation: 
//The following sets of indices selected are valid:
//- [0,2,4] from "001101" forms "010"
//- [0,3,4] from "001101" forms "010"
//- [1,2,4] from "001101" forms "010"
//- [1,3,4] from "001101" forms "010"
//- [2,4,5] from "001101" forms "101"
//- [3,4,5] from "001101" forms "101"
public class NoOfWaysToSelectBuilding {

	public long numberOfWays(String s) {
		long ans = 0;

		int[] prez = new int[s.length()];
		int[] preo = new int[s.length()];

		// calculate the number of ones and zeros present before the given index i
		for (int i = 0; i < s.length(); i++) {

			if (i == 0) {
				prez[i] = s.charAt(i) == '0' ? 1 : 0;
				preo[i] = s.charAt(i) == '1' ? 1 : 0;
				continue;
			}

			prez[i] = s.charAt(i) == '0' ? prez[i - 1] + 1 : prez[i - 1];
			preo[i] = s.charAt(i) == '1' ? preo[i - 1] + 1 : preo[i - 1];
		}
		int n = s.length();

		for (int i = 1; i < n - 1; i++) {

			// now for each element, if element is 0, check how many ones are behind and
			// ahead of it.
			// their multiplication will give the possible combinations on that index
			if (s.charAt(i) == '1') {
				long x = prez[i - 1];
				long y = prez[n - 1] - prez[i];
				ans += (x * y);
			}
			// if current element is 0, check how many ones are before and after curr. their
			// multiplication will cover all possible combinations
			else if (s.charAt(i) == '0') {
				long x = preo[i - 1];
				long y = preo[n - 1] - preo[i];
				ans += (x * y);
			}
		}

		return ans;
	}
}
