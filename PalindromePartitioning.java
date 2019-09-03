package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        
        System.out.println("s: "+s);
        
        dfs(s,0,list,res);
        return res;
     }
     
     public static void dfs(String s, int pos, List<String> list, List<List<String>> res) {
    	 System.out.println("s: "+s+" pos: "+pos+" list: "+list+" res: "+res);
    	 
    	 if(pos == s.length()) { 
        	 res.add(new ArrayList<String>(list));
         }
         else {
             for(int i=pos; i<s.length(); i++) {
            	 System.out.println("i: "+i+" pos: "+pos+" list: "+list);
                 
            	 if(isPal(s,pos,i)) {
                	 System.out.println("s.substring(pos,i+1): "+s.substring(pos,i+1));
                     
                	 list.add(s.substring(pos,i+1));
                	 System.out.println("i: "+i+" pos: "+pos+" list: "+list);
                 
                     dfs(s, i+1, list, res);
                     System.out.println("i: "+i+" pos: "+pos+" list: "+list);
                     
                     list.remove(list.size() - 1);
                     System.out.println("i: "+i+" pos: "+pos+" list: "+list);
                 }
             }
         }
     }
     
     public static boolean isPal(String s, int low, int high) {
         System.out.println("s: "+s+" low: "+low+" high: "+high);
    	 
    	 while(low < high) {
    		 System.out.println("s.charAt(low): "+s.charAt(low)+" s.charAt(high): "+s.charAt(high));
        	 if(s.charAt(low++) != s.charAt(high--)) {
        		 return false;
        	 }
         }
         return true;
     }
	
	public static void main(String[] args) {
		String s = "aab";
		System.out.println(partition(s));
	}

}
