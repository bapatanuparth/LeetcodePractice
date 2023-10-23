package leetcode150daysTrie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//You are given an array of strings products and a string searchWord.
//
//Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
//
//Return a list of lists of the suggested products after each character of searchWord is typed.

public class SearchSuggestionSystem {

	class Solution {

		class TrieNode {
			TrieNode[] children = new TrieNode[26];
			String word = null;
		}

		TrieNode root;

		public void addWord(String word) {
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				if (node.children[c - 'a'] == null) {
					node.children[c - 'a'] = new TrieNode();
				}
				node = node.children[c - 'a'];
			}
			node.word = word;
		}

		public List<String> search(String prefix) {
			TrieNode node = root;
			List<String> res = new ArrayList<>();
			for (char ch : prefix.toCharArray()) {
				if (node.children[ch - 'a'] != null) {
					node = node.children[ch - 'a'];
				} else {
					return res;
				}
			}
			match(node, res);
			return res;
		}

		void match(TrieNode node, List<String> res) {
			if (res.size() > 3)
				return;

			if (node.word != null)
				res.add(node.word);

			for (int i = 0; i < 26; i++) {
				if (node.children[i] != null) {
					match(node.children[i], res);
				}
			}
		}

		public List<List<String>> suggestedProducts(String[] products, String searchWord) {
			root = new TrieNode();

			for (String prod : products) {
				addWord(prod);
			}
			List<List<String>> res = new ArrayList<>();

			for (int i = 1; i <= searchWord.length(); i++) {
				String sub = searchWord.substring(0, i);
				List<String> ls = search(sub);
				res.add(ls.stream().limit(3).collect(Collectors.toList()));
			}

			return res;
		}
	}
}
