package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 46. Permutations
 * https://leetcode.com/problems/permutations/description/
 * Given a collection of distinct numbers, return all possible permutations.
 * For example, [1,2,3] have the following permutations:
 * [
 *  [1,2,3],
 *  [1,3,2],
 *  [2,1,3],
 *  [2,3,1],
 *  [3,1,2],
 *  [3,2,1]
 * ]
 * Explanation and Code from: https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 * https://www.youtube.com/watch?v=KukNnoN-SoY
 * Medium
 * Microsoft, LinkedIn
 */

public class Permutations {

	//Watch: https://www.youtube.com/watch?v=KukNnoN-SoY
	public static List<List<Integer>> permute(int[] nums) {
		   List<List<Integer>> list = new ArrayList<>();
		   // Arrays.sort(nums); // not necessary
		   
		   System.out.println("nums: "+Arrays.toString(nums));
		   backtrack(list, new ArrayList<>(), nums);
		   
		   return list;
	}

	public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums) {
		System.out.println("list: "+list+" tempList: "+tempList+" nums: "+Arrays.toString(nums));
		
		   if(tempList.size() == nums.length) {
		      list.add(new ArrayList<>(tempList));
		   } 
		   else {
		      for(int i=0; i<nums.length; i++) { 
		    	 System.out.println("i: "+i+" nums[i]: "+nums[i]+" tempList: "+tempList);
		         if(tempList.contains(nums[i])) {
		         	 continue; 						// element already exists, skip
		         }
		         tempList.add(nums[i]);
		         System.out.println("tempList before backtract: "+tempList);
		         backtrack(list, tempList, nums);
		         System.out.println("tempList after backtract: "+tempList+" i: "+i);
		         tempList.remove(tempList.size() - 1);
		      }
		   }
		} 
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(permute(nums));
	}

}
