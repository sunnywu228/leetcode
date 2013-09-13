package problems.src.leetcode;

import java.util.Arrays;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * Below is one possible representation of s1 = "great":
 *       great
 *       /    \
 *      gr    eat
 *     / \    /  \
 *    g   r  e   at
 *               / \
 *              a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 *
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 *       rgeat
 *       /    \
 *      rg    eat
 *     / \    /  \
 *    r   g  e   at
 *               / \
 *              a   t
 * We say that "rgeat" is a scrambled string of "great".
 *
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 *       rgtae
 *       /    \
 *      rg    tae
 *     / \    /  \
 *    r   g  ta  e
 *          / \
 *         t   a
 * We say that "rgtae" is a scrambled string of "great".
 *
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 *
 * User: chengyangwu
 * Date: 9/9/13
 * Time: 10:39 PM
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1.equals(s2)) return true;
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }

        for (int i = 1; i < s1.length(); i ++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) return true;
            if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s1.length() - i))) return true;
        }

        return false;
    }

    public boolean isScramble_iterate(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1 == null || s1.equals(s2)) return true;
        int len = s1.length();
        boolean[][][] dp = new boolean[len][len][len+1];
        for (int i = 0; i < len; i ++) {
            for (int j = 0; j < len; j ++) {
                dp[i][j][0] = true;
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int i = len - 1; i >= 0; i --) {
            for (int j = len - 1; j >= 0; j --) {
                for (int k = 1; k <= len - Math.max(i, j); k ++) {
                    dp[i][j][k] = false;
                    if (s1.substring(i, i + k).equals(s2.substring(j, j + k))) dp[i][j][k] = true;
                    else {
                        for (int l = 1; l < k; l ++) {
                            if (dp[i][j][l] && dp[i+l][j+l][k-l] || dp[i][j+k-l][l] && dp[i+l][j][k-l]) {
                                dp[i][j][k] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return dp[0][0][len];
    }
}
