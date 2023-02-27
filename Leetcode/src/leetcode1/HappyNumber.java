package leetcode1;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	
	//slow solution can be optimized
    public static boolean isHappy(int n) {
    	Set<Integer> set=new HashSet<>();
		int sum=0;
		int num=n;
		while(true) {
			sum=0;
			while(num!=0) {
				int temp=num%10;
				sum+=temp*temp;
				num=num/10;
			}
			System.out.println(sum);
			if(sum==1)return true;
			if(set.contains(sum))return false;
			set.add(sum);
			num=sum;
		}
    }
    
    //optimized solution using 2 pointers
    public boolean isHappy2(int n) {
        int slow=n;
        int fast=n;
        do{
            slow=square(slow);
            fast=square(square(fast));
        }while(slow!=fast);
        if(slow==1)
            return true;
        return false;
        
    }
    public int square(int num)
    {
        int ans=0;
        while(num>0)
        {
            int rem=num%10;
            ans+=rem*rem;
            num/=10;
        }
        return ans;
    }
	
	public static void main(String[] args) {
		
	}

}
