package problems.src.leetcode;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 *
 * Note: The numbers can be arbitrarily large and are non-negative.
 *
 * User: chengyangwu
 * Date: 9/12/13
 * Time: 2:19 PM
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String res = "0";
        if (num1.equals("0") || num2.equals("0")) return res;
        String a = "", b = "";
        for (int i = num1.length() - 1; i >= 0; i --) a += num1.charAt(i);
        for (int i = num2.length() - 1; i >= 0; i --) b += num2.charAt(i);
        String prev = "0";
        String cur = "";
        for (int i = 0; i < a.length(); i ++) {
            int carry = 0;
            // multiply
            for (int j = 0; j < b.length(); j ++) {
                int tmp = (a.charAt(i) - '0') * (b.charAt(j) - '0') + carry;
                carry = tmp/10;
                cur = cur + (tmp%10);
            }
            if (carry != 0) cur = cur + carry;
            // pad zeros
            for (int k = 0; k < i; k ++) {
                cur = "0" + cur;
            }
            // add
            carry = 0;
            String tmp = "";
            for (int k = 0; k < Math.max(prev.length(), cur.length()); k ++) {
                int sum = (k < prev.length() ? prev.charAt(k) - '0' : 0) + (k < cur.length() ? cur.charAt(k) - '0' : 0) + carry;
                carry = sum / 10;
                tmp = tmp + (sum%10);
            }
            tmp = carry != 0 ? tmp + carry : tmp;
            prev = tmp;
            cur = "";
        }
        for (int i = 0; i < prev.length(); i ++) {
            cur = prev.charAt(i) + cur;
        }
        return cur;
    }
}
