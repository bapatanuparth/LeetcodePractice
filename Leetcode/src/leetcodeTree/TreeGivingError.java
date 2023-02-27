package leetcodeTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TreeGivingError {

	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		try {
			Scanner sc = new Scanner(System.in);
			if (!sc.hasNextLine())
				throw new Exception("E1");
			String input = sc.nextLine();
			if (sc.hasNextLine())
				throw new Exception("E1");
			inputParser(input);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	static void inputParser(String str) throws Exception {
		// check for leading trailing whitespaces
		if (Character.isWhitespace(str.charAt(0)) || Character.isWhitespace(str.charAt(str.length() - 1)))
			throw new Exception("E1");
		String[] pairs = str.split(" ");

		// input formatting issue
		for (String s : pairs) {
			if (s.length() < 5)
				throw new Exception("E1");
			if (s.length() > 5)
				throw new Exception("E1");
			if (s.charAt(1) == s.charAt(3))
				throw new Exception("E1");
			if (s.charAt(0) != '(')
				throw new Exception("E1");
			if (!Character.isUpperCase(s.charAt(1)))
				throw new Exception("E1");
			if (s.charAt(2) != ',')
				throw new Exception("E1");
			if (!Character.isUpperCase(s.charAt(3)))
				throw new Exception("E1");
			if (s.charAt(4) != ')')
				throw new Exception("E1");
		}

		// duplicate pair issue
		Map<Character, List<Character>> map = new HashMap<>();
		for (String s : pairs) {
			if (map.containsKey(s.charAt(1))) {
				if (map.get(s.charAt(1)).contains(s.charAt(3)))
					throw new Exception("E2");
				map.get(s.charAt(1)).add(s.charAt(3));
			} else {
				List<Character> temp = new ArrayList<>();
				temp.add(s.charAt(3));
				map.put(s.charAt(1), temp);
			}
		}

		// more than 2 children issue
		boolean isChild[] = new boolean[26];
		for (Character parent : map.keySet()) {
			List<Character> children = map.get(parent);
			if (children.size() > 2)
				throw new Exception("E3");

			for (Character child : children) {
				isChild[child - 'A'] = true;
			}

		}

		// multiple roots issue
		boolean root = false;
		for (Character parent : map.keySet()) {
			if (root == true && isChild[parent - 'A'] == false)
				throw new Exception("E4");
			else if (root = false && isChild[parent - 'A'] == false)
				root = true;
		}

		// isCycle issue
		boolean[] visited = new boolean[26];
		for (Character parent : map.keySet()) {
			if (visited[parent - 'A'] == false) {
				if (checkCycle(map, parent, visited))
					throw new Exception("E5");
			}
		}

		// if no issue print tree
		StringBuilder sb = new StringBuilder();
		for (Character parent : map.keySet()) {
			if (isChild[parent - 'A'] == false) {

				printTree(map, parent, sb);
				break;
			}
		}

		System.out.println(sb.toString());

	}

	static boolean checkCycle(Map<Character, List<Character>> map, Character parent, boolean visited[]) {

		visited[parent - 'A'] = true;

		if (map.containsKey(parent)) {
			for (Character child : map.get(parent)) {
				if (visited[child - 'A'] == false) {
					if (checkCycle(map, child, visited))
						return true;
				} else
					return true;
			}
		}

		return false;
	}

	static void printTree(Map<Character, List<Character>> map, Character root, StringBuilder sb) {

		sb.append("(");
		sb.append(root);

		if (map.containsKey(root)) {
			Collections.sort(map.get(root));
			for (Character child : map.get(root)) {
				printTree(map, child, sb);
			}
		}
		sb.append(")");
	}
}
