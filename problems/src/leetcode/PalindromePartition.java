package leetcode;

import java.util.ArrayList;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * 
 * @author chengyangwu
 *
 */
public class PalindromePartition {
	public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() == 0) return new ArrayList<ArrayList<String>>();
        
        boolean[][] isPalm = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i ++) {
            isPalm[i][i] = true;
        }
        
        for (int i = s.length() - 2; i >= 0; i --) {
            isPalm[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            for (int j = i + 2; j < s.length(); j ++) {
                isPalm[i][j] = (s.charAt(i) == s.charAt(j)) && (isPalm[i + 1][j - 1]);
            }
        }
        
        return partitionHelper(s, 0, isPalm);
    }
    
    public ArrayList<ArrayList<String>> partitionHelper(String s, int start, boolean isPalm[][]) {
        // backtrack from the bottom with a new ArrayList of String
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>> ();
        if (s.length() == start) {
            result.add(new ArrayList<String> ());
            return result;
        }
        
        // back tracking
        for (int i = start; i < s.length(); i ++) {
            if (isPalm[start][i]) {
                for (ArrayList<String> palm : partitionHelper(s, i + 1, isPalm)) {
                    palm.add(0, s.substring(start, i + 1));
                    result.add(palm);
                }
            }
        }
        
        return result;
    }
}
