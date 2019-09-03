package Backtracking;import Array.MinCostClimbingStairs;

/*
 * 132. Palindrome Partitioning II
 * https://leetcode.com/problems/palindrome-partitioning-ii/description/
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * Example: Input: "aab"; Output: 1; Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * Explanation from: https://www.youtube.com/watch?v=WPr1jDh3bUQ 
 * https://www.youtube.com/watch?v=lDYIvtBVmgo&t=1s
 * Code from: https://github.com/IDeserve/learn/blob/master/PalindromePartitionMinCut.java
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/PalindromePartition.java
 * >Medium
 * Microsoft
 */

public class PalindromePartitioning2 {
	
	public static int minCut(String s) {
		  int n = s.length();
		  boolean palindrome[][] = new boolean[n][n]; //boolean table
		  
		  System.out.println("s: "+s+" n: "+n);
		  
		  //Trivial case: single letter palindromes
		  for(int i=0; i<n; i++) {
			  palindrome[i][i] = true;
		  }
		  
		  //Finding palindromes of two characters.
		  for(int i = 0; i < n-1; i++) {
		    if(s.charAt(i) == s.charAt(i+1)) {
		      palindrome[i][i+1] = true;
		    }
		  }
		  
		  //Finding palindromes of length 3 to n
		  for(int curr_len=3; curr_len<=n; curr_len++) {
			  for(int i=0; i<n-curr_len+1; i++) {
			      int j = i+curr_len-1;
			      
			      if(s.charAt(i) == s.charAt(j) //1. The first and last characters should match 
			    	  && palindrome[i+1][j-1]) //2. Rest of the substring should be a palindrome
				      {
				    	palindrome[i][j] = true; 
				      }
			   }
		  }
		  
		  int[] cuts = new int[n];
		  for(int i=0; i<n; i++) {
			  int temp = Integer.MAX_VALUE;
			  
			  System.out.println("i: "+i+" palindrome[0][i]: "+palindrome[0][i]+" temp: "+temp);
			  
			  if(palindrome[0][i]) {	//if substring[0][i] is a palindrome then min cut for it is 0
				  cuts[i] = 0;
			  }
			  else						
			  {
				  for(int j=0; j<i; j++)
				  {
					  	System.out.println("j: "+j+" i: "+i+" palindrome[j+1][i]: "+palindrome[j+1][i]+" temp: "+temp+" cuts[j]: "+cuts[j]);
						if((palindrome[j+1][i]) && temp > cuts[j] + 1) 
						{
							temp = cuts[j] + 1;
						}
				  }
				  System.out.println("i: "+i+" cuts[i]: "+cuts[i]+" temp: "+temp);
				  cuts[i] = temp;
			  }			  
		  }
		  return cuts[n-1];
    }

	public static void main(String[] args) {
		String str = "banana";
		System.out.println(minCut(str));
	}

}
