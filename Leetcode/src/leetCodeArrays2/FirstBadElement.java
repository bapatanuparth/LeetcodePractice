package leetCodeArrays2;

//binary search

//You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
//
//Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
//
//You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

//Input: n = 5, bad = 4
//Output: 4

//we take bad as input but our function doesnt know which is bad. 
//isBadVersion API gives true for any val >= the passed input for bad
public class FirstBadElement {
	
	boolean isBadVersion(int val) {
		//returns internally if version is good or bad
		return true; //true is set as placeholder value here
	}

	 public int firstBadVersion(int n) {
	        if(n==1)return 1;

	        int mid;
	        int left=1, right=n;
	        int res=1;
	        while(left<=right){
	            mid=left+(right-left)/2;
	           
	            if(isBadVersion(mid)){
	                res=mid;
	                right=mid-1;
	            }
	            else{
	                left=mid+1;
	            }
	        }
	        return res;
	        
	    }
}
