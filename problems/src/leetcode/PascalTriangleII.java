package problems.src.leetcode;

import java.util.ArrayList;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 *
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * User: chengyangwu
 * Date: 8/31/13
 * Time: 1:21 PM
 */
public class PascalTriangleII {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer> ();

        int[] arr = new int[rowIndex + 1];
        arr[0] = 1;
        int pre = arr[0];
        for (int i = 1; i <= rowIndex; i ++) {
            for (int j = 1; j < i; j ++) {
                int tmp = arr[j];
                arr[j] = pre + arr[j];
                pre = tmp;
            }
            arr[i] = 1;
            pre = 1;
        }
        for (int i : arr) {
            result.add(i);
        }
        return result;
    }
}
