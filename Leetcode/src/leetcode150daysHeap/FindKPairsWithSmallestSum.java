package leetcode150daysHeap;

//You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
//
//Define a pair (u, v) which consists of one element from the first array and one element from the second array.
//
//Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums

public class FindKPairsWithSmallestSum {

//	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//		int m = nums1.length;
//		int n = nums2.length;
//
//		List<List<Integer>> ans = new ArrayList<>();
//		Set<Pair<Integer, Integer>> visited = new HashSet<>();
//
//		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
//		minHeap.offer(new int[] { nums1[0] + nums2[0], 0, 0 });
//		visited.add(new Pair<Integer, Integer>(0, 0));
//
//		while (k-- > 0 && !minHeap.isEmpty()) {
//			int[] top = minHeap.poll();
//			int i = top[1];
//			int j = top[2];
//
//			ans.add(List.of(nums1[i], nums2[j]));
//
//			if (i + 1 < m && !visited.contains(new Pair<Integer, Integer>(i + 1, j))) {
//				minHeap.offer(new int[] { nums1[i + 1] + nums2[j], i + 1, j });
//				visited.add(new Pair<Integer, Integer>(i + 1, j));
//			}
//
//			if (j + 1 < n && !visited.contains(new Pair<Integer, Integer>(i, j + 1))) {
//				minHeap.offer(new int[] { nums1[i] + nums2[j + 1], i, j + 1 });
//				visited.add(new Pair<Integer, Integer>(i, j + 1));
//			}
//		}
//
//		return ans;
//	}

}
