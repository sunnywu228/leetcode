package problems.src.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 ? a2 ? � ? ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 *
 * User: chengyangwu
 * Date: 9/12/13
 * Time: 2:17 PM
 */
public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
        if (num == null || num.length == 0) return res;

        Arrays.sort(num);
        solve (0, num, target, res, new ArrayList<Integer> ());
        return res;
    }

    public void solve (int start, int[] num, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur) {
        if (target == 0) {
            for (ArrayList<Integer> it : res) {
                if (it.equals(cur)) return;
            }
            res.add(cur);
            return;
        }

        for (int i = start; i < num.length; i ++) {
            if (num[i] <= target) {
                ArrayList<Integer> next = new ArrayList<Integer>(cur);
                next.add(num[i]);
                solve(i + 1, num, target - num[i], res, next);
            }
        }
    }
}
