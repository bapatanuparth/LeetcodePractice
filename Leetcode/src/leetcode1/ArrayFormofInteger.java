package leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArrayFormofInteger {

	
	//corner case where len(k) > len(arr) needs to be handled otherwise working 
    public static List<Integer> addToArrayForm(int[] num, int k) {
    	List<Integer> res=new ArrayList<>();
    	int len=num.length-1;
    	int carry=0;
    	while(k/10!=0 || k%10!=0) {
    		if(len<0)break;
    		System.out.print(k%10);
    		int sum=k%10+num[len]+carry;
    		num[len--]=(sum>10?sum%10:sum);
    		carry=sum>=10?1:0;
    		k=k/10;
    	}
    	if(len<0)res.add(k);
    	if(carry!=0 && len>=0)num[len]=num[len]+carry;
    	else if(carry!=0 && len<0)res.add(1);
//    	int sum=k+num[len]+carry;
//    	num[len]=sum
    	for(int i=0;i<num.length;i++)
    		System.out.println(num[i]);
    	return res;
        
    }

    //another way
    //gives issue on very very long arrays
    public static List<Integer> addToArrayForm2(int[] num, int k) {
    	List<Integer> res=new ArrayList<>();
    	int len=num.length-1;
    	int val=0;
    	for(int i=0;i<num.length;i++) {
    		val=(int) (val+num[i]*Math.pow(10, len-i));
    	}
    	System.out.println(val);
    	int sum=val+k;
    	String str="";
        while(sum/10!=0 || sum%10!=0) {
        	str=str+sum%10;
        	sum=sum/10;
    	}
        for(int i=str.length()-1;i>=0;i--) {
        	res.add(str.charAt(i)-'0');
        }
        System.out.println(res);
    	return res;
        
    }
    
    //Final solution
    public static List<Integer> addToArrayForm3(int[] num, int k) {
    	List<Integer> res=new ArrayList<>();
    	int len=num.length-1;
    	int carry=0;
    	while(len>=0 || k>0) {
    		int sum=carry;
    		if(len>=0)
    			//take last number in sum
    			sum=sum+num[len];
    		if(k>0)
    			//add it with the last digit of k
    			sum=sum+k%10;
    		//add only the last digit in result, and take remaining digits in carry
    		res.add(sum%10);
    		carry=sum/10;
    		len--;
    		k=k/10;
    	}
    	if(carry==1)res.add(carry);
        
    	Collections.reverse(res);
    	return res;
        
    }
    
    public static void main(String[] args) {
		addToArrayForm(new int[] {9,9,9,9,9,9,9,9,9,9},1);
	}
}
