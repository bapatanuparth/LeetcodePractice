package leetCodeArrays;
import java.util.*;

//Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
//
//You may assume the input array always has a valid answer.

//Input: nums = [1,5,1,1,6,4]
//Output: [1,6,1,5,1,4]
public class WiggleSort {

	public void wiggleSort(int[] nums) {
		//create a max heap
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        int index = nums.length/2;
        for(int i = 0;i < nums.length; i++){
            pq.add(nums[i]);
        }
        List<Integer>list1 = new ArrayList<>();
         List<Integer>list2 = new ArrayList<>();
         //store n/2 or n/2-1 elements in 1st list. this list will have the max elemnt and others descending
        while(index > 0){
            list1.add(pq.remove());
            index--;
        }
        //add remaining elements in decreasing order to list 2
         while(!pq.isEmpty()){
            list2.add(pq.remove());
        }
        int idx1 = 0, idx2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(i%2 == 0) nums[i] = list2.get(idx2++);
            else nums[i] = list1.get(idx1++);
        }
    }

}
