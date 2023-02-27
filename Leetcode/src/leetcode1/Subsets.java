package leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//find all possible subsets i.e. power set of all the numbers in the given array
public class Subsets {
	//Need to find a recursive solution..
	
	//very smart solution please revisit
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        //add empty list
        result.add(new ArrayList<>());
        if(nums==null || nums.length==0)
        	return result;
        int s=0;
        for(int n:nums) {
        	s=result.size();
        	for(int i=0;i<s;i++) {
        		//create new temporary list one by one, initialize with result
        		List<Integer> set=new ArrayList<>(result.get(i));
        		System.out.println(set);
        		//add new element to the previous list fetched
        		set.add(n);
        		System.out.println(set);
        		//add new list in result
        		result.add(set);
        		System.out.println(result);
        	}
        }
        return result;
    	
    }
	
	
	public static void subs(List<List<Integer>>alist,List<Integer>curr,int[] nums, int n) {
    	if(n==nums.length) {
    		System.out.println(curr);
    		return;
    	}
    	for(int i=n;i<nums.length;i++) {
    		curr.add(nums[i]);
    		System.out.println(curr);
        	subs(alist,curr,nums,n+1);	
        	curr.remove(curr.size()-1);
    	}
	}

//    public List<List<Integer>> subsets(int[] nums) {
//    	
//    }
	public static void main(String[] args) {
		//subsets(new int[] {2,3,4});
		List<List<Integer>> alist=new ArrayList<>();
		subs(alist,new ArrayList<>(),new int[] {2,3,4},0);
		}

	}
