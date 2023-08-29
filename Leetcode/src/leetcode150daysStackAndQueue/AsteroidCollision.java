package leetcode150daysStackAndQueue;

import java.util.Stack;

public class AsteroidCollision {

	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> st = new Stack<>();

		for (int ast : asteroids) {
			boolean push = true;

			while (!st.isEmpty() && ast < 0 && st.peek() > 0 && push == true) {
				int abs = Math.abs(ast);
				if (abs <= st.peek()) {
					push = false;
				}
				if (abs >= st.peek())
					st.pop();
			}
			if (push)
				st.push(ast);
		}

		int[] res = new int[st.size()];
		for (int i = res.length - 1; i >= 0; i--) {
			res[i] = st.pop();
		}
		return res;

	}

}
