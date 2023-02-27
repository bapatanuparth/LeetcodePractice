package leetcode1;

// 0==red, 1==blue, 2==green
//array will have these colors in random order
// bring all the same colors together in clusters
public class SortColors {

	    public void sortColors(int[] nums) {
	        int zeros=0, ones=0,twos=0;
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]==0)
	                zeros++;
	            else if(nums[i]==1)
	                ones++;
	            else if (nums[i]==2)
	                twos++;
	        }
	        int i;
	        for(i=0;i<zeros;i++){
	            nums[i]=0;
	        }
	        for(int j=0;j<ones;j++){
	            nums[i]=1;
	            i++;
	        }
	        for(int j=0;j<twos;j++){
	            nums[i]=2;
	            i++;
	        }
	    }
	}

