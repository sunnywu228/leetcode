package problems.src.leetcode;

import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * User: chengyangwu
 * Date: 8/29/13
 * Time: 5:24 PM
 */
public class PascalTriangle {

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0) return result;

        for (int i = 0; i < numRows; i ++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            result.add(cur);
        }

        for (int i = 1; i < numRows; i ++) {
            ArrayList<Integer> cur = result.get(i);
            ArrayList<Integer> prev = result.get(i - 1);
            for (int j = 1; j < i; j ++) {
                cur.add(prev.get(j) + prev.get(j - 1));
            }
            cur.add(1);
        }
        return result;
    }
}
