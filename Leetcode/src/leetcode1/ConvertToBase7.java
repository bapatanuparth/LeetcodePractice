package leetcode1;

public class ConvertToBase7 {

	 public String convertToBase7(int num) {
	        StringBuilder sb=new StringBuilder();
	        if(num==0)return "0";
	        boolean flag=false;
	        if(num<0)flag=true;
	        num=Math.abs(num);
	        while(num>0){
	            int quo=num/7;
	            sb.append(num%7);
	            num=quo;
	        }
	        if(flag)sb.append('-');
	        
	        return sb.reverse().toString();
	    }
}
