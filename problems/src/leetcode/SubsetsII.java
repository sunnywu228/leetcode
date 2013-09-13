package problems.src.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 *
 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ]
 *
 * User: chengyangwu
 * Date: 9/9/13
 * Time: 10:33 PM
 */
public class SubsetsII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        subsetsHelper(num, result, 0, new ArrayList<Integer> ());
        return result;
    }

    public void subsetsHelper (int[] num, ArrayList<ArrayList<Integer>> result, int i, ArrayList<Integer> cur) {
        if (i == num.length) {
            for (ArrayList<Integer> res : result) {
                if (res.equals(cur)) return;
            }
            result.add(cur);
        } else {
            subsetsHelper(num, result, i + 1, new ArrayList<Integer>(cur));
            cur.add(num[i]);
            subsetsHelper(num, result, i + 1, cur);
        }
    }
}
