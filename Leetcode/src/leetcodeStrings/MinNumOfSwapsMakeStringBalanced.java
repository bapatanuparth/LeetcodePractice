package leetcodeStrings;

//You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets '[' and
//n / 2 closing brackets ']'.
//
//A string is called balanced if and only if:
//
//It is the empty string, or
//It can be written as AB, where both A and B are balanced strings, or
//It can be written as [C], where C is a balanced string.
//You may swap the brackets at any two indices any number of times.
//
//Return the minimum number of swaps to make s balanced.
public class MinNumOfSwapsMakeStringBalanced {

	//count closing and opening paranthese
	//if at any point closing paranthese > opening paranthesis, make a swap and count one open++
	//as num of closing == num of opening, we can guarantee that later there will come one opening paranthesis
	public int minSwaps(String s) {
        int open=0,close=0;
        int swaps=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==']')close++;
            else open++;
            if(close>open){
                swaps++;
                close--;
                open++;
            }
        }
        return swaps;
    }
}
