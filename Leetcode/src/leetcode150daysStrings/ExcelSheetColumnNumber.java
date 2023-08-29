package leetcode150daysStrings;

//Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

public class ExcelSheetColumnNumber {

	public int titleToNumber(String str) {
		int res = 0;
		for (int i = 0; i < str.length(); i++) {
			res = res * 26;
			res += (str.charAt(i) - 'A' + 1);
		}

		return res;
	}
}
