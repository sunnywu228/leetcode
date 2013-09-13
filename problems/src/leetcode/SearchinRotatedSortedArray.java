package problems.src.leetcode;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * User: chengyangwu
 * Date: 9/12/13
 * Time: 2:12 PM
 */
public class SearchinRotatedSortedArray {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0) return -1;

        int min = 0, max = A.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (A[mid] == target) return mid;
            if (min == max && A[min] != target) return -1;

            if (A[min] <= A[mid]) {
                // left is within the right order
                if (A[mid] > target) {
                    if (A[min] > target) min = mid + 1;
                    else max = mid - 1;
                }
                else min = mid + 1;
            } else {
                // right is within the right order
                if (A[mid] < target) {
                    if (A[max] < target) max = mid - 1;
                    else min = mid + 1;
                }
                else max = mid - 1;
            }
        }
        return -1;
    }
}
