package leetCodeArrays;
import java.util.*;
//You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.
//
//Return any such subsequence as an integer array of length k.
//
//A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

//Input: nums = [2,1,6,3], k = 2
//Output: [6,3]
public class SubsequenceWithMaxSum {

	//challenge here is to sort the array maintaining the relative order of last k elements
	//we cant put [3,4,5] in output if in input array 5 comes before 3
	  public int[] maxSubsequence(int[] nums, int k) {

	        //first heap sorts the array based on the element value
	        Queue<int[]> heap= new PriorityQueue<>((a,b)->b[0]-a[0]);
	        //second heap picks up the k elements from sorted heap1 and puts it on the ascending order of their index value
	        Queue<int[]> heap2= new PriorityQueue<>((a,b)->a[1]-b[1]);
	        
	        //create heap one, passing array of size 2, [value,index]
	        for(int i=0;i<nums.length;i++){
	            int [] temp = new int[2];
	            temp[0]=nums[i];
	            temp[1]=i;
	            heap.add(temp);
	        }
	        
	      //this for loop returns the k greatest elements from the array and we put it in other heap
	      //according to their index values in ascending order
	        for(int i=0;i<k;i++){
	            heap2.add(heap.poll());
	        }
	        
	        int [] res= new int[k];
	        int i=0;
	        while(!heap2.isEmpty()){
	          res[i]=heap2.poll()[0];
	            i++;
	       }
	          return res;

	    }
}
