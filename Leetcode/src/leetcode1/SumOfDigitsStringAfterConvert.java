package leetcode1;

//Convert: "zbax" -> "(26)(2)(1)(24)" -> "262124"-> 262124
//Transform #1: 262124 -> 2 + 6 + 2 + 1 + 2 + 4 -> 17
//Transform #2: 17 ->1 + 7 -> 8

public class SumOfDigitsStringAfterConvert {
	
	//slow approach, can be made better with different solution
	  public static int getLucky(String s, int k) {
	        StringBuilder sb=new StringBuilder();
	        for(int i=0;i<s.length();i++) {
	        	sb.append(s.charAt(i)-'a'+1);
	        }
	        System.out.println(sb.toString());
	        int sum=0;
	        while(k>=1) {
	        	sum=0;
	        	for(int i=0;i<sb.length();i++) {
		        	sum+=sb.charAt(i)-'0';
		        }
	        	k--;
	        	 System.out.println(sum);
	        	if(k==0)return sum;
	        	sb.replace(0, sb.length(), ""+sum);  
	        }
	        return sum;
	    }
	  
	  //fastest approach
	  public int getLucky2(String s, int k) {
	        int num=0;
	        for(int i=0;i<s.length();i++)
	        {
	            int a=s.charAt(i)-'a'+1; 
	            if(a>9)
	            {
	                while(a!=0)
	                {
	                    int rem=a%10;
	                    num+=rem;
	                    a=a/10;
	                }
	            }
	            else
	                num+=a;
	        }
	        int sum=num;
	        while(k!=1)
	        {
	            sum=0;
	            while(num!=0)
	            {
	                int rem=num%10;
	                sum+=rem;
	                num=num/10;
	            }
	            num=sum;
	            k--;
	        }
	        return sum;
	    }
	
	public static void main(String[] args) {
		char a='d';
		System.out.println(a-'a');
		getLucky("abcd", 2);
	}
}
