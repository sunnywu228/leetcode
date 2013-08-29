package leetcode;

import java.util.ArrayList;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * <p/>
 * User: chengyangwu
 * Date: 8/29/13
 * Time: 5:20 PM
 */
public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int rows = triangle.size();
        if (rows == 0) return 0;
        
        int[] curMin = new int[triangle.get(rows - 1).size()];
        // initialization
        for (int i = 0; i < triangle.get(rows - 1).size(); i ++) {
            curMin[i] = triangle.get(rows - 1).get(i);
        }
        
        for (int i = rows - 2; i >= 0; i --) {
            ArrayList<Integer> curRow = triangle.get(i);
            for (int j = 0; j < curRow.size(); j ++) {
                curMin[j] = Math.min(curMin[j], curMin[j + 1]) + curRow.get(j);
            }
        }
        
        return curMin[0];
    }
}
