package leetcode;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 * @author chengyangwu
 *
 */
public class PalindromePartitionII {
	public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int[] opt = new int[s.length() + 1]; // opt[i]: The optimal number of cut from i to the end.
        boolean[][] isPalm = new boolean[s.length()][s.length()]; // isPalm[i][j]: substring of s from i to j is palindrome 
        
        for (int i = 0; i <= s.length(); i ++) {
            opt[i] = s.length() - i;
        }
        
        for (int i = s.length(); i >= 0; i --) {
            for (int j = i; j < s.length(); j ++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPalm[i + 1][j - 1])) {
                    isPalm[i][j] = true;
                    if (opt[j + 1] + 1 < opt[i]) {
                        opt[i] = opt[j + 1] + 1;
                    } 
                }
            }
        }
        
        return opt[0] - 1;
        
    }
}
