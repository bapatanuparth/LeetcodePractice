package leetcode1;

//Given an integer array nums sorted in non-decreasing order, 
//return an array of the squares of each number sorted in non-decreasing order.

public class SquareofArraySorted {
	
	//intuitive approach to solve a trivial question in O(n)
	int [] sortedSquares(int [] nums) {
		int left=0,right=nums.length-1;
		int pos=right;
		int []ans=new int[nums.length];
		
		while(left<=right) {
			if(Math.abs(nums[left])>Math.abs(nums[right])) {
				ans[pos]=nums[left]*nums[left];
				left++;
			}
			else {
				ans[pos]=nums[right]*nums[right];
				right--;
			}
			pos--;
		}
		return ans;
	}
}
