package leetCodeArrays;

//Given a 0-indexed integer array nums, return the number of distinct quadruplets (a, b, c, d) such that:
//
//nums[a] + nums[b] + nums[c] == nums[d], and
//a < b < c < d
public class CountQuadruplets {

	 public int countQuadruplets(int[] nums) {
	        int n=nums.length;
	        if(n<4)return 0;
	        int count=0;
	        for(int a=0;a<n-3;a++){
	            
	            for(int b=a+1;b<n-2;b++){
	                
	                for(int c=b+1;c<n-1;c++){
	                    
	                    for(int d=c+1;d<n;d++){
	                    
	                        if((nums[a]+nums[b]+nums[c])==nums[d])count++;
	                         
	                    }
	                }
	            }
	        }
	        return count;
	    }
}
