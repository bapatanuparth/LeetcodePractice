package leetcodeLL;

//Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.
//
//The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.
//
//The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.
//
//Return an array of the k parts.

public class SplitLinkedListParts {

	class Solution {
		public ListNode[] splitListToParts(ListNode root, int k) {
			ListNode cur = root;
			int N = 0;
			while (cur != null) {
				cur = cur.next;
				N++;
			}

			int width = N / k, rem = N % k;

			ListNode[] ans = new ListNode[k];
			cur = root;
			for (int i = 0; i < k; ++i) {
				ListNode head = cur;
				for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; ++j) {
					if (cur != null)
						cur = cur.next;
				}
				if (cur != null) {
					ListNode prev = cur;
					cur = cur.next;
					prev.next = null;
				}
				ans[i] = head;
			}
			return ans;
		}
	}

}
