package problems.src.leetcode;

import java.util.ArrayList;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * For example:
 * Given "25525511135",
 *
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 * User: chengyangwu
 * Date: 9/9/13
 * Time: 10:31 PM
 */
public class RestoreIPAddresses {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String> ();
        restore(result, s, 0, 1, "");
        return result;
    }

    private void restore(ArrayList<String> result, String s, int startInd, int curPart, String curIP) {
        if (s.length() - startInd > 3 * (5 - curPart)) return;
        if (s.length() - startInd < 5 - curPart) return;

        if (startInd == s.length() && curPart == 5) {
            result.add(curIP.substring(0, curIP.length() - 1));
            return;
        }

        int num = 0;
        for (int i = startInd; i < startInd + 3 && i < s.length(); i ++) {
            num = 10 * num + (s.charAt(i) - '0');
            if (num <= 255) {
                restore(result, s, i + 1, curPart + 1, curIP + s.substring(startInd, i + 1) + ".");
            }
            if (num == 0) break;
        }
    }
}
