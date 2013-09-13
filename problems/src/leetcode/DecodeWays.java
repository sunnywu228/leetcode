package problems.src.leetcode;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *
 * The number of ways decoding "12" is 2.
 *
 * User: chengyangwu
 * Date: 9/9/13
 * Time: 10:35 PM
 */
public class DecodeWays {
    /**
     * Recursive way cannot pass the larger sets
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;

        int num = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
        int fix = 0;
        if (s.length() == 2) fix = 1;

        return numDecodings(s.substring(1)) + (num <= 26 ? fix + numDecodings(s.substring(2)) : 0);
    }

    public int numDecodings_pass(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;

        int[] opt = new int[s.length() + 1];
        opt[0] = 1;
        opt[1] = 1;

        for (int i = 1; i < s.length(); i ++) {
            opt[i + 1] = 0;
            if (s.charAt(i - 1) != '0') {
                opt[i + 1] += ((s.charAt(i - 1) - '0')*10 + (s.charAt(i) - '0') <= 26) ? opt[i - 1] : 0;
            }
            opt[i + 1] += s.charAt(i) == '0' ? 0 : opt[i];
        }

        return opt[s.length()];
    }
}
