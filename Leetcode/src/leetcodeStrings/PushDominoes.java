package leetcodeStrings;

//There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
//
//After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
//
//When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
//
//For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
//
//You are given a string dominoes representing the initial state where:
//
//dominoes[i] = 'L', if the ith domino has been pushed to the left,
//dominoes[i] = 'R', if the ith domino has been pushed to the right, and
//dominoes[i] = '.', if the ith domino has not been pushed.
//Return a string representing the final state.

//Input: dominoes = "RR.L"
//Output: "RR.L"
public class PushDominoes {

	public String pushDominoes(String dominoes) {
		int start = 0;
		int end = 0;

		StringBuilder sb = new StringBuilder(dominoes);

		boolean right = false;

		// there can be 4 possibilities,
		for (end = 0; end < dominoes.length(); end++) {

			// we find an L and there is no domino previously seen that falls to right
			if (dominoes.charAt(end) == 'L' && right == false) {
				while (start != end) {
					sb.replace(start, start + 1, "L");
					start++;
				}
			}

			// we see a right falling domino and theres no previous one falling to right
			else if (dominoes.charAt(end) == 'R' && right == false) {
				right = true;
				start = end;
			}

			// we see a right falling domino and there is another one falling to right
			// previously seen
			else if (dominoes.charAt(end) == 'R' && right == true) {
				while (start != end) {
					sb.replace(start, start + 1, "R");
					start++;
				}
			}

			// if see an L and theres a R previously seen, we need to make sure that the one
			// in middle stands
			// and only the ones on left and right indicate falling
			else if (dominoes.charAt(end) == 'L' && right == true) {
				int templeft = start;
				int tempright = end;

				// System.out.println(start+" "+end);
				while (templeft < tempright) {
					sb.replace(templeft, templeft + 1, "R");
					sb.replace(tempright, tempright + 1, "L");
					templeft++;
					tempright--;
				}
				start = end;
				right = false;
			}
		}

		if (right == true) {
			while (start < dominoes.length()) {
				sb.replace(start, start + 1, "R");
				start++;
			}
		}

		return sb.toString();
	}
}
