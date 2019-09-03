package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 212. Word Search II
 * https://leetcode.com/problems/word-search-ii/description/
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 * Example: Input: words = ["oath","pea","eat","rain"] and board =
 * 	[
 * 	  ['o','a','a','n'],
 * 	  ['e','t','a','e'],
 * 	  ['i','h','k','r'],
 * 	  ['i','f','l','v']
 * 	]
 * Output: ["eat","oath"]
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * Explanation and Code from: @yavinci https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
 * Google, Microsoft, Airbnb 
 * >Medium
 */

public class WordSearch2 {
	
	public static class TrieNode {
	    TrieNode[] next = new TrieNode[26];
	    String word;
	}
	
	public static TrieNode buildTrie(String[] words) {
	    TrieNode root = new TrieNode();
	    System.out.println("words: "+Arrays.toString(words));
	    
	    for(String w: words) {
	    	System.out.println("w: "+w);
	        TrieNode p = root;
	        
	        for(char c: w.toCharArray()) {
	            System.out.println("c: "+c);
	        	
	        	int i = c - 'a';
	        	System.out.println("i: "+i+" p.next[i]: "+p.next[i]);
	        	
	            if(p.next[i] == null) {
	            	p.next[i] = new TrieNode();
	            }
	            p = p.next[i];
	       }
	       System.out.println("w: "+w+" p.word: "+p.word); 
	       p.word = w;
	    }
	    
	    return root;
	}

	public static List<String> findWords(char[][] board, String[] words) {
	    List<String> res = new ArrayList<>();
	    TrieNode root = buildTrie(words);
	    
	    System.out.println("words: "+Arrays.toString(words));
	    
	    for(int i=0; i<board.length; i++) {
	        for(int j=0; j<board[0].length; j++) {
	        	System.out.println("i: "+i+" j: "+j+" res: "+res);
	        	dfs(board, i, j, root, res);
	        }
	    }
	    
	    System.out.println("res: "+res);
	    
	    return res;
	}

	public static void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
		System.out.println("i: "+i+" j: "+j+" res: "+res);
		
		char c = board[i][j];
		System.out.println("c: "+c);
	    
	    if(c == '#' || p.next[c - 'a'] == null) { 
	    	return;
	    }
	    
	    p = p.next[c - 'a'];
	    System.out.println("p: "+p);
	    
	    if(p.word != null) {   // found one
	    	System.out.println("p.word: "+p.word);
	        res.add(p.word);
	        p.word = null;     // de-duplicate
	    }

	    board[i][j] = '#';
	    
	    if(i > 0) { 
	    	dfs(board, i - 1, j ,p, res);	//up
	    }
	    
	    if(j > 0) { 
	    	dfs(board, i, j - 1, p, res);	//left
	    }
	    
	    if(i < board.length - 1) { 
	    	dfs(board, i + 1, j, p, res);	//down
	    }
	    
	    if(j < board[0].length - 1) { 		
	    	dfs(board, i, j + 1, p, res);	//right
	    }
	    
	    board[i][j] = c;
	}
		
	public static void main(String[] args) {
		String[] words = {"oath","pea","eat","rain"};
		
		char[][] board = {
							{'o','a','a','n'},
							{'e','t','a','e'},
							{'i','h','k','r'},
							{'i','f','l','v'}
						};
		
		System.out.println(findWords(board, words));
	}
}