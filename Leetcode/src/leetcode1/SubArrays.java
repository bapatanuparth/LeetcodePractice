package leetcode1;

import java.util.ArrayList;
import java.util.List;

//Given an integer array nums of unique elements,
//return all possible subarrays.
public class SubArrays {
	static void subArr(List<List<Integer>> alist, int start, int end, int []arr) {
		alist.add(new ArrayList<>());
		if(end==arr.length)
			return;
		subArr(alist,start,end+1,arr);
		List<Integer>temp=new ArrayList<>();
		for(int i=start;i<=end;i++) {
			temp.add(arr[i]);
		}
		System.out.println(temp);
		alist.add(temp);
	}
	
    public static List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> op=new ArrayList<List<Integer>>();
    	for(int i=0;i<nums.length;i++) {
    		subArr(op,i,i,nums);
    	}
    	return op;
    }
    
    public static void main(String[] args) {
		subsets(new int[] {2,4,7});
	}
    
}
