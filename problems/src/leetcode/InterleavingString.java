package problems.src.leetcode;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 *
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 *
 * User: chengyangwu
 * Date: 9/9/13
 * Time: 3:56 PM
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s1.length() + s2.length() != s3.length()) return false;

        boolean[][] opt = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i ++) {
            for (int j = 0; j <= s2.length(); j ++) {
                opt[i][j] = false;
                if (i == 0 && j == 0) opt[i][j] = true;
                else if (j == 0) {
                    opt[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && opt[i - 1][0];
                } else if (i == 0) {
                    opt[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) && opt[0][j - 1];
                } else {
                    if (s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        opt[i][j] = opt[i - 1][j] || opt[i][j];
                    if (s2.charAt(j - 1) == s3.charAt(i + j - 1))
                        opt[i][j] = opt[i][j - 1] || opt[i][j];
                }
            }
        }
        return opt[s1.length()][s2.length()];
    }

    public boolean isInterleave_method2(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s1.length() + s2.length() != s3.length()) return false;

        boolean[] pre = new boolean[s2.length() + 1];
        boolean[] cur = new boolean[s2.length() + 1];

        for (int i = 0; i <= s1.length(); i ++) {
            for (int j = 0; j <= s2.length(); j ++) {
                if (i == 0 && j == 0) cur[j] = true;
                else if (i == 0) cur[j] = s2.charAt(j - 1) == s3.charAt(i + j - 1) && cur[j - 1];
                else if (j == 0) cur[j] = s1.charAt(i - 1) == s3.charAt(i + j - 1) && pre[j];
                else {
                    if (s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        cur[j] = pre[j] || cur[j];
                    if (s2.charAt(j - 1) == s3.charAt(i + j - 1))
                        cur[j] = cur[j - 1] || cur[j];
                }
            }
            pre = cur;
            cur = new boolean[s2.length() + 1];
        }

        return pre[s2.length()];

    }
}
