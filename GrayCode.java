package Backtracking;

import java.util.LinkedList;
import java.util.List;

/*
 * 89. Gray Code
 * https://leetcode.com/problems/gray-code/description/
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note: For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * Code from: @jinrf https://leetcode.com/problems/gray-code/discuss/29881/An-accepted-three-line-solution-in-JAVA
 * Explanation from: @wanghp18 https://leetcode.com/problems/gray-code/discuss/29881/An-accepted-three-line-solution-in-JAVA
 * Amazon
 * Medium
 */

public class GrayCode {

	//The idea is simple. G(i) = i^ (i/2)
	//Adding one to a number results in flipping all the bits from the rightmost zero bit to the end, e.g. 110011 + 1 = 110100
	public static List<Integer> grayCode(int n) {
	    List<Integer> result = new LinkedList<>();
	    
	    System.out.println("n: "+n);
	    
	    for(int i=0; i < 1 << n; i++) {
	    	System.out.println("i: "+i+" i >> 1: "+(i >> 1)+" (i ^ i >> 1): "+(i ^ i >> 1));
	    	
	    	result.add(i ^ i >> 1);
	    	System.out.println("result: "+result);
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		int n = 2;
		System.out.println(grayCode(n));
	}

}
