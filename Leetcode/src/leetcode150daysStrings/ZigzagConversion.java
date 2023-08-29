package leetcode150daysStrings;

//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//And then read line by line: "PAHNAPLSIIGYIR"
//
//Write the code that will take a string and make this conversion given a number of rows:
//
//string convert(string s, int numRows);

public class ZigzagConversion {

	public String convert(String s, int numRows) {
		char[] c = s.toCharArray();
		int n = s.length();
		StringBuilder[] arr = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++)
			arr[i] = new StringBuilder();

		int i = 0;
		while (i < n) {
			for (int idx = 0; idx < numRows && i < n; idx++)
				arr[idx].append(c[i++]);
			for (int idx = numRows - 2; idx >= 1 && i < n; idx--)
				arr[idx].append(c[i++]);
		}

		StringBuilder res = new StringBuilder();
		for (StringBuilder sb : arr) {
			res.append(sb);
		}
		return res.toString();
	}

}
