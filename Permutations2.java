package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 47. Permutations II
 * https://leetcode.com/problems/permutations-ii/description/
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * Example: Input: [1,1,2]
 * Output:
 * 	[
 * 	  [1,1,2],
 * 	  [1,2,1],
 * 	  [2,1,1]
 * 	]
 * Explanation and Code from: @UpTheHell https://leetcode.com/problems/permutations-ii/discuss/18594/Really-easy-Java-solution-much-easier-than-the-solutions-with-very-high-vote
 * Microsoft, LinkedIn
 * Medium
 */

public class Permutations2 {
	
	/*
	 * Use an extra boolean array " boolean[] used" to indicate whether the value is added to list.
	 * Sort the array "int[] nums" to make sure we can skip the same value.
	 * when a number has the same value with its previous, we can use this number only if his previous is used
	 */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) { 
        	return res;
        }
        
        System.out.println("nums: "+Arrays.toString(nums));
        
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        
        Arrays.sort(nums);
        System.out.println("nums: "+Arrays.toString(nums));
        
        dfs(nums, used, list, res);
        
        return res;
    }

    public static void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        System.out.println("used: "+Arrays.toString(used)+" list: "+list+" res: "+res);
        
        for(int i=0; i<nums.length; i++) {
            System.out.println("i: "+i+" used[i]: "+used[i]);
        	
        	if(used[i]) {
            	continue;
            }
        	
        	if(i > 0) {
        		System.out.println("i: "+i+" nums[i]: "+nums[i]+" nums[i-1]: "+nums[i-1]+" used[i-1]: "+used[i-1]);
        	}
            
            if(i > 0 && nums[i-1] == nums[i] && !used[i-1]) { 
            	continue;
            }
            
            used[i] = true;
            list.add(nums[i]);
            
            dfs(nums,used,list,res);
            
            used[i] = false;
            list.remove(list.size()-1);
        }
    }

    //Refer this:@chrislzm https://leetcode.com/problems/permutations-ii/discuss/18594/Really-easy-Java-solution-much-easier-than-the-solutions-with-very-high-vote
    public static List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Map<Integer,Integer> map = new HashMap<>();
        
        if(nums == null || nums.length == 0) 
        	return results;
        
        System.out.println("nums: "+Arrays.toString(nums));
        
        for(int n: nums) {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        System.out.println("map: "+map);
        
        permuteUniqueHelper(map, nums.length, new Integer[nums.length], 0, results);
        return results;
    }
    
    private static void permuteUniqueHelper(Map<Integer,Integer> map, int l, Integer[] p, int i, List<List<Integer>> r) {
    	System.out.println("map: "+map+" l: "+l+" p: "+Arrays.toString(p)+" i: "+i+" r: "+r);
        
    	if(i == l) {
            r.add(Arrays.asList(Arrays.copyOf(p,l)));
            return;
        }
        
        for(int key: map.keySet()) {
        	System.out.println("key: "+key+" map.get(key): "+map.get(key));
            
        	if(map.get(key) > 0) {
            	map.put(key,map.get(key)-1);
                p[i] = key;
                System.out.println("i: "+i+" p[i]: "+p[i]+" map: "+map);

                permuteUniqueHelper(map,l,p,i+1,r);
                System.out.println("return i: "+i+" p[i]: "+p[i]+" map: "+map);
                
                map.put(key,map.get(key) + 1);
            }
        }
    }
    
	public static void main(String[] args) {
		int[] nums = {1,1,2};
		System.out.println(permuteUnique1(nums));
	}
}