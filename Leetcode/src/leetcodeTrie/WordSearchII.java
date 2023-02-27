package leetcodeTrie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

	public List<String> findWords(char[][] board, String[] words) {

		List<String> res = new ArrayList<>();
		TrieNode root = buildTrie(words);

		// simple backtracking
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				backtracking(board, i, j, root, res);
			}
		}
		return res;
	}

	void backtracking(char[][] board, int i, int j, TrieNode p, List<String> res) {

		// check if the current character is present in the TrieNode p, at start it will
		// look into root.
		// if no word starting from that character, we return
		char c = board[i][j];
		// # is used to mark visited nodes eliminating visited array
		if (board[i][j] == '#' || p.next[c - 'a'] == null)
			return;
		// go to the node where we have that word with current character
		p = p.next[c - 'a'];
		// if p.word!= null this means, a word has ended at this node
		if (p.word != null) {
			res.add(p.word); // add this to result as we have reached to the end of a word
			p.word = null;
		}
		// do simple dfs calls for all positions
		board[i][j] = '#';
		if (i > 0)
			backtracking(board, i - 1, j, p, res);
		if (j > 0)
			backtracking(board, i, j - 1, p, res);
		if (i < board.length - 1)
			backtracking(board, i + 1, j, p, res);
		if (j < board[0].length - 1)
			backtracking(board, i, j + 1, p, res);

		// mark the board back to the character
		board[i][j] = c;

	}

	TrieNode buildTrie(String[] words) {

		TrieNode root = new TrieNode();
		for (String word : words) { // take word by word

			TrieNode p = root;
			// build trie character by character
			for (char ch : word.toCharArray()) {

				int val = ch - 'a';
				if (p.next[val] == null)
					p.next[val] = new TrieNode();
				p = p.next[val];
			}
			// when whole word is completed, insert word== word, so that we know that this
			// is the node where a word ends
			p.word = word;
		}

		return root;
	}

	class TrieNode {
		TrieNode[] next = new TrieNode[26];
		String word; // here we save the word on the TrieNode instead of marking isEnd as true when
						// full word is completed
	}
}
