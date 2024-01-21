package leetcodeSlidingWindow;

public class CountSubarraysWhereMaxAppearsAtLeastKTimes {

	public long countSubarrays(int[] nums, int k) {
		int max = 0;
		// find out the max of the array
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(nums[i], max);
		}

		int left = 0, count = 0;
		long res = 0L;

		for (int right = 0; right < nums.length; right++) {
			if (nums[right] == max)
				count++;
			// take each right element one by one
			if (count >= k) {
				// this means we need to count all subarrays from that lefdt position to the end
				res += (nums.length - right);
			}
			// also, we move left ahead one by one and again calculate all suhbarrays from
			// that left till the end considering the elements till right while we satisfy
			// the required condition of count >= k
			// this way we calculate all possible subarrays for the elements till right.
			while (left <= right && count >= k) {
				if (nums[left++] == max) {
					count--;
				}
				if (count < k)
					break;
				res += (nums.length - right);
			}
			// we move right ahead and repeatr the process
		}

		return res;
	}

}
