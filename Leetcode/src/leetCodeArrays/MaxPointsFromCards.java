package leetCodeArrays;

//There are several cards arranged in a row, and each card has an associated number of points. 
//The points are given in the integer array cardPoints.
//
//In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
//
//Your score is the sum of the points of the cards you have taken.
//
//Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
public class MaxPointsFromCards {

	//slidig window 
//	Let the sum of all points be total_pts. You need to remove a sub-array from cardPoints with length n - k.
	//Keep a window of size n - k over the array. The answer is max(answer, total_pts - sumOfCurrentWindow)
	public int maxScore(int[] arr, int k) {
	        int n=arr.length;
	        int totsum=0;
	        for(int i:arr){
	            totsum+=i;
	        }
	        int currsum=0;
	        int diff=n-k;
	        int i=0;
	        for(i=0;i<diff;i++){
	            currsum+=arr[i];
	        }
	        int answer=0;
	        answer=Math.max(answer,totsum-currsum);
	        int right, left=0;
	       
	        for(right=i-1;right<n-1;){
	           
	            right++;
	            currsum=currsum-arr[left];
	            currsum=currsum+arr[right];
	            left++;
	            answer=Math.max(answer,totsum-currsum);
	        }
	        
	        return answer;
	    }
}
