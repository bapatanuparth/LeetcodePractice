package leetcodeStrings;

import java.util.HashSet;
import java.util.Set;
//Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.
//
//For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
//If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.
//
//For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
//If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.
//
//For example, "m.y+name@email.com" will be forwarded to "my@email.com".
//It is possible to use both of these rules at the same time.
//
//Given an array of strings emails where we send one email to each emails[i], return the number of different addresses that actually receive mails.


//Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
//Output: 2

public class UniqueEMail {

	 public int numUniqueEmails(String[] emails) {
	        Set<String> set= new HashSet<>();
	        for(String s:emails){
	            StringBuilder sb= new StringBuilder();
	            for(int i=0;i<s.length();i++){
	                if(s.charAt(i)=='.')continue;
	                if(s.charAt(i)=='+'){
	                    
	                    sb.append(s.substring(s.indexOf("@")));
	                    break;
	                }
	                if(s.charAt(i)=='@')
	                {
	                    sb.append(s.substring(i));
	                    break;
	                }
	                sb.append(s.charAt(i));   
	            }
	           
	            set.add(sb.toString());
	        }
	        return set.size();
	    }
}
