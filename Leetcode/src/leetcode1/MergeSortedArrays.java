package leetcode1;

public class MergeSortedArrays {
	    public void merge(int[] nums1, int m, int[] nums2, int n) {
	        int res[]=new int[nums1.length];
	        int i=0,j=0,k=0;
	        for(i=0;i<m;){
	            if(j>=n)break;
	            if(nums1[i]<=nums2[j]){
	                res[k]=nums1[i];
	                System.out.println(res[k]);
	                i++;k++;
	            }
	             else if(nums1[i]>nums2[j]){
	                res[k]=nums2[j];
	                System.out.println(res[k]);
	                j++;k++;
	            }
	        }
	        if(i==m){
	            while(j<n){
	                res[k]=nums2[j];
	                System.out.println(res[k]);
	                j++;k++;
	            }
	        }
	        if(j==n){
	            while(i<m){
	                res[k]=nums1[i];
	                System.out.println(res[k]);
	                i++;k++;
	            }
	        }
	        for(int x=0;x<res.length;x++){
	            nums1[x]=res[x];
	        }
	    }
	public static void main(String[] args) {
		
	}
}
