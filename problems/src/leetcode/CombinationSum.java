package problems.src.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 ? a2 ? � ? ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 *
 * User: chengyangwu
 * Date: 9/12/13
 * Time: 2:16 PM
 */
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        solve (0, candidates, target, res, new ArrayList<Integer>());
        return res;
    }

    public void solve (int start, int[] candidates, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur) {
        if (target == 0) {
            res.add(cur);
            return;
        }
        for (int i = start; i < candidates.length; i ++) {
            if (candidates[i] <= target) {
                ArrayList<Integer> next = new ArrayList<Integer>(cur);
                next.add(candidates[i]);
                solve(i, candidates, target - candidates[i], res, next);
            }
        }
    }
}
