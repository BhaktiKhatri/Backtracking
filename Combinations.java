package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * 77. Combinations
 * https://leetcode.com/problems/combinations/description/
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * Example: Input: n = 4, k = 2
 * Output:
 *	[
 *	  [2,4],
 *	  [3,4],
 *	  [2,3],
 *	  [1,2],
 *	  [1,3],
 *	  [1,4],
 *	]
 * Explanation and Code from: @fabrizio3 https://leetcode.com/problems/combinations/discuss/27002/Backtracking-Solution-Java
 * Medium
 */

public class Combinations {

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		
		System.out.println("n: "+n+" k: "+k);
		
		combine(combs, new ArrayList<Integer>(), 1, n, k);
		return combs;
	}
	
	public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
		System.out.println("combs: "+combs+" comb: "+comb+" start: "+start+" n: "+n+" k: "+k);
		
		if(k == 0) {
			combs.add(new ArrayList<Integer>(comb));
			return;
		}
		
		for(int i=start; i<=n; i++) {
			System.out.println("i: "+i+" comb: "+comb);
			
			comb.add(i);
			combine(combs, comb, i+1, n, k-1);
			System.out.println("i: "+i+" comb: "+comb);

			comb.remove(comb.size()-1);
			System.out.println("i: "+i+" comb: "+comb);
		}
	}
	
	public static void main(String[] args) {
		int n = 4; 
		int k = 2;
		
		System.out.println(combine(n, k));
	}

}
