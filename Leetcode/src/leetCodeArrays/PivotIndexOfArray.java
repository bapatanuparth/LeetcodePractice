package leetCodeArrays;


//Given an array of integers nums, calculate the pivot index of this array.
//
//The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
//
//If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
//
//Return the leftmost pivot index. If no such index exists, return -1.
public class PivotIndexOfArray {

    public int pivotIndexEff(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
	
	//solution using extra prefix sum array
    
	 public int pivotIndex(int[] nums) {
	        int [] presum=new int[nums.length];
	        int sum=0;
	        for(int i=0;i<nums.length;i++){
	            sum+=nums[i];
	            presum[i]=sum;
	        }
	        int n=presum.length;
	        if(presum[n-1]-presum[0]==0)return 0;
	        for(int i=1;i<presum.length;i++){
	            if(presum[i-1]==presum[n-1]-presum[i])
	                return i;
	        }
	        if(presum[n-2]==0)return n-1;
	        return -1;
	    }
}
