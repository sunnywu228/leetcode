package problems.src.leetcode;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 *
 * User: chengyangwu
 * Date: 9/12/13
 * Time: 2:13 PM
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0) return 0;
        if (target < A[0]) return 0;
        if (target > A[A.length - 1]) return A.length;

        int l = 0, h = A.length;
        while (l <= h) {
            int mid = (l+h)/2;
            if (A[mid] == target) return mid;
            else if (A[mid] < target) l = mid + 1;
            else h = mid - 1;
        }
        return l;
    }
}
