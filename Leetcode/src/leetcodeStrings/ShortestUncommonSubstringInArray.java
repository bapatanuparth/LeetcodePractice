package leetcodeStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

//You are given an array arr of size n consisting of non-empty strings.
//
//Find a string array answer of size n such that:
//
//answer[i] is the shortest 
//substring
// of arr[i] that does not occur as a substring in any other string in arr. If multiple such substrings exist, answer[i] should be the 
//lexicographically smallest
//. And if no such substring exists, answer[i] should be an empty string.
//Return the array answer.

public class ShortestUncommonSubstringInArray {

	public String[] shortestSubstrings(String[] arr) {
		HashMap<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			String s = arr[i];
			// Duplicates within ith string will be counted once, so storing in Set
			// (Example : "grg")
			// "g" will be added in Set and then in Map,
			// else count of "g" would have been 2 if directly added in Map,
			// although being present in same ith string.
			HashSet<String> hs = new HashSet<>();
			for (int j = 0; j < arr[i].length(); j++) {
				for (int k = j + 1; k <= arr[i].length(); k++)
					// Store all possible substring of a particular ith string in Set
					hs.add(s.substring(j, k));
			}
			for (String e : hs) {
				// Add all strings from Set to Map
				hm.put(e, hm.getOrDefault(e, 0) + 1);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			String s = arr[i];
			ArrayList<String> al = new ArrayList<>();
			for (int j = 0; j < arr[i].length(); j++) {
				for (int k = j + 1; k <= arr[i].length(); k++) {
					// If a substring appeared only once, i.e. it appeared in this particular ith
					// string,
					// It has the chance to be the smallest one, so add it in arraylist
					if (hm.get(s.substring(j, k)) == 1)
						al.add(s.substring(j, k));
				}
			}
			if (al.size() == 0)
				arr[i] = "";
			else if (al.size() == 1)
				arr[i] = al.get(0);
			else {
				Collections.sort(al); // This sorts lexicographically, but not lengthwise
				String ans = al.get(0);
				for (int b = 1; b < al.size(); b++) {
					if (al.get(b).length() < ans.length()) // This provides lexicographically smallest length
						ans = al.get(b);
				}
				arr[i] = ans;
			}
		}
		return arr;
	}

}
