package leetcodeSlidingWindow;

//A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false. He wants to confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or multiple falses in a row).
//
//You are given a string answerKey, where answerKey[i] is the original answer to the ith question. In addition, you are given an integer k, the maximum number of times you may perform the following operation:
//
//Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
//Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times.

public class MAximizeConfusionOfExam {

//	keep 2 counters to count the Trues and Falses in the window.
//	we can allow maximum mismatch of K, i.e. the minimum of both counters cannot exceed K.
//	When min of both counters <= k, we can safely flip all the min frequency characters and still get a window of max consecutive character.
//	if min of both counters > k, it means that window cannot have same consecutive character even after flipping all the characters, as we are allowed only K flips.
//	note that either one of the counters can go above K.
//	for ex. in case TTTFTTT and K ==1, CF==1 and CT==6. This is admissible as there is only 1 F which is in K limit.
//	ex. FTTTFTTT and K==1, here, when we reach index 4 at F, we have cf==2 and ct==3. as both CF>K and CT>k, 0 to 4 window becomes invalid, so we remove F from left and move window ahead.
	class Solution {
		public int maxConsecutiveAnswers(String answerKey, int k) {
			// keep 2 counters to count frequency of Ts and Fs
			int cf = 0, ct = 0;
			int left = 0;
			char[] arr = answerKey.toCharArray();

			int ans = 0;

			for (int i = 0; i < arr.length; i++) {
				// for each new character, add to counter of ct or cf based on T or F
				if (arr[i] == 'F')
					cf++;
				else
					ct++;
				// for allowing max up to k changes,
				// we need to make sure that the minimum of any 2 counts should be <=k
				// because we can assume that we can flip the min count character and make the
				// largest string with same consecutive Ts or Fs
				if (cf > k && ct > k) {
					// if both characters > k, we need to move the window ahead and remove the
					// elements from left
					// till we do not have at least one character < k
					while (cf > k && ct > k && left <= i) {
						if (arr[left] == 'F')
							cf--;
						else
							ct--;
						left++;
					}

				}
				// store the max length after moving left and i
				ans = Math.max(ans, i - left + 1);
			}

			return ans;

		}
	}

}
