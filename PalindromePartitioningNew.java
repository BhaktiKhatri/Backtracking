package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * 131. Palindrome Partitioning
 * https://leetcode.com/problems/palindrome-partitioning/description/
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * Example: Input: "aab"; Output:
 * [
 *  ["aa","b"],
 *  ["a","a","b"]
 * ]
 * Explanation and Code from: @ShamanthNorway https://leetcode.com/problems/palindrome-partitioning/discuss/41963/Java:-Backtracking-solution.?page=2
 * Bloomberg
 * Medium
 */

public class PalindromePartitioningNew {

	public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        
        System.out.println("s: "+s);
        
        getResults(res, new ArrayList<String>(), s);
        return res;
    }
    
    public static void getResults(List<List<String>> res, List<String> list, String s) {
    	System.out.println("res: "+res+" list: "+list+" s: "+s);
    	
    	if(s.length() == 0) {
            res.add(new ArrayList<String>(list));            
            return;
        }
        
        System.out.println("res: "+res+" list: "+list+" s: "+s);
        
        int n = s.length();
        for(int i=0; i<n; i++) {
            System.out.println("i: "+i);
        	
            if(checkPalindrome(s, 0, i)) {
            	
            	System.out.println("i: "+i+" s.substring(0, i+1): "+s.substring(0, i+1)+" list: "+list);
            	
        		list.add(s.substring(0, i+1));
                getResults(res, list, s.substring(i+1));
                System.out.println("i: "+i+" s.substring(i+1): "+s.substring(i+1)+" list: "+list);
                
                list.remove(list.size() - 1);
                System.out.println("i: "+i+" list: "+list);
            }
        }
    }
    
    public static boolean checkPalindrome(String s, int i, int j) {
    	System.out.println("s: "+s+" i: "+i+" j: "+j);
        
    	while(i < j) {
            System.out.println("i: "+i+" j: "+j+" s.charAt(i): "+s.charAt(i)+" s.charAt(j): "+s.charAt(j));
    		
    		if(s.charAt(i) != s.charAt(j)) {
            	return false;
            }
            i++; 
            j--;
        }
        return true;
    }
	
	public static void main(String[] args) {
		String s = "aab";//"abac";
		System.out.println(partition(s));
	}

}