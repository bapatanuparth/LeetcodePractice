package leetCodeArrays;

import java.util.Arrays;

public class KRadiusSubArray {

	
	//efficient solution 
	//sliding window
	public int[] getAveragesEff(int[] nums, int k) {
        int windowSize = 2*k + 1;
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        if (nums.length < windowSize) {
            // array is too small - no k-radius average
            return res;
        }
        // init the first k-radius average
        long windowSum = 0;
        for (int i=0; i<windowSize; i++) {
            windowSum += nums[i];
        }
        res[k] = (int) (windowSum / windowSize);
        // i is the center of current window
        for (int i=k+1; i<nums.length-k; i++) {
            windowSum += nums[i+k] - nums[i-k-1];
            res[i] = (int) (windowSum / windowSize);
        }
        return res;
    }
	
	 public int[] getAverages(int[] nums, int k) {
	        int res[]=new int[nums.length];
	        System.out.println(nums.length);
	        if(nums.length<2*k+1){
	            for(int i=0;i<nums.length;i++){
	                res[i]=-1;
	            }
	            return res;
	        }
	        
	        int left=0;
	        long sum=0;
	        int i=0,right=i;
	        while(i!=k){
	            res[i]=-1;
	            sum+=nums[i];
	            i++;right++;
	        }
	        while(right<=i+k){
	            sum+=nums[right];
	            right++;
	        }
	        res[i]=(int)sum/(right-left);
	        while(right<=nums.length-1){
	            sum=sum-nums[left];
	            left++;
	            sum+=nums[right];
	            right++;
	            res[++i]=(int)sum/(right-left);
	           
	        }
	        while(i<nums.length-1){
	            res[++i]=-1;
	        }
	        return res;      
	    }
}
