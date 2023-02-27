package leetcodeLL;

import java.util.HashMap;
import java.util.Map;

public class IntersectionofLL {

}

//Given the heads of two singly linked-lists headA and headB,
//return the node at which the two lists intersect. 
//		If the two linked lists have no intersection at all, return null.

 // Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode(){}
      ListNode(int x) {
          val = x;
          next = null;
      }
 }
 
 class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> map=new HashMap<>();
        ListNode curr=headA;
        int count=1;
        while(curr!=null){
            map.put(curr,count);
            count++;
            curr=curr.next;
        }
        ListNode temp=headB;
        int res=-1;
        
        while(temp!=null){
            if(map.containsKey(temp))return temp;
            temp=temp.next;
        }
        return curr;
    }
}