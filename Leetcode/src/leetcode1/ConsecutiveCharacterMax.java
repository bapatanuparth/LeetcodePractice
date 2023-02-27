package leetcode1;

public class ConsecutiveCharacterMax {
	
	   public int maxPowerEff(String s) {
	        int res=0;
	        int i=0;
	        while(i<s.length()){
	            int count=0;
	            int j=i;
	            while(i<s.length() && s.charAt(i)==s.charAt(j)){
	                count++;
	                i++;
	            }
	            res=Math.max(res,count);
	        }
	        return res;
	    }
	
	
	 public int maxPower(String s) {
	        int res=0;
	        if(s.length()==1)return 1;
	        int count=1;
	        for(int i=1;i<s.length();i++){
	            if(s.charAt(i-1)==s.charAt(i)){
	                count++;
	            }
	            else {
	                res=Math.max(res,count);
	                count =1;
	            }
	            if(i==s.length()-1){
	                res=Math.max(res,count);
	            }
	            
	            
	        }
	        return res;
	    }
}
