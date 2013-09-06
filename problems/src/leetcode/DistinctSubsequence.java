package problems.src.leetcode;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 *
 * User: chengyangwu
 * Date: 9/2/13
 * Time: 3:16 PM
 */
public class DistinctSubsequence {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (T.length() == 0) return 1;
        if (S.length() == 0) return 0;
        int[][] opt = new int[T.length() + 1][S.length() + 1];
        for (int i = 0; i <= T.length(); i ++) {
            opt[i][0] = 0;
        }

        for (int j = 0; j <= S.length(); j ++) {
            opt[0][j] = 1;
        }

        for (int i = 1; i <= T.length(); i ++) {
            for (int j = 1; j <= S.length(); j ++) {
                opt[i][j] = opt[i][j - 1] + ((S.charAt(j - 1) == T.charAt(i - 1)) ? opt[i - 1][j - 1] : 0);
            }
        }

        return opt[T.length()][S.length()];
    }

    public int numDistinct_second (String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (T.length() == 0) return 1;
        if (S.length() == 0) return 0;

        int[] opt = new int[S.length() + 1];
        for (int i = 0; i <= S.length(); i ++) {
            opt[i] = 1;
        }
        opt[0] = 0;
        int tmp = 1;
        for (int i = 1; i <= T.length(); i ++) {
            for (int j = 1; j <= S.length(); j ++) {
                int cur = tmp;
                tmp = opt[j];
                opt[j] = opt[j - 1] + (T.charAt(i - 1) == S.charAt(j - 1) ? cur : 0);
            }
            tmp = 0;
        }
        return opt[S.length()];
    }
}
