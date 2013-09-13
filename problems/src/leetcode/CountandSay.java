package problems.src.leetcode;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 *
 * User: chengyangwu
 * Date: 9/12/13
 * Time: 2:15 PM
 */
public class CountandSay {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 1) return "1";

        String prev = "1";
        String cur = "";
        while (--n > 0) {
            int count = 0;
            char preChar = '0';
            for (int i = 0; i < prev.length(); i ++) {
                if (prev.charAt(i) == preChar) count ++;
                else {
                    cur += count != 0 ? count + "" + preChar : "";
                    preChar = prev.charAt(i);
                    count = 1;
                }
            }
            cur += count + "" + preChar;
            prev = cur;
            cur = "";
        }
        return prev;
    }
}
