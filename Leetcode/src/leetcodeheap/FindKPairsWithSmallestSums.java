package leetcodeheap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKPairsWithSmallestSums {

	// naive approach,
	// traverse all n2 numbers and add to a maxheap and maintain its size to k
	// stop traversing once u realize that the current sum > pq.peek().
	// as everything after that is going to be >> pq.peek()
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		int max = Integer.MIN_VALUE;
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);

		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				int sum = nums1[i] + nums2[j];
				if (pq.size() < k)
					pq.add(new int[] { nums1[i], nums2[j], sum });
				else if (sum < pq.peek()[2]) {
					pq.poll();
					pq.add(new int[] { nums1[i], nums2[j], sum });
				} else
					break;

			}
		}
		List<List<Integer>> res = new ArrayList<>();
		while (pq.size() > 0) {
			int arr[] = pq.poll();
			List<Integer> temp = new ArrayList<>();
			temp.add(arr[0]);
			temp.add(arr[1]);
			res.add(temp);
		}

		return res;
	}

}
