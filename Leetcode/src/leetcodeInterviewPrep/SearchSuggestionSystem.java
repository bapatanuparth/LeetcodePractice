package leetcodeInterviewPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//You are given an array of strings products and a string searchWord.
//
//Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
//
//Return a list of lists of the suggested products after each character of searchWord is typed.
public class SearchSuggestionSystem {

	// CHECK OUT OTHER APPROACH USING TRIE

	// my approach
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {

		// sort the products to get lexicographically sorted o/p
		Arrays.sort(products);

		List<String> check = new ArrayList<>();
		List<List<String>> result = new ArrayList<>();

		// use check list to search for matching search entries, this can reduce our
		// time
		for (String s : products)
			check.add(s);

		// for each character in the searchword, check for all the strings that have it
		// as prefix, add those in a temp list
		String str = "";
		for (char ch : searchWord.toCharArray()) {
			str = str + ch;
			List<String> temp = new ArrayList<>();

			for (String s : check) {

				if (s.indexOf(str) == 0) {
					temp.add(s);
				}
			}

			check = temp;
			result.add(temp.size() > 3 ? temp.subList(0, 3) : temp);

		}

		return result;

	}
}
