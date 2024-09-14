package leetCodeArrays2;

//There are n soldiers standing in a line. Each soldier is assigned a unique rating value.
//
//You have to form a team of 3 soldiers amongst them under the following rules:
//
//Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
//A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
//Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).

public class CountNumberOfTeams {

	class Solution {

//		The key insight here is to examine each soldier as a potential middle member. For each such soldier, we need to count:
//
//			How many soldiers to their left have lower ratings
//			How many soldiers to their right have higher ratings
//			We apply the same logic for descending teams:
//
//			How many soldiers to their left have higher ratings
//			How many soldiers to their right have lower ratings

		public int numTeams(int[] rating) {
			int n = rating.length;
			int teams = 0;

			// Iterate through each soldier as the middle soldier
			for (int mid = 0; mid < n; mid++) {
				int leftSmaller = 0;
				int rightLarger = 0;

				// Count soldiers with smaller rating on the left side of the current soldier
				for (int left = mid - 1; left >= 0; left--) {
					if (rating[left] < rating[mid]) {
						leftSmaller++;
					}
				}

				// Count soldiers with larger ratings on the right side of the current soldier
				for (int right = mid + 1; right < n; right++) {
					if (rating[right] > rating[mid]) {
						rightLarger++;
					}
				}

				// Calculate and add the number of ascending rating teams (small-mid-large)
				teams += leftSmaller * rightLarger;

				// Calculate soldiers with larger ratings on the left and smaller ratings on the
				// right
				int leftLarger = mid - leftSmaller;
				int rightSmaller = n - mid - 1 - rightLarger;

				// Calculate and add the number of descending rating teams (large-mid-small)
				teams += leftLarger * rightSmaller;
			}

			// Return the total number of valid teams
			return teams;
		}
	}

	public int numTeams(int[] nums) {
		int[] nextGreater = new int[nums.length];
		int[] nextLesser = new int[nums.length];

		fillNextGreater(nextGreater, nums);
		fillNextLesser(nextLesser, nums);

		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > nums[i])
					ans += nextGreater[j];
				else
					ans += nextLesser[j];

			}
		}

		return ans;
	}

	void fillNextGreater(int nextGreater[], int nums[]) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > nums[i]) {
					nextGreater[i]++;
				}
			}
		}
	}

	void fillNextLesser(int nextLesser[], int nums[]) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[i]) {
					nextLesser[i]++;
				}
			}
		}
	}

}
