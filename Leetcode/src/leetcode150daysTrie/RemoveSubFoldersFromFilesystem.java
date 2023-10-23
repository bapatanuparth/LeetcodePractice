package leetcode150daysTrie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given a list of folders folder, return the folders after removing all sub-folders in those folders. You may return the answer in any order.
//
//If a folder[i] is located within another folder[j], it is called a sub-folder of it.
//
//The format of a path is one or more concatenated strings of the form: '/' followed by one or more lowercase English letters.
//
//For example, "/leetcode" and "/leetcode/problems" are valid paths while an empty string and "/" are not.

public class RemoveSubFoldersFromFilesystem {

	class Solution {

		class TrieNode {
			Map<String, TrieNode> map = new HashMap<>();
			String word = null;
		}

		TrieNode root;

		public List<String> removeSubfolders(String[] folder) {
			root = new TrieNode();
			List<String> res = new ArrayList<>();
			// sort array based on length because we want to ensure that top level folder is
			// put before subfolder
			Arrays.sort(folder, (a, b) -> a.length() - b.length());

			for (String fold : folder) {
				// for each path, check if there exists a prefix,.i.e. check if its a subfolder
				// of an already exisiting folder
				if (!checkPrefix(fold)) {
					// if not then create the new structure and add the current path to result
					construct(fold);
					res.add(fold);
				}
			}
			return res;
		}

		// simulate trie working using map for each string just the way we do using an
		// array for each character
		void construct(String fold) {
			TrieNode node = root;
			String[] str = fold.split("/");

			for (String s : str) {
				if (s.length() == 0)
					continue;
				if (!node.map.containsKey(s)) {
					node.map.put(s, new TrieNode());
				}
				node = node.map.get(s);
			}
			node.word = fold;
		}

		boolean checkPrefix(String fold) {
			TrieNode node = root;
			String[] str = fold.split("/");

			for (String s : str) {
				if (s.length() == 0)
					continue;
				if (node.word != null)
					return true;
				if (!node.map.containsKey(s)) {
					break;
				}
				node = node.map.get(s);
			}
			return false;
		}
	}

}
